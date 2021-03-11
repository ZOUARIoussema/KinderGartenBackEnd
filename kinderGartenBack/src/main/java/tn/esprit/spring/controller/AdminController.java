package tn.esprit.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IClaimService;
import tn.esprit.spring.service.interfaceS.IStatisticsService;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_admin')")
public class AdminController {
	
	
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	IClaimService claimServ;
	
	@Autowired
	IStatisticsService staticsServ;
	
	@GetMapping(value="/getAllClaims")
	public List<Claim> getAllClaims() 
	{
	
		return claimServ.getAllClaims();
	}
	
	
	@PostMapping("/ChangeStateClaim")
	@ResponseBody
	public void ChangeStateClaim(@RequestBody Claim c) 
	{
		claimServ.ChangeStateClaim(c);
	}
	
	@GetMapping(value="/SearchClaimByType/{type}")
	
	public Claim SearchClaimByType(@PathVariable("type") String type)
	{
		return claimServ.SearchClaimByType(type);
	}
	
	@GetMapping(value="/SearchClaimByParent")
	@ResponseBody
	
	public Claim SearchClaimByParent(@RequestBody User u)
	{
		return claimServ.SearchClaimByParent(u);
		
	}

	
	@GetMapping(value="/getNbrClaims/{id}")
	
	public int GetNbrClaimsKinderGarten(@PathVariable("id") int id)
	{
		log.info("Number of claims in kindergarten is :");
		return claimServ.countClaimsinKinderGarten(id);
	}
	
	@GetMapping(value="/getClaimsByObject")
	
	public List<Claim> getClaimsByObject()
	{
		return claimServ.getClaimsByObject();
	}
	
	@GetMapping(value="/getAllParents")
	
	public List<User> getAllParents()
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
	
	
	// nb des enfants par jardin d'enfant
	
	@GetMapping(value ="/retrieve-ChildrensByKinderGarten")
	public List<?> getEnfantParJardin() {
		return staticsServ.listChildByKinderGarten();
	}
	
	//best user meilleur score d'évaluation
	@GetMapping(value ="/bestUser")
	public List<?> getBestUser() 
	{

	return staticsServ.BestUser();

	}
	
	// number of comments by parent
	
	//GetMapping(value="/retrieve-number-comments-user/{id}")
	
	
}
