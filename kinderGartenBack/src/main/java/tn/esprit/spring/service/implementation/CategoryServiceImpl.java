package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.ICategoryRepository;
import tn.esprit.spring.service.interfaceS.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryRepository iCategoryRepository;
	
	
	@Override
	public int addCategory(Category category) {
		iCategoryRepository.save(category);
		return category.getId();
	}

	@Override
	public void updateCategory(String description, int categoryId) {
		iCategoryRepository.updateCategoryJPQL(description, categoryId);
		
	}

	@Override
	public List<Category> getAllcategory() {
		return (List<Category>) iCategoryRepository.findAll();

	}

	@Override
	public void deleteCategoryById(int categoryId) {
		Category category = iCategoryRepository.findById(categoryId).get();
		iCategoryRepository.delete(category);
		
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return iCategoryRepository.findById(categoryId).get();
	}

}
