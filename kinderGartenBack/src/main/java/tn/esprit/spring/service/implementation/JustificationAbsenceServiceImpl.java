package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.JustificationAbsence;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IJustificationAbsenceRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IJustificationAbsenceService;
@Service
public class JustificationAbsenceServiceImpl implements IJustificationAbsenceService {

	@Autowired
	IJustificationAbsenceRepository justificationRepository;
	@Autowired
	private IUserRepository userR;
	@Override
	public void addJustification(JustificationAbsence justificationAbsence) {
		justificationAbsence.setDate(new Date());
		justificationRepository.save(justificationAbsence);
		
	}
	@Override
	public List<JustificationAbsence> getAllByUser(int id) {
		User u = userR.findById(id).orElse(null);

		if (u != null) {

			return u.getListJustificationAdsences();
		}

		return null;

	}

}
