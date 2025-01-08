package com.ecommerce.base.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.base.bean.cart;
import com.ecommerce.base.bean.product;
import com.ecommerce.base.bean.user;
import com.ecommerce.base.dto.cartDTO;
import com.ecommerce.base.repository.cartRepository;
import com.ecommerce.base.repository.productRepository;
import com.ecommerce.base.repository.userRepository;

@Service
public class cartService {

	@Autowired
	userRepository userRepo;

	@Autowired
	productRepository productRepo;
	
	@Autowired
    cartRepository cartRepo;
	
	public boolean insertCart(cartDTO cartAdd) {

		user user = userRepo.findById(cartAdd.getUserId()).get();
		
		product product = productRepo.findById(cartAdd.getUserId()).get();

		cart cart = new cart();
		cart.setUser(user);
		cart.setProduct(product);

		cartRepo.save(cart);
		return true;
	}

	public boolean deleteCart(Long id) {
		cartRepo.deleteById(id);
		return true;
	}

	public List<cart> getAllCartDetails() {
		Iterator<cart> it = cartRepo.findAll().iterator();
		ArrayList<cart> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<cart> getCart(long cartId) {
		Iterator<cart> it = cartRepo.findByCartId(cartId).iterator();
		ArrayList<cart> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<cart> getCartByUserId(long userId) {
		Iterator<cart> it = ((List<cart>) cartRepo.getByUserId(userId)).iterator();
		ArrayList<cart> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
