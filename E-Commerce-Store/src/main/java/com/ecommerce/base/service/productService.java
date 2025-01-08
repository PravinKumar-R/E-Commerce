package com.ecommerce.base.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.base.bean.category;
import com.ecommerce.base.bean.product;
import com.ecommerce.base.bean.seller;
import com.ecommerce.base.dto.productDTO;
import com.ecommerce.base.repository.categoryRepository;
import com.ecommerce.base.repository.productRepository;
import com.ecommerce.base.repository.sellerRepository;

@Service
public class productService {

	@Autowired
    productRepository productRepo;
	
	@Autowired
	categoryRepository categoryRepo;
	
	@Autowired
	sellerRepository sellerRepo;
	
	public boolean insertProduct(productDTO productAdd) {

		category category = categoryRepo.findById(productAdd.getCategoryId()).get();
		
		seller seller = sellerRepo.findById(productAdd.getSellerId()).get();
		
		product product = new product();
		product.setAddedDate(productAdd.getAddedDate());
		product.setManufactureDate(productAdd.getManufactureDate());
		product.setProductAmount(productAdd.getProductAmount());
		product.setProductName(productAdd.getProductName());
		product.setProductQuatity(productAdd.getProductQuatity());
		product.setCategory(category);
		product.setSeller(seller);
		
		productRepo.save(product);
		return true;
	}

	public boolean updateProduct(String productName, Date addedDate, Long productAmount, Date manufactureDate, Long productQuatity, Long categoryId, Long sellerId, Long productId) {
        productRepo.setProductById(productName, addedDate, productAmount, manufactureDate, productQuatity, categoryId, sellerId, productId);
		return true;
	}
	
	public boolean deleteProduct(Long id) {
		productRepo.deleteById(id);
		return true;
	}

	public List<product> getAllProductDetails() {
		Iterator<product> it = productRepo.findAll().iterator();
		ArrayList<product> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<product> getProduct(long productId) {
		Iterator<product> it = productRepo.findByProductId(productId).iterator();
		ArrayList<product> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
