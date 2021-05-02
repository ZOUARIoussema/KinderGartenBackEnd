package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.CategorySubscription;



public interface ICategorySubscriptionService {
	public int addCategorySubscription(CategorySubscription categorySubscription,int idk);
	public void updateCategorySubscription(String description,double price,int categorySubscriptionId);
	public List<CategorySubscription> getAllCategorySubscription();
	public void deleteCategorySubscriptionById(int categorySubscriptionId);
	public CategorySubscription getCategorySubscriptionById(int categorySubscriptionId);
	public void affecterCategorySubscriptionAkinderGarten(int categorySubscriptionId, int kinderId);
	public List<CategorySubscription> findAllCategorySubscriptionByKinderGarten(int kinderId) ;
}
