package com.ecommerce.base.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.base.bean.address;
import com.ecommerce.base.bean.seller;
import com.ecommerce.base.bean.user;
import com.ecommerce.base.dto.addressDTO;
import com.ecommerce.base.repository.addressRepository;
import com.ecommerce.base.repository.sellerRepository;
import com.ecommerce.base.repository.userRepository;

@Service
public class addressService {

	@Autowired
	userRepository userRepo;

	@Autowired
	addressRepository addressRepo;

	@Autowired
	sellerRepository sellerRepo;
	
	public boolean insertAddress(addressDTO address) {

		user user = userRepo.findById(address.getUserId()).get();

		seller seller = sellerRepo.findById(address.getSellerId()).get();
		
		address addr = new address();
		addr.setAddress(address.getAddress());
		addr.setCity(address.getCity());
		addr.setPincode(address.getPincode());
		addr.setState(address.getState());
		addr.setUser(user);
        addr.setSeller(seller);
		
		addressRepo.save(addr);
		return true;
	}

	public boolean updateAddress(String state, String city, Long pincode, String address, Long addressId) {
        addressRepo.setAddressInfoById(state, city, pincode, address, addressId);
		return true;
	}

	public boolean deleteAddress(Long id) {
		addressRepo.deleteById(id);
		return true;
	}

	public List<address> getAllAddressDetails() {
		Iterator<address> it = addressRepo.findAll().iterator();
		ArrayList<address> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<address> getAddress(long addressId) {
		Iterator<address> it = addressRepo.findByAddressId(addressId).iterator();
		ArrayList<address> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
