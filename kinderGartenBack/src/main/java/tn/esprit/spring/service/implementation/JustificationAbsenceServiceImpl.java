package tn.esprit.spring.service.implementation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.JustificationAbsence;
import tn.esprit.spring.repository.IJustificationAbsenceRepository;
import tn.esprit.spring.service.interfaceS.IJustificationAbsenceService;
@Service
public class JustificationAbsenceServiceImpl implements IJustificationAbsenceService {

	@Autowired
	IJustificationAbsenceRepository justificationRepository;
	@Override
	public void addJustification(JustificationAbsence justificationAbsence) {
		justificationAbsence.setDate(new Date());
		justificationRepository.save(justificationAbsence);
		
	}

}
