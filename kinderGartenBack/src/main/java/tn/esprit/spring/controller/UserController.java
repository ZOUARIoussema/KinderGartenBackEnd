package tn.esprit.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IUserService;

@RestController
@RequestMapping("/useradmin")
@PreAuthorize("hasRole('ROLE_admin')")
public class UserController {
 
	
	private static Logger log = LoggerFactory.getLogger(UserResourceImpl.class);
	 
	@Autowired
	private IUserService userS;
	
	
	
	@GetMapping("/findAll")
	public List<User>findall(){
		
		
		log.info("UserResourceImpl : findaAllUser");
		
		return  userS.getAll();
	}
	
	

}
