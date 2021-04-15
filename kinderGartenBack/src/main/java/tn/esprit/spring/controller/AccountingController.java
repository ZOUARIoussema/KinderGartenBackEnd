package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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

import tn.esprit.spring.config.mail.EmailRequestDTO;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.Spent;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.service.interfaceS.IFidelityPointService;
import tn.esprit.spring.service.interfaceS.IMailService;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;
import tn.esprit.spring.service.interfaceS.ISpentService;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;
import tn.esprit.spring.utils.DetailSubscriptionChild;
import tn.esprit.spring.utils.ReportAccountingExel;

import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/accounting")
//@PreAuthorize("hasRole('ROLE_agentCashier')")
public class AccountingController {

	@Autowired
	private ISpentService spentS;

	@Autowired
	private ISubscriptionChildService subscriptionChildS;

	@Autowired
	private IMailService mailS;

	@Autowired
	private IPayementSubscriptionService payementS;

	@Autowired
	private IFidelityPointService fidelityS;

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

	@GetMapping("/getSpentById/{id}")
	@ResponseBody
	public Spent getSpentById(@PathVariable int id) {

		return spentS.findById(id);
	}

	/**
	 * 
	 * crud payement subscription
	 * 
	 * 
	 */

	@PostMapping("/addPayementHandToHand/{mail}")
	@ResponseBody
	public void addPayementSubscription(@RequestBody PayementSubscription p, @PathVariable("mail") String mail) {

		payementS.add(p);

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

	@PutMapping("/updatePayementHandToHand")
	@ResponseBody
	public void updatePayementSubscriptionHandToHand(@RequestBody PayementSubscription p) {

		payementS.update(p);
	}

	@GetMapping("/getAllPayementByUser/{id}")
	@ResponseBody
	public List<PayementSubscription> getAllByUser(@PathVariable("id") int id) {

		return payementS.getAllByUser(id);
	}

	@GetMapping("/getAllPayementBySubscription/{id}")
	@ResponseBody
	public List<PayementSubscription> getAllBySubscription(@PathVariable("id") int id) {

		return payementS.getAllBySubscriptionChild(id);
	}

	/**
	 * report accounting exel
	 * 
	 */
	@PreAuthorize("isAnonymous()")
	@GetMapping("/export/excel/{date}")
	public void exportToExcel(HttpServletResponse response,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		ReportAccountingExel excelExporter = new ReportAccountingExel(payementS.findByDate(d), spentS.findByDate(d));

		excelExporter.export(response);
	}

	@PreAuthorize("isAnonymous()")
	@GetMapping("/detailSubscription/{id}")
	public void exportToPDF(HttpServletResponse response, @PathVariable("id") int id)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		SubscriptionChild s = subscriptionChildS.getById(id);

		DetailSubscriptionChild exporter = new DetailSubscriptionChild(s);
		exporter.export(response);

	}

	/**
	 * transfert point fidelity in discount
	 * 
	 */

	@PutMapping("/transfertPointFidelity/{idS}/{p}")
	@ResponseBody
	public void transfertPointFidelity(@PathVariable("idS") int idSub, @PathVariable("p") double point) {

		fidelityS.transfertPointFidelity(idSub, point);

	}

}
