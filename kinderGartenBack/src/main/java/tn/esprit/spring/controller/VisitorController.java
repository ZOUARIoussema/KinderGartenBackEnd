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

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.Statistique;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IEventService;
import tn.esprit.spring.service.interfaceS.ISwitchAccountService;

@RestController
@RequestMapping("/visitor")
@PreAuthorize("hasRole('ROLE_visitor')")
public class VisitorController {
	@Autowired
	ISwitchAccountService iswitchaccount;
	@Autowired
	IEventService iEventService;
	@PostMapping("/addSwitchAccount")
	@ResponseBody
	public SwitchAccount addSwitchAccount(@RequestBody SwitchAccount switchAccount) {
		iswitchaccount.addSwitchAccount(switchAccount);
		return switchAccount;
	}
	//controller of get kinder garden by Address
	@GetMapping(value="/getKinderGartenByAdress/{adress}")
	public List<KinderGarten> getKinderGartenByAdress(@PathVariable("adress")String adress) {
		return iswitchaccount.getKinderGartenByAdress(adress);
	}
	//controller of method of get all kindergarden
	@GetMapping(value="/getAllKinderGarten/")
	public List<KinderGarten> getAllKinderGarten() {
		return iswitchaccount.getAllKinderGarden();
	}
	//controller of the methode of get kindergarden by distance
	@GetMapping(value="/getKinderGartenBydistance/{lat}/{lon}")
	public List<KinderGarten> getKinderGartenBydistance(@PathVariable("lat")double lat1, @PathVariable("lon")double lon1){
		return iswitchaccount.Nearpoint(lat1, lon1);
		//return 15.8;
		
	} 
/*
	@GetMapping(value="/getStatistiqueEventBykindergarten/{id}")
	public List<Statistique> getStatistiqueEventBykindergarten(@PathVariable("id")int id){
		return iEventService.getStatistiqueEventBykindergarten(id);
		
	} 
	*/
	@GetMapping(value="/getmail/{id_user}")
	public List<Message> getmail (@PathVariable("id_user")int id){
		return  iswitchaccount.getmail(id);
		
	}
	@PostMapping(path = "/Sendmail")
	public void Sendmail(@RequestBody Message message) {
		 iswitchaccount.SendMail(message);


}
}
	
	
