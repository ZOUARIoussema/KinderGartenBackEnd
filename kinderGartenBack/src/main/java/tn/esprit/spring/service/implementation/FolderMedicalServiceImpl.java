package tn.esprit.spring.service.implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.config.mail.EmailRequestDTO;
import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.ChildVaccine;
import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IChildVaccineRep;
import tn.esprit.spring.repository.IFolderMedicalRepository;
import tn.esprit.spring.service.interfaceS.IFolderMedicalService;
import tn.esprit.spring.service.interfaceS.IMailService;

@EnableScheduling
@Service
public class FolderMedicalServiceImpl implements IFolderMedicalService {

	
	private static Logger logger = LoggerFactory.getLogger(IFolderMedicalService.class);
	
	
	@Autowired
	IFolderMedicalRepository folderR;
	@Autowired
	IChildRepository childR;
	@Autowired
	IChildVaccineRep childVR;

	@Autowired
	IMailService mailS;

	@Override
	public void add(FolderMedical f) {

		folderR.save(f);

	}

	@Override
	public void delete(int id) {

		FolderMedical f = folderR.findById(id).orElse(null);

		if (f != null) {

			folderR.delete(f);
		}

	}

	@Override
	public void update(FolderMedical f) {

		folderR.save(f);

	}

	private long durationMonths(LocalDate dateBefore, LocalDate dateAfter) {

		if (dateBefore.getDayOfMonth() > 28) {
			dateBefore = dateBefore.minusDays(5);
		} else if (dateAfter.getDayOfMonth() > 28) {
			dateAfter = dateAfter.minusDays(5);
		}
		return ChronoUnit.MONTHS.between(dateBefore, dateAfter);
	}

	public List<ChildVaccine> listChildVaccineToDo(FolderMedical f, int nbMonth) {
		
		logger.info("**** age child  : {}", nbMonth+" (Month)");

		List<ChildVaccine> list = new ArrayList<ChildVaccine>();

		for (ChildVaccine childVaccine : childVR.findAll()) {

			if ( childVaccine.getMonthNumber()<=nbMonth && f.getLisChildVaccines().contains(childVaccine) == false) {

				list.add(childVaccine);
			}

		}

		return list;

	}

	@Override
	public FolderMedical getFolderByChild(int id) {

		FolderMedical folderMedical = new FolderMedical();

		List<ChildVaccine> listVaccineToDo = new ArrayList<ChildVaccine>();

		int nbM = 0;

		Child c = childR.findById(id).orElse(null);

		if (c != null) {

			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

			String dSystem = dateFormatter.format(new Date());

			String dOfBirth = dateFormatter.format(c.getDateOfbith());

			nbM = (int) durationMonths(LocalDate.parse(dOfBirth), LocalDate.parse(dSystem));

			folderMedical = c.getFolderMedical();

			folderMedical.getChild().setAge(nbM);

			listVaccineToDo = this.listChildVaccineToDo(folderMedical, nbM);

			if (listVaccineToDo.size() != 0) {

				folderMedical.setListVaccinesToDo(listVaccineToDo);

			}

			return folderMedical;
		}

		return folderMedical;

	}

	@Scheduled(cron = "0 0 0 1 * ?", zone = "Africa/Tunis")
	@Override
	public void alertVaccineChildToDo() {

		for (Child child : childR.findAll()) {

			if (this.getFolderByChild(child.getId()).getListVaccinesToDo().size() != 0) {

				Map<String, String> model = new HashMap<>();
				model.put("name", child.getName());
				model.put("lien", "http://localhost:8081/medical/alertVaccineChild/" + child.getId());

				EmailRequestDTO email = new EmailRequestDTO();

				// email.setTo("oussema.zouari@esprit.tn");
				email.setTo(child.getParent().getEmail());
				email.setSubject("Vaccine child");

				mailS.sendMailWithFreeMarker(email, model, "alertVaccineChild.ftl");

			}

		}
	}

	@Override
	public FolderMedical getFolderById(int id) {
		return folderR.findById(id).orElse(null);
	}

}
