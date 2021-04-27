package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.JustificationAbsence;


public interface IJustificationAbsenceService {
	public void addJustification(JustificationAbsence justificationAbsence);
	public List<JustificationAbsence> getAllByUser(int id);

}
