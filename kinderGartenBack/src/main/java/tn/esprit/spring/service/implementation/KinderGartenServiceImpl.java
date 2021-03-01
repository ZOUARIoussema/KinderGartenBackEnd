package tn.esprit.spring.service.implementation;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Extra;
>>>>>>> 2dae691cbac7ddc556778d8bc9574087c6d6ed3b
import tn.esprit.spring.entity.KinderGarten;

import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;

import tn.esprit.spring.service.interfaceS.IKinderGartenService;


@Service
public  class KinderGartenServiceImpl implements IKinderGartenService {
	
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
		
<<<<<<< HEAD
	}

	
=======
		kinderManagedEntity.setResponsible(userManagedEntity);
		kinderRepo.save(kinderManagedEntity);
	}
>>>>>>> 2dae691cbac7ddc556778d8bc9574087c6d6ed3b

	@Override
	public List<KinderGarten> getAllkinder() {
		return (List<KinderGarten>) iKinderGartenRepository.findAll();

<<<<<<< HEAD
	

	/*@Transactional	
	public void affecterKinderAResponsible(int kinderId, int ReponsibleId) {
		KinderGarten kinderGarten = iKinderGartenRepository.findById(kinderId).get();
		int id = iUserRepository.findUserByRole();
			
		User user = iUserRepository.findById(id).get();
		if(kinderGarten.getResponsible() == null){

			kinderGarten.setResponsible(user);
		}
=======
	}
>>>>>>> 2dae691cbac7ddc556778d8bc9574087c6d6ed3b

	

}
