package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.MedicalVisitKinderGarten;
import tn.esprit.spring.entity.User;

public interface IMedicalVisitGartenService {

	public void add(MedicalVisitKinderGarten medicalVisitKinderGarten);

	public void remove(int id);

	public void update(MedicalVisitKinderGarten m);

	public List<MedicalVisitKinderGarten> findAll();

}
