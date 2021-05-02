package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Consultation;

public interface IConsultationService {
	
	public void add(Consultation c);
	public void update(Consultation c);
	public void delete(int id);
	public List<Consultation>getAllByFolderMedical(int id);
	public List<Consultation>getAllConsultation();
	public Consultation getById(int id);
	
	

}
