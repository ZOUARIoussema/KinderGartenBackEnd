package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.IActivityRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IActivityService;

@Service
public class ActivityServiceImpl implements IActivityService {
	@Autowired
	IActivityRepository iActivityRepository;
	@Autowired
	IKinderGartenRepository kinderRepo;
	
	@Override
	public int addActivity(Activity activity) {
		iActivityRepository.save(activity);
		return activity.getId();
	}

	@Override
	public void updateActivity(String description, String photo, int activityId) {
		iActivityRepository.updateActivityJPQL(description, photo, activityId);

		
	}

	@Override
	public List<Activity> getAllactivity() {
		return (List<Activity>) iActivityRepository.findAll();
	}

	@Override
	public void deleteActivityById(int activityId) {
		Activity activity = iActivityRepository.findById(activityId).get();
		iActivityRepository.delete(activity);
		
	}

	@Override
	public Activity getActivityById(int activityaId) {
		return iActivityRepository.findById(activityaId).get();
	}

	@Override
	public void affecterActivityAkinderGarten(int activityId, int kinderId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		Activity activityManagedEntity = iActivityRepository.findById(activityId).get();
		
		activityManagedEntity.setKinderGarten(kinderManagedEntity);
		iActivityRepository.save(activityManagedEntity);
		
	}

}
