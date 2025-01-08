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
import com.ecommerce.base.bean.seller;
import com.ecommerce.base.dto.sellerDTO;
import com.ecommerce.base.service.sellerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class sellerController {

	@Autowired
	sellerService sellerService;
	
	@PostMapping("/seller")
	public void performSellerInsert(@RequestBody sellerDTO seller) {
		sellerService.insertSeller(seller);
	}

	@PutMapping("/seller/{id}")
	public void performSellerUpdate(@PathVariable("id") String sellerName, Float sellerRate, Date addedDate, Long sellerPhoneNumber, Long sellerId) {
		sellerService.updateSeller(sellerName, sellerRate, addedDate, sellerPhoneNumber, sellerId);
	}

	@DeleteMapping("/sellerDelete/{id}")
	public void performSellerDelete(@PathVariable("id") long id) {
		sellerService.deleteSeller(id);
	}

	@GetMapping("/SellerFind")
	public List<seller> viewAllSellerDetails() {
		return sellerService.getAllSellerDetails();
	}
	
	@GetMapping("/SellerFind/{sellerId}")
	public List<seller> viewAllSeller(@PathVariable("sellerId") long sellerId) {
		return sellerService.getSeller(sellerId);
	}
}
