package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Consultation;
import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.repository.IConsultationRepository;
import tn.esprit.spring.repository.IFolderMedicalRepository;
import tn.esprit.spring.service.interfaceS.IConsultationService;

@Service
public class ConsultationServiceImpl implements IConsultationService {

	@Autowired
	private IConsultationRepository consultationR;
	@Autowired
	private IFolderMedicalRepository folderR;

	@Override
	public void add(Consultation c) {
		c.setDateC(new Date());
		consultationR.save(c);

	}

	@Override
	public void update(Consultation c) {
		consultationR.save(c);

	}

	@Override
	public void delete(int id) {
		Consultation c = consultationR.findById(id).orElse(null);

		if (c != null) {
			consultationR.delete(c);
		}

	}

	@Override
	public List<Consultation> getAllByFolderMedical(int id) {

		FolderMedical f = folderR.findById(id).orElse(null);

		if (f != null) {
			return f.getLisConsultations();
		}

		return null;

	}

}
