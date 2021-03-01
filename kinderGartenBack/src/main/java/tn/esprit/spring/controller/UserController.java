package tn.esprit.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.ISwitchAccountService;
import tn.esprit.spring.service.interfaceS.IUserService;

@RestController
@RequestMapping("/useradmin")
@PreAuthorize("hasRole('ROLE_admin')")
public class UserController {
 
	
	private static Logger log = LoggerFactory.getLogger(UserResourceImpl.class);
	 
	@Autowired
	private IUserService userS;
	
	@Autowired
	private ISwitchAccountService switchSer;
	
	@PostMapping("/AddUser")
	@ResponseBody
	public void addUser(@RequestBody User u)
	{
		userS.add(u);
	}
	
	
	@GetMapping("/findAll")
	public List<User>findall(){
		
		
		log.info("UserResourceImpl : findaAllUser");
		
		return  userS.getAll();
	}
	
	
	@GetMapping("/findUserByEmail/{email}")
	public User findUserByMail (@PathVariable("email") String email )
	{
		return userS.findByEmail(email);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		
		 userS.delete(id);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody User user) {
		
		userS.update(user);
	}
	
	
	@PostMapping("/ChangeStateUser")
    @ResponseBody
			
	public void ChangeStateUser(@RequestBody User u)
	{
		log.info("User state changed  sucessfully !!!");
		userS.ChangeStateUser(u);
	}
	
	@PostMapping("/CreateRequestForSwitchingAccount")
	@ResponseBody
	
	public int addSwitchAccount(@RequestBody SwitchAccount sw) 
	{
		log.info("Request for switching account created successfully !");
		return switchSer.addSwitchAccount(sw);
	}
	
	
	@GetMapping("/ChangeAccountByAdmin")
	
	public void RequestForSwitchingAccount(SwitchAccount sw) 
	{
		log.info("account switched created successfully !");
		 switchSer.RequestForSwitchingAccount(sw);
	}

}
