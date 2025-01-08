package com.ecommerce.base.controller;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.base.service.categoryService;
import com.ecommerce.base.bean.category;
import com.ecommerce.base.dto.categoryDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class categoryController {

	@Autowired
	categoryService categoryService;
	
	@PostMapping("/category")
	public void performCategoryInsert(@RequestBody categoryDTO category) {
		categoryService.insertCategory(category);
	}

	@PutMapping("/category/{id}")
	public void performCategoryUpdate(@PathVariable("id") String categoryName, Date addedDate, Long categoryId) {
		categoryService.updateCategory(categoryName, addedDate, categoryId);
	}

	@DeleteMapping("/categoryDelete/{id}")
	public void performCategoryDelete(@PathVariable("id") long id) {
		categoryService.deleteCategory(id);
	}

	@GetMapping("/CategoryFind")
	public List<category> viewAllCategoryDetails() {
		return categoryService.getAllCategoryDetails();
	}
	
	@GetMapping("/CategoryFind/{categoryId}")
	public List<category> viewAllCategory(@PathVariable("categoryId") long categoryId) {
		return categoryService.getCategory(categoryId);
	}
}
