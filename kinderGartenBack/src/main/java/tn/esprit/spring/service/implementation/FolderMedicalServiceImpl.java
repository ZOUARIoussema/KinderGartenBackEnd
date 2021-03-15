package tn.esprit.spring.service.implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.ChildVaccine;
import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IChildVaccineRep;
import tn.esprit.spring.repository.IFolderMedicalRepository;
import tn.esprit.spring.service.interfaceS.IFolderMedicalService;

@Service
public class FolderMedicalServiceImpl implements IFolderMedicalService {

	@Autowired
	IFolderMedicalRepository folderR;
	@Autowired
	IChildRepository childR;
	@Autowired
	IChildVaccineRep childVR;

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

		List<ChildVaccine> list = new ArrayList<ChildVaccine>();

		for (ChildVaccine childVaccine : childVR.findByMonthNumber(nbMonth)) {

			if (f.getLisChildVaccines().contains(childVaccine) == false) {

				list.add(childVaccine);
			}

		}

		return list;

	}

	@Override
	public FolderMedical getFolderByChild(int id) {

		FolderMedical folderMedical = null;

		List<ChildVaccine> listVaccineToDo = new ArrayList<ChildVaccine>();

		int nbM = 0;

		Child c = childR.findById(id).orElse(null);

		if (c != null) {

			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

			String dSystem = dateFormatter.format(new Date());

			String dOfBirth = dateFormatter.format(c.getDateOfbith());

			nbM = (int) durationMonths(LocalDate.parse(dOfBirth), LocalDate.parse(dSystem));

			System.out.println("resulta:" + nbM);

			folderMedical = c.getFolderMedical();

			listVaccineToDo = this.listChildVaccineToDo(folderMedical, nbM);

			if (listVaccineToDo.size() != 0) {

				folderMedical.setListVaccinesToDo(listVaccineToDo);

			}

			return folderMedical;
		}

		return folderMedical;

	}

}
