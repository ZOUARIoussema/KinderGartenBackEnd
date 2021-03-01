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

@RestController
@RequestMapping("/visitor")
@PreAuthorize("hasRole('ROLE_visitor')")
public class VisitorController {
	@Autowired
	ISwitchAccountService iswitchaccount;
	@PostMapping("/addSwitchAccount")
	@ResponseBody
	public SwitchAccount addSwitchAccount(@RequestBody SwitchAccount switchAccount) {
		iswitchaccount.addSwitchAccount(switchAccount);
		return switchAccount;
	}
	@GetMapping(value = "/getKinderByAdress/{adress}")
	@ResponseBody
	public List<KinderGarten> getKinderByAdress(@PathVariable("adress") String adress) {

		return (List<KinderGarten>)iswitchaccount.getKinderGarten(adress);
	}

}
