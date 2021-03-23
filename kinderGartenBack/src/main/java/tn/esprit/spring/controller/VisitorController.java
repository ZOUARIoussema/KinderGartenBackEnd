package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.service.interfaceS.ISwitchAccountService;
import tn.esprit.spring.utils.kinderGartenAlgorithm;

@RestController
@RequestMapping("/visitor")
@PreAuthorize("hasRole('ROLE_visitor')")
public class VisitorController {
	@Autowired
	ISwitchAccountService iswitchaccount;
	kinderGartenAlgorithm kindergartenalgorithme;
	@PostMapping("/addSwitchAccount")
	@ResponseBody
	public SwitchAccount addSwitchAccount(@RequestBody SwitchAccount switchAccount) {
		iswitchaccount.addSwitchAccount(switchAccount);
		return switchAccount;
	}
	@GetMapping(value="/getKinderGartenByAdress/{adress}")
	public List<KinderGarten> getKinderGartenByAdress(@PathVariable("adress")String adress) {
		return iswitchaccount.getKinderGartenByAdress(adress);
	}
	@GetMapping(value="/getAllKinderGarten/")
	public List<KinderGarten> getAllKinderGarten() {
		return iswitchaccount.getAllKinderGarden();
	}
	@GetMapping(value="/getKinderGartenBydistance/{lat}/{lon}")
	public List<KinderGarten> getKinderGartenBydistance(@PathVariable("lat")double lat1, @PathVariable("lon")double lon1){
		return iswitchaccount.Nearpoint(lat1, lon1);
		//return 15.8;
				
				
	} 
}
