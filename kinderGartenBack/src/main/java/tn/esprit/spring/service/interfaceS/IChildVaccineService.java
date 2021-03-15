package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.ChildVaccine;

public interface IChildVaccineService {
	
	
	public void add(ChildVaccine c);
	public void delete(int id);
	public void update(ChildVaccine c);
	public List<ChildVaccine> getAll();
	
	
}
