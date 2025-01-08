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
import com.ecommerce.base.dto.userDTO;
import com.ecommerce.base.service.userService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {

	@Autowired
	userService userService;
	
	@PostMapping("/insertUsers")
	public void performInsert(@RequestBody userDTO user) {
		userService.saveOrUpdateUser(user);
	}

	@PutMapping("/updateUsers")
	public void performUpdate(@RequestBody userDTO user) {
		userService.saveOrUpdateUser(user);
	}

	@DeleteMapping("/deleteUsers/{userId}")
	public void performDelete(@PathVariable Long userId) {
		userService.deleteUserById(userId);
	}

	@GetMapping("/findAllCustomers")
	public List<userDTO> viewAllCustomers() {
		return userService.getAllCustomers();
	}

	@GetMapping("/findAllCustomersToView")
	public List<userDTO> viewAllCustomersToView() {
		return userService.getAllCustomersToView();
	}

	}