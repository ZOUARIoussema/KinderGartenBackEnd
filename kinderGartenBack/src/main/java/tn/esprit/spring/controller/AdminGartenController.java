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

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.service.interfaceS.ICategorySubscriptionService;
import tn.esprit.spring.service.interfaceS.IExtraService;
import tn.esprit.spring.service.interfaceS.IKinderGartenService;

@RestController
@RequestMapping("/admingarten")
@PreAuthorize("hasRole('ROLE_adminGarten')")
public class AdminGartenController {

	@Autowired
	IKinderGartenService iKinderGartenService;
	@Autowired
	IExtraService iExtraService;
	@Autowired
	ICategorySubscriptionService iCategorySubscriptionService;

	@PostMapping("/addKinderGarten")
	@ResponseBody
	public KinderGarten addKinderGarten(@RequestBody KinderGarten kendergarten) {
		iKinderGartenService.addKindergarten(kendergarten);
		return kendergarten;
	}

	@GetMapping(value = "/getKindergartenById/{kinderId}")
	@ResponseBody
	public KinderGarten getKindergartenById(@PathVariable("kinderId") int kinderId) {
		return iKinderGartenService.getKindergartenById(kinderId);
	}

	@GetMapping(value = "/getAllkinder")
	@ResponseBody
	public List<KinderGarten> getAllkinder() {

		return iKinderGartenService.getAllkinder();
	}

	@PutMapping(value = "/updateKinderGarten/{id}")
	@ResponseBody
	public void updateKinderGarten(@PathVariable("id") int kenderId, @RequestBody KinderGarten kendergarten) {
		iKinderGartenService.updateKindergarten(kendergarten.getName(), kendergarten.getAdress(),
				kendergarten.getEmail(), kendergarten.getTel(), kendergarten.getLogo(), kenderId);

	}

	@DeleteMapping("/deleteKindergartenById/{kenderId}")
	@ResponseBody
	public void deleteKindergartenById(@PathVariable("kenderId") int kenderId) {
		iKinderGartenService.deleteKindergartenById(kenderId);
		;
	}

	/*
	 * @PutMapping(value =
	 * "/affecterKinderAResponsible/{kinderId}/{ReponsibleId}") public void
	 * affecterKinderAResponsible(@PathVariable("kinderId")int
	 * kinderId, @PathVariable("ReponsibleId")int ReponsibleId) {
	 * iKinderGartenService.affecterKinderAResponsible(kinderId, ReponsibleId);
	 * }
	 */

	// Extra ...

	@PostMapping("/addExtra")
	@ResponseBody
	public Extra addExtra(@RequestBody Extra extra) {
		iExtraService.addExtra(extra);
		return extra;
	}

	@GetMapping(value = "/getExtraById/{extraId}")
	@ResponseBody
	public Extra getExtraById(@PathVariable("extraId") int extraId) {
		return iExtraService.getExtraById(extraId);
	}

	@GetMapping(value = "/getAllextra")
	@ResponseBody
	public List<Extra> getAllextra() {

		return iExtraService.getAllextra();
	}

	@PutMapping(value = "/updateExtra/{id}")
	@ResponseBody
	public void updateExtra(@PathVariable("id") int ExtraId, @RequestBody Extra extra) {
		iExtraService.updateExtra(extra.getDescription(), extra.getPrice(), ExtraId);

	}

	@DeleteMapping("/deleteExtraById/{extraId}")
	@ResponseBody
	public void deleteExtraById(@PathVariable("extraId") int extraId) {
		iExtraService.deleteExtraById(extraId);
	}

	@PutMapping(value = "/affecterExtraAkinderGarten/{extraId}/{kinderId}")
	public void affecterExtraAkinderGarten(@PathVariable("extraId") int extraId,
			@PathVariable("kinderId") int kinderId) {
		iExtraService.affecterExtraAkinderGarten(extraId, kinderId);
		
	}
	
	// categorySubscription...
	
	@PostMapping("/addCategorySubscription")
	@ResponseBody
	public CategorySubscription addCategorySubscription(@RequestBody CategorySubscription categorySubscription) {
		iCategorySubscriptionService.addCategorySubscription(categorySubscription);
		return categorySubscription;
	}
	
	@GetMapping(value = "/getCategorySubscriptionById/{categorySubscriptionId}")
	@ResponseBody
	public CategorySubscription getCategorySubscriptionById(@PathVariable("categorySubscriptionId") int categorySubscriptionId) {
		return iCategorySubscriptionService.getCategorySubscriptionById(categorySubscriptionId);
	}

	@GetMapping(value = "/getAllCategorySubscription")
	@ResponseBody
	public List<CategorySubscription> getAllCategorySubscription() {

		return iCategorySubscriptionService.getAllCategorySubscription();
	}
	
	@PutMapping(value = "/updateCategorySubscription/{id}")
	@ResponseBody
	public void updateCategorySubscription(@PathVariable("id") int categorySubscriptionId, @RequestBody CategorySubscription categorySubscription) {
		iCategorySubscriptionService.updateCategorySubscription(categorySubscription.getDescription(), categorySubscription.getPrice(), categorySubscriptionId);

	}

	@DeleteMapping("/deleteCategorySubscriptionById/{categorySubscriptionId}")
	@ResponseBody
	public void deleteCategorySubscriptionById(@PathVariable("categorySubscriptionId") int categorySubscriptionId) {
		iCategorySubscriptionService.deleteCategorySubscriptionById(categorySubscriptionId);
	}

	@PutMapping(value = "/affecterCategorySubscriptionAkinderGarten/{categorySubscriptionId}/{kinderId}")
	public void affecterCategorySubscriptionAkinderGarten(@PathVariable("categorySubscriptionId") int categorySubscriptionId,
			@PathVariable("kinderId") int kinderId) {
		iCategorySubscriptionService.affecterCategorySubscriptionAkinderGarten(categorySubscriptionId, kinderId);
		
	}
	
}
