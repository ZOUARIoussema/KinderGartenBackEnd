package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.MedicalVisitKinderGarten;
import tn.esprit.spring.repository.IMedicalVisitKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IMedicalVisitGartenService;

@Service
public class MedicalVisitGartenServiceImpl implements IMedicalVisitGartenService {

	@Autowired
	IMedicalVisitKinderGartenRepository medicalVisitKinderGartenR;

	@Override
	public void add(MedicalVisitKinderGarten medicalVisitKinderGarten) {

		medicalVisitKinderGartenR.save(medicalVisitKinderGarten);

	}

	@Override
	public void remove(int id) {

		MedicalVisitKinderGarten medicalVisitKinderGarten = medicalVisitKinderGartenR.findById(id).orElse(null);

		if (medicalVisitKinderGarten != null) {

			medicalVisitKinderGartenR.delete(medicalVisitKinderGarten);
		}

	}

	@Override
	public void update(MedicalVisitKinderGarten m) {
		medicalVisitKinderGartenR.save(m);

	}

	@Override
	public List<MedicalVisitKinderGarten> findAll() {
		return (List<MedicalVisitKinderGarten>) medicalVisitKinderGartenR.findAll();
	}

}
