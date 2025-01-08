package com.ecommerce.base.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.base.bean.category;
import com.ecommerce.base.dto.categoryDTO;
import com.ecommerce.base.repository.categoryRepository;

@Service
public class categoryService {

	@Autowired
    categoryRepository categoryRepo;
	
	public boolean insertCategory(categoryDTO categoryAdd) {

		category category = new category();
		category.setCategoryName(categoryAdd.getCategoryName());
		category.setAddedDate(categoryAdd.getAddedDate());
		
		categoryRepo.save(category);
		return true;
	}

	public boolean updateCategory(String categoryName, Date addedDate, Long categoryId) {
        categoryRepo.setCategoryById(categoryName, addedDate, categoryId);
		return true;
	}
	
	public boolean deleteCategory(Long id) {
		categoryRepo.deleteById(id);
		return true;
	}

	public List<category> getAllCategoryDetails() {
		Iterator<category> it = categoryRepo.findAll().iterator();
		ArrayList<category> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<category> getCategory(long categoryId) {
		Iterator<category> it = categoryRepo.findByCategoryId(categoryId).iterator();
		ArrayList<category> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
