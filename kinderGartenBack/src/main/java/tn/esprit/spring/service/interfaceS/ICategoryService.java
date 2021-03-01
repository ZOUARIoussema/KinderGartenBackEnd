package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Category;

public interface ICategoryService {
	public int addCategory(Category category);
	public void updateCategory(String description,int categoryId);
	public List<Category> getAllcategory();
	public void deleteCategoryById(int categoryId);
	public Category getCategoryById(int categoryId);
}
