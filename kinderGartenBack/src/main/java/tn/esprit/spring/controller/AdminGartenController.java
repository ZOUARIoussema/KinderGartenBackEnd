package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.service.interfaceS.IKinderGartenService;

@RestController
@RequestMapping("/admingarten")
@PreAuthorize("hasRole('ROLE_adminGarten')")
public class AdminGartenController {

	@Autowired
	IKinderGartenService iKinderGartenService;
	
	@PostMapping("/addKinderGarten")
	@ResponseBody
	public KinderGarten addKinderGarten(@RequestBody KinderGarten kendergarten)
	{
		iKinderGartenService.addKindergarten(kendergarten);
		return kendergarten;
	}
	
	@GetMapping(value = "/getKindergartenById/{kinderId}")
	   @ResponseBody
	   public KinderGarten getKindergartenById(@PathVariable("kinderId")int kinderId) {
			return iKinderGartenService.getKindergartenById(kinderId);
		}
	@GetMapping(value = "/getAllkinder")
    @ResponseBody
	public List<KinderGarten> getAllkinder() {
		
		return iKinderGartenService.getAllkinder();
	}
	@PutMapping(value = "/updateKinderGarten/{id}") 
	@ResponseBody
	public void updateKinderGarten(@PathVariable("id") int kenderId,@RequestBody KinderGarten kendergarten) {
		iKinderGartenService.updateKindergarten(kendergarten.getName(), kendergarten.getAdress(), kendergarten.getEmail(), kendergarten.getTel(), kendergarten.getLogo(), kenderId);
		
	}
	 @DeleteMapping("/deleteKindergartenById/{kenderId}") 
		@ResponseBody
		public void deleteKindergartenById(@PathVariable("kenderId")int kenderId) {
		 iKinderGartenService.deleteKindergartenById(kenderId);;
		}

	/*@PutMapping(value = "/affecterKinderAResponsible/{kinderId}/{ReponsibleId}") 
	public void affecterKinderAResponsible(@PathVariable("kinderId")int kinderId, @PathVariable("ReponsibleId")int ReponsibleId)
	{
		iKinderGartenService.affecterKinderAResponsible(kinderId, ReponsibleId);
	}
*/
}
