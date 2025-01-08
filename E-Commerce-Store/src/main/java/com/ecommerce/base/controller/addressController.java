package com.ecommerce.base.controller;
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

import com.ecommerce.base.bean.address;
import com.ecommerce.base.dto.addressDTO;
import com.ecommerce.base.service.addressService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class addressController {

	@Autowired
	addressService addressService;
	
	@PostMapping("/address")
	public void performAddressInsert(@RequestBody addressDTO address) {
		addressService.insertAddress(address);
	}

	@PutMapping("/address/{id}")
	public void performAddressUpdate(@PathVariable("id") String state, String city, Long pincode, String address, Long addressId) {
		addressService.updateAddress(state, city, pincode, address, addressId);
	}

	@DeleteMapping("/address/{id}")
	public void performAddressDelete(@PathVariable("id") long id) {
		addressService.deleteAddress(id);
	}

	@GetMapping("/AddressFind")
	public List<address> viewAllAddressDetails() {
		return addressService.getAllAddressDetails();
	}
	
	@GetMapping("/AddressFind/{addressId}")
	public List<address> viewAllAddress(@PathVariable("addressId") long addressId) {
		return addressService.getAddress(addressId);
	}
	
}