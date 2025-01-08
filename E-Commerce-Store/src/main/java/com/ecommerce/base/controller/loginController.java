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
import com.ecommerce.base.bean.login;
import com.ecommerce.base.dto.loginDTO;
import com.ecommerce.base.service.loginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class loginController {

	@Autowired
	loginService loginService;
	
	@PostMapping("/login")
	public void performLoginInsert(@RequestBody loginDTO login) {
		loginService.insertLogin(login);
	}

	@PutMapping("/login/{id}")
	public void performLoginUpdate(@PathVariable("id") String loginUserName, String password, String userEmailId, Long loginId) {
		loginService.updateLogin(loginUserName, password, userEmailId, loginId);
	}

	@DeleteMapping("/login/{id}")
	public void performLoginDelete(@PathVariable("id") long id) {
		loginService.deleteLogin(id);
	}

	@GetMapping("/LoginFind")
	public List<login> viewAllLoginDetails() {
		return loginService.getAllLoginDetails();
	}
	
	@GetMapping("/LoginFind/{loginId}")
	public List<login> viewAllLogin(@PathVariable("loginId") long loginId) {
		return loginService.getLogin(loginId);
	}
	
	@GetMapping("/LoginFindId/{userEmailId}")
	public List<login> viewLoginByUserEmailId(@PathVariable("userEmailId") String userEmailId) {
		return loginService.getLoginByEmailId(userEmailId);
	}
	
}
