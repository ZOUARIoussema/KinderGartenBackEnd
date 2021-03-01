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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.entity.MedicalVisitKinderGarten;
import tn.esprit.spring.service.interfaceS.IFolderMedicalService;
import tn.esprit.spring.service.interfaceS.IMedicalVisitGartenService;

@RestController
@RequestMapping("/medical")
@PreAuthorize("hasRole('ROLE_doctor')")
public class MedicalController {

	@Autowired
	private IMedicalVisitGartenService medicalVisitGartenServiceS;

	@Autowired
	private IFolderMedicalService folderMS;

	/***
	 * 
	 * crud medical visit kinder garten
	 */

	@PostMapping("/addMedicalVisit")
	@ResponseBody
	public void addMedicalVisit(@RequestBody MedicalVisitKinderGarten m) {

		medicalVisitGartenServiceS.add(m);
	}

	@PutMapping("/updateMedicalVisit")
	@ResponseBody
	public void updateMedicalVisit(@RequestBody MedicalVisitKinderGarten m) {

		medicalVisitGartenServiceS.update(m);

	}

	@DeleteMapping("/deleteVisitMedical/{id}")
	@ResponseBody
	public void deleteMedicalVisit(@PathVariable("id") int id) {
		medicalVisitGartenServiceS.remove(id);
	}

	@GetMapping("/getAllMedicalVisit")
	@ResponseBody
	public List<MedicalVisitKinderGarten> getAll() {

		return medicalVisitGartenServiceS.findAll();

	}

	/***
	 * 
	 * crud folder medical
	 * 
	 * 
	 */

	@PostMapping("/addFolderMedical")
	@ResponseBody
	public void addFolderMedical(@RequestBody FolderMedical f) {

		folderMS.add(f);

	}

	@DeleteMapping("/deleteFolderMedical")
	@ResponseBody
	public void deleteFolderMedical(int id) {
		folderMS.delete(id);
	}

	@PutMapping("/updateFolderMedical")
	@ResponseBody
	public void updateFolderMedical(@RequestBody FolderMedical f) {

		folderMS.update(f);

	}

	@GetMapping("/getFoldderMedical/{id}")
	@ResponseBody
	public FolderMedical getFolderByChild(@PathVariable int id) {

		return folderMS.getFolderByChild(id);

	}

}
