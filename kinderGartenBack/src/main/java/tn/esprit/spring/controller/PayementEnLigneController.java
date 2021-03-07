package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;

@RestController
@RequestMapping("/pay")
@PreAuthorize("hasRole('ROLE_parent')")
public class PayementEnLigneController {

	@Autowired
	IPayementSubscriptionService payementS;

	@PostMapping("/paySubscriptionOnLine")
	@ResponseBody
	public void addPay(@RequestBody PayementSubscription p) {

		payementS.addPayementEnLigne(p);

	}

}
