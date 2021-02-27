package tn.esprit.spring.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IKinderGartenService;
@Service
public class KinderGartenServiceImpl implements IKinderGartenService {
	
	@Autowired
	IKinderGartenRepository kinderRepo;
	
	@Override
	public List<KinderGarten> getAllKinderGartens() {
		
		List<KinderGarten> listekindergartens =  (List<KinderGarten>) kinderRepo.findAll();
		return listekindergartens;
	}

}
