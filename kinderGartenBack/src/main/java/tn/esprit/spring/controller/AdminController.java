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

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IClaimService;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_admin')")
public class AdminController {
	
	
	@Autowired
	IClaimService claimServ;
	
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


	
	
}
