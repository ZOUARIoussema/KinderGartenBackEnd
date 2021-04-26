package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.IExtraRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.INotification;
import tn.esprit.spring.service.interfaceS.IExtraService;
@Service
public class ExtraServiceImpl implements IExtraService {

	@Autowired
	IKinderGartenRepository kinderRepo;
	@Autowired
	IExtraRepository iExtraRepository;
	@Autowired
	INotification inotification;
	
	@Override
	public int addExtra(Extra extra) {
	
		iExtraRepository.save(extra);
		
		return extra.getId();
	}

	@Override
	public void updateExtra(String description, double price,int ExtraId) {
		iExtraRepository.updateExtraJPQL(description, price, ExtraId);
		
	}

	@Override
	public List<Extra> getAllextra() {
		return (List<Extra>) iExtraRepository.findAll();
	}

	@Override
	public void deleteExtraById(int extraId) {
		Extra extra = iExtraRepository.findById(extraId).get();
		iExtraRepository.delete(extra);
		
	}

	@Override
	public Extra getExtraById(int extraId) {
		return iExtraRepository.findById(extraId).get();
	}
	
	@Override
	public void affecterExtraAkinderGarten(int extraId, int kinderId) {
				KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
				Extra extraManagedEntity = iExtraRepository.findById(extraId).get();
				
				extraManagedEntity.setKinderGarten(kinderManagedEntity);
				iExtraRepository.save(extraManagedEntity);
		
	}
  
}
