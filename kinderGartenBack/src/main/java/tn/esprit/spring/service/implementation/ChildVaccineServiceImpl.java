package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ChildVaccine;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IChildVaccineRep;
import tn.esprit.spring.service.interfaceS.IChildVaccineService;

@Service
public class ChildVaccineServiceImpl implements IChildVaccineService {

	@Autowired
	IChildVaccineRep ChildVaccineRep;

	@Override
	public void add(ChildVaccine c) {
		ChildVaccineRep.save(c);

	}

	@Override
	public void delete(int id) {

		ChildVaccine c = ChildVaccineRep.findById(id).orElse(null);

		if (c != null) {

			ChildVaccineRep.delete(c);
		}

	}

	@Override
	public void update(ChildVaccine c) {
		ChildVaccineRep.save(c);

	}

	@Override
	public List<ChildVaccine> getAll() {
		return (List<ChildVaccine>) ChildVaccineRep.findAll();
	}

	@Override
	public ChildVaccine findById(int id) {
		return ChildVaccineRep.findById(id).orElse(null);
	}

}
