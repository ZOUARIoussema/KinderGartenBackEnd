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

import tn.esprit.spring.entity.Spent;
import tn.esprit.spring.service.interfaceS.ISpentService;

@RestController
@RequestMapping("/accounting")
@PreAuthorize("hasRole('ROLE_agentCashier')")
public class AccountingController {

	@Autowired
	private ISpentService spentS;

	/**
	 * 
	 * 
	 * 
	 * crud spent
	 */

	@PostMapping("/addSpent")
	@ResponseBody
	public void addSpent(@RequestBody Spent s) {

		spentS.add(s);

	}

	@DeleteMapping("/deleteSpent/{id}")
	@ResponseBody
	public void deleteSpent(@PathVariable("id") int id) {

		spentS.delete(id);

	}

	@PutMapping("/updateSpent")
	@ResponseBody
	public void updateSpent(@RequestBody Spent s) {

		spentS.update(s);

	}

	@GetMapping("/getAllSpentByAgent/{id}")
	@ResponseBody
	public List<Spent> getAllByAgent(@PathVariable int id) {

		return spentS.getAllByAgentCashier(id);
	}

}
