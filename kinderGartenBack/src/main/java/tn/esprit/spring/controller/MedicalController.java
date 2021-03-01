package tn.esprit.spring.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.MedicalVisitKinderGarten;
import tn.esprit.spring.service.interfaceS.IMedicalVisitGartenService;

@RestController
@RequestMapping("/medical")
@PreAuthorize("hasRole('ROLE_doctor')")
public class MedicalController {

	@Autowired
	private IMedicalVisitGartenService medicalVisitGartenServiceS;

	/***
	 * 
	 * crud medical visit kinder garten
	 */

	@PostMapping("/addMedicalVisit")
	public void addMedicalVisit(@RequestBody MedicalVisitKinderGarten m) {

		medicalVisitGartenServiceS.add(m);
	}

	@PutMapping("/updateMedicalVisit")
	public void updateMedicalVisit(@RequestBody MedicalVisitKinderGarten m) {

		medicalVisitGartenServiceS.update(m);

	}

	@DeleteMapping("/deleteVisitMedical/{id}")
	public void deleteMedicalVisit(@PathVariable("id") int id) {
		medicalVisitGartenServiceS.remove(id);
	}

	@GetMapping("/getAllMedicalVisit")
	public List<MedicalVisitKinderGarten> getAll() {

		return medicalVisitGartenServiceS.findAll();

	}

}
