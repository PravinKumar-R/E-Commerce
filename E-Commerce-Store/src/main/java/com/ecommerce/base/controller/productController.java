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
import com.ecommerce.base.bean.product;
import com.ecommerce.base.dto.productDTO;
import com.ecommerce.base.service.productService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class productController {

	@Autowired
	productService productService;
	
	@PostMapping("/product")
	public void performProductInsert(@RequestBody productDTO product) {
		productService.insertProduct(product);
	}

	@PutMapping("/product/{id}")
	public void performProductUpdate(@PathVariable("id") String productName, Date addedDate, Long productAmount, Date manufactureDate, Long productQuatity, Long categoryId, Long sellerId, Long productId) {
		productService.updateProduct(productName, addedDate, productAmount, manufactureDate, productQuatity, categoryId, sellerId, productId);
	}

	@DeleteMapping("/productDelete/{id}")
	public void performProductDelete(@PathVariable("id") long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/ProductFind")
	public List<product> viewAllProductDetails() {
		return productService.getAllProductDetails();
	}
	
	@GetMapping("/ProductFind/{productId}")
	public List<product> viewAllProduct(@PathVariable("productId") long productId) {
		return productService.getProduct(productId);
	}
}
