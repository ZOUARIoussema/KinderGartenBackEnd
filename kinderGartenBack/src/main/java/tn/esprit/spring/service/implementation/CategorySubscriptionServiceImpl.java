package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.ICategorySubscriptionRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.ICategorySubscriptionService;
@Service
public class CategorySubscriptionServiceImpl implements ICategorySubscriptionService {

	@Autowired
	IKinderGartenRepository kinderRepo;
	@Autowired
	ICategorySubscriptionRepository iCategorySubscriptionRepository;
	
	
	@Override
	public int addCategorySubscription(CategorySubscription categorySubscription) {
		iCategorySubscriptionRepository.save(categorySubscription);
		return categorySubscription.getId();
	}

	@Override
	public void updateCategorySubscription(String description, double price, int categorySubscriptionId) {
		iCategorySubscriptionRepository.updateupdateCategorySubscriptionJPQL(description, price, categorySubscriptionId);
		
	}

	@Override
	public List<CategorySubscription> getAllCategorySubscription() {
		return (List<CategorySubscription>) iCategorySubscriptionRepository.findAll();
	}

	@Override
	public void deleteCategorySubscriptionById(int categorySubscriptionId) {
		CategorySubscription categorySubscription = iCategorySubscriptionRepository.findById(categorySubscriptionId).get();
		iCategorySubscriptionRepository.delete(categorySubscription);
		
	}

	@Override
	public CategorySubscription getCategorySubscriptionById(int categorySubscriptionId) {
		return iCategorySubscriptionRepository.findById(categorySubscriptionId).get();
	}

	@Override
	public void affecterCategorySubscriptionAkinderGarten(int categorySubscriptionId, int kinderId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		CategorySubscription categorySubscriptionManagedEntity = iCategorySubscriptionRepository.findById(categorySubscriptionId).get();
		
		categorySubscriptionManagedEntity.setKinderGarten(kinderManagedEntity);
		iCategorySubscriptionRepository.save(categorySubscriptionManagedEntity);

		
	}

}
