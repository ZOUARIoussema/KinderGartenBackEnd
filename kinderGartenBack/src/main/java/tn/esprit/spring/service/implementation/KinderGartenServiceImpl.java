package tn.esprit.spring.service.implementation;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;

import tn.esprit.spring.service.interfaceS.IKinderGartenService;


@Service
public class KinderGartenServiceImpl implements IKinderGartenService {
	
	@Autowired
	IKinderGartenRepository kinderRepo;
	
	

	@Autowired
	IKinderGartenRepository iKinderGartenRepository;
	@Autowired
	IUserRepository iUserRepository;
	
	@Override
	public int addKindergarten(KinderGarten kendergarten) {
		iKinderGartenRepository.save(kendergarten);
		return kendergarten.getId();
	}
	 
	@Override
	public void updateKindergarten(String name,String adress,String email,int tel,String logo,int kinderId) {
		iKinderGartenRepository.updateKindergartenJPQL(name, adress, email, tel, logo, kinderId);
	}



	@Override
	public void deleteKindergartenById(int kenderId) {
		KinderGarten kinderGarten = iKinderGartenRepository.findById(kenderId).get();
		iKinderGartenRepository.delete(kinderGarten);
		
	}

	@Override
	public KinderGarten getKindergartenById(int kinderId) {
			return iKinderGartenRepository.findById(kinderId).get();
	}

	@Override
	public void affecterKinderAResponsible(int kinderId, int ReponsibleId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		User userManagedEntity = iUserRepository.findById(ReponsibleId).get();
		
		kinderManagedEntity.setResponsible(userManagedEntity);
		kinderRepo.save(kinderManagedEntity);
	}

	@Override
	public List<KinderGarten> getAllkinder() {
		return (List<KinderGarten>) iKinderGartenRepository.findAll();

	}

	

}
