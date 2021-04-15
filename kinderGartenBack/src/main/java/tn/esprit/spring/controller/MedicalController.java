package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.lowagie.text.DocumentException;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.ChildVaccine;
import tn.esprit.spring.entity.Consultation;
import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.entity.MedicalVisitKinderGarten;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.repository.IConsultationRepository;
import tn.esprit.spring.service.interfaceS.IChildService;
import tn.esprit.spring.service.interfaceS.IChildVaccineService;
import tn.esprit.spring.service.interfaceS.IConsultationService;
import tn.esprit.spring.service.interfaceS.IFolderMedicalService;
import tn.esprit.spring.service.interfaceS.IMedicalVisitGartenService;
import tn.esprit.spring.utils.DetailVaccineChild;
import tn.esprit.spring.utils.DetailSubscriptionChild;

@RestController
@RequestMapping("/medical")
//@PreAuthorize("hasRole('ROLE_doctor')")
public class MedicalController {

	@Autowired
	private IMedicalVisitGartenService medicalVisitGartenServiceS;

	@Autowired
	private IFolderMedicalService folderMS;

	@Autowired
	private IConsultationService consultationS;

	@Autowired
	private IChildVaccineService childVaccinServ;

	@Autowired
	private IChildService childService;

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

	@PostMapping("/addFolderMedical/{id}")
	@ResponseBody
	public void addFolderMedical(@RequestBody FolderMedical f, @PathVariable("id") int id) {

		folderMS.add(f, id);

	}

	@DeleteMapping("/deleteFolderMedical/{id}")
	@ResponseBody
	public void deleteFolderMedical(@PathVariable("id") int id) {
		folderMS.delete(id);
	}

	@PutMapping("/updateFolderMedical/{id}")
	@ResponseBody
	public void updateFolderMedical(@RequestBody FolderMedical f, @PathVariable("id") int id) {

		folderMS.update(f, id);

	}

	@GetMapping("/getFoldderMedicalByChild/{id}")
	@ResponseBody
	public FolderMedical getFolderByChild(@PathVariable int id) {

		return folderMS.getFolderByChild(id);

	}

	@GetMapping("/getFoldderMedicalById/{id}")
	@ResponseBody
	public FolderMedical getFolderById(@PathVariable int id) {

		return folderMS.getFolderById(id);

	}

	@GetMapping("/getAllFolderMedical")
	@ResponseBody
	public List<FolderMedical> getAllFolderMedical() {

		return folderMS.getAllFolder();

	}

	/***
	 * 
	 * 
	 * crud medical consulation
	 * 
	 * 
	 */

	@PostMapping("/addMedicalConsultation")
	@ResponseBody
	public void addMedicalConsultation(@RequestBody Consultation c) {

		consultationS.add(c);

	}

	@DeleteMapping("/deleteConsultation/{id}")
	@ResponseBody
	public void deleteConsultation(@PathVariable("id") int id) {

		consultationS.delete(id);
	}

	@PutMapping("/updateConsultationMedical")
	@ResponseBody
	public void updateConsultation(@RequestBody Consultation c) {
		consultationS.update(c);

	}

	@GetMapping("getAllConsultationByFolderMedical/{id}")
	@ResponseBody
	public List<Consultation> getAllConSultationByFolder(@PathVariable("id") int id) {

		return consultationS.getAllByFolderMedical(id);
	}

	@GetMapping("getAllConsultation")
	@ResponseBody
	public List<Consultation> getAllConSultationByFolder() {

		return consultationS.getAllConsultation();
	}
	
	@GetMapping("getConsultationById/{id}")
	@ResponseBody
	public Consultation getConsultationById(@PathVariable("id") int id) {

		return consultationS.getById(id);
	}

	/*
	 * 
	 * Crud child vaccine
	 */

	@PostMapping("/addVaccineChild")
	@ResponseBody
	public void addChildVaccine(@RequestBody ChildVaccine c) {

		childVaccinServ.add(c);
	}

	@PutMapping("/updateVaccineChild")
	@ResponseBody
	public void updateVaccineChild(@RequestBody ChildVaccine c) {
		childVaccinServ.update(c);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteVaccineChild(@PathVariable int id) {

		childVaccinServ.delete(id);
	}

	@GetMapping("/getAllChildVaccine")
	@ResponseBody
	public List<ChildVaccine> getAllChildVaccine() {

		return childVaccinServ.getAll();
	}

	@GetMapping("/getVaccineById/{id}")
	@ResponseBody
	public ChildVaccine getVaccineById(@PathVariable int id) {

		return childVaccinServ.findById(id);
	}

	@PreAuthorize("isAnonymous()")
	@GetMapping("/alertVaccineChild/{id}")
	public void exportToPDF(HttpServletResponse response, @PathVariable("id") int id)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		FolderMedical f = folderMS.getFolderByChild(id);

		if (f != null) {

			DetailVaccineChild exporter = new DetailVaccineChild(f);
			exporter.export(response);
		}

	}

	@GetMapping("/getAllChild")
	@ResponseBody
	public List<Child> getAllChild() {

		return childService.getAllChild();

	}

}
