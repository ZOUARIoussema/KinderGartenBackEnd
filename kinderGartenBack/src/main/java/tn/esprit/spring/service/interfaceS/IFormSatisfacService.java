package tn.esprit.spring.service.interfaceS;

import tn.esprit.spring.entity.formSatisfac;

public interface IFormSatisfacService {

	
	
	public void planifierFormulaireStatisfaction(int id);
	
	public void addStatisfactionForm(formSatisfac fm);
	
	public void saveNumberResponses(int nbre_reponses,int parent_id,int id_form);
	
	
}
