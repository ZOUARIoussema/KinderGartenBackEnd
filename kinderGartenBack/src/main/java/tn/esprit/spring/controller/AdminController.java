package tn.esprit.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IClaimService;
import tn.esprit.spring.service.interfaceS.IFormSatisfacService;
import tn.esprit.spring.service.interfaceS.IKinderGartenService;
import tn.esprit.spring.service.interfaceS.IStatisticsService;
import tn.esprit.spring.service.interfaceS.IUserService;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_admin')")
public class AdminController {
	
	
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	IClaimService claimServ;
	
	@Autowired
	IStatisticsService staticsServ;
	
	@Autowired
	IUserService userservices;
	
	@Autowired 
	IKinderGartenService kinderservice;
	
	
	@Autowired
	IFormSatisfacService formservice;
	
	//************ CLaims *************************//
	
	@GetMapping(value="/getAllClaims")
	public List<Claim> getAllClaims() 
	{
	
		return claimServ.getAllClaims();
	}
	
	
	@GetMapping("/ChangeStateClaim/{idclaim}")
	@ResponseBody
	public String ChangeStateClaim(@PathVariable("idclaim") int claim) 
	{
		return claimServ.ChangeStateClaim(claim);
	}
	
	@GetMapping(value="/SearchClaimByType/{type}")
	
	public List<Claim> SearchClaimByType(@PathVariable("type") String type)
	{
		return claimServ.SearchClaimByType(type);
	}
	
	
	@GetMapping(value="/SearchClaimByParent/{parentname}")
	@ResponseBody
	
	public List<Claim> SearchClaimByParent(@PathVariable("parentname")  String parentname)
	{
		return claimServ.SearchClaimByParent(parentname);
		
	}
	

	@GetMapping(value="/getClaimById/{id}")
	public Claim getClaimsById(@PathVariable("id") int id)
	{
		return claimServ.getClaimsById(id);
	}
	
	@GetMapping(value="/getNbrClaims/{id}")
	
	public String GetNbrClaimsKinderGarten(@PathVariable("id") int id)
	{
		return "Number of claims in kindergarten is :" +claimServ.countClaimsinKinderGarten(id);
	}
	
	
	@GetMapping(value="/getClaimsByObject")
	
	public List<Claim> getClaimsByObject()
	{
		return claimServ.getClaimsByObject();
	}
	
	@GetMapping(value="/getAllParents")
	
	public List<String> getAllParents()
	{
		return claimServ.getAllParents();
	}
	
	@GetMapping(value="/getClaimsByEducation")
	public List<Claim> getClaimsByEducation() 
	{
		return claimServ.getClaimsByEducation();
	}
	
	@GetMapping(value="/getClaimsByCleanliness")
	public List<Claim> getClaimsByCleanliness() 
	{
		return claimServ.getClaimsByCleanliness();
	}
	//****************************************************//
	
	
	
	//***********Statistics*********************//
	
	// nb des enfants par jardin d'enfant
	
	@GetMapping(value ="/retrieve-ChildrensByKinderGarten")
	public List<?> getEnfantParJardin() {
		return staticsServ.listChildByKinderGarten();
	}
	
	@GetMapping(value="/numberPublicationByParent")
	public List<?> nbrPublicationByUser() 
	{
		return staticsServ.nbrPublicationByUser();
	}
	
	
	@GetMapping(value="/numberLikeByParent")
	public List<?> NbrLikeByUser() 
	{
		return staticsServ.NbrLikeByUser();
	}
	
	//nombre de participants dans les events dans chaque jardin d'entfants
	
	@GetMapping(value="/numberParticipantsKinderGarten")
	public List<?> numberParticipEventKinderGaten()
	{
		return staticsServ.numberParticipEventKinderGaten();
	}
	
	//number of comments by parent
	
	@GetMapping(value="/retrieve-number-comments-user")
	
	 public List<?> NbrCommentsByUser ()
	{
		return staticsServ.NbrCommentsByUser();
	}
	
	
	@GetMapping(value="/getChildsSubscribed/{year}")
	
	public List<?> getChildsSubscribed(@PathVariable("year") int year)
	{
		return staticsServ.NbrChildSubscribed(year);
	}
	
	//*****************************************************//
	
	//*********** Kinder garten managment ********************//
	
	@GetMapping(value="/sendAlertToResponsible/{id}")
	public void sendMailAlertToResponsibleKinderGarten(@PathVariable("id") int kg_id) 
	{
		userservices.sendMailAlertToResponsibleKinderGarten(kg_id);
	}
	
	@GetMapping(value="/GetKinderGartensByScoreEval")
	public List<KinderGarten> TriKinderGartenByScoreEval()
	{
		return kinderservice.TriKinderGartenByScoreEval();
	}
	
	
	@GetMapping(value="/planifyFormSatisfac/{id}")
	public void planifierFormulaireStatisfaction(@PathVariable("id") int id)
	{
		 formservice.planifierFormulaireStatisfaction(id);
	}
	
	@PutMapping(value="/UpdateScoreEvaluation/{idkindergarten}")
	@ResponseBody
	public void  UpdateScoreEvaluationKinderGarten(@PathVariable("idkindergarten") int kindergarten)
	{
		
		staticsServ.UpdateScoreEvaluation(kindergarten);
	}
	
	//********************************************//
}
