package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Category;

public interface ICategoryService {
	public int addCategory(Category category,int idk);
	public void updateCategory(String description,int categoryId);
	public List<Category> getAllcategory();
	public void deleteCategoryById(int categoryId);
	public Category getCategoryById(int categoryId);
	public void affecterCategoryAkinderGarten(int categoryId, int kinderId);
	public List<Category> findAllCategoryByKinderGarten(int kinderId) ;
}
