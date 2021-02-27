package tn.esprit.spring.service.implementation;


<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 99bf506d3e5cf36fdfc6f122a87288ec94174114
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.KinderGarten;
<<<<<<< HEAD
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;
=======
import tn.esprit.spring.repository.IKinderGartenRepository;
>>>>>>> 99bf506d3e5cf36fdfc6f122a87288ec94174114
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
	public List<KinderGarten> getAllkinder() {
		return (List<KinderGarten>) iKinderGartenRepository.findAll();
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
		// TODO Auto-generated method stub
		
	}

	/*@Transactional	
	public void affecterKinderAResponsible(int kinderId, int ReponsibleId) {
		KinderGarten kinderGarten = iKinderGartenRepository.findById(kinderId).get();
		int id = iUserRepository.findUserByRole();
			
		User user = iUserRepository.findById(id).get();
		if(kinderGarten.getResponsible() == null){

			kinderGarten.setResponsible(user);
		}

	}*/

}
