package tn.esprit.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.config.mail.EmailRequestDTO;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.service.interfaceS.IMailService;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;

@RestController
@RequestMapping("/pay")
@PreAuthorize("hasRole('ROLE_parent')")
public class PayementEnLigneController {

	@Autowired
	IPayementSubscriptionService payementS;

	@Autowired
	ISubscriptionChildService subscriptionChildS;

	@Autowired
	IMailService mailS;

	@PostMapping("/paySubscriptionOnLine/{mail}")
	@ResponseBody
	public void addPay(@RequestBody PayementSubscription p, @PathVariable("mail") String mail) {

		payementS.addPayementEnLigne(p);

		// send mail

		SubscriptionChild subscriptionChild = subscriptionChildS.getById(p.getSubscriptionChild().getId());

		Map<String, String> model = new HashMap<>();
		model.put("name", subscriptionChild.getChild().getName());
		model.put("total", String.valueOf(p.getPrice()));
		model.put("method", p.getTypePayement().toString());
		model.put("rest", String.valueOf(subscriptionChild.getRestPay()));

		EmailRequestDTO email = new EmailRequestDTO();

		email.setTo(mail);
		email.setSubject("recived payement subscription child");

		mailS.sendMailWithFreeMarker(email, model, "recivedPayement.ftl");

	}

}
