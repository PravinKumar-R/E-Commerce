package com.ecommerce.base.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.base.bean.user;
import com.ecommerce.base.dto.userDTO;
import com.ecommerce.base.repository.userRepository;

@Service
public class userService {

	@Autowired
	userRepository userRepo;
	
	public boolean saveOrUpdateUser(userDTO userdto) {
		 
		user user = new user();
 
		user.setUserId(userdto.getUserId());
 
		user.setUserFirstName(userdto.getUserFirstName());
 
		user.setUserLastName(userdto.getUserLastName());
 
		user.setUserEmailId(userdto.getUserEmailId());
 
		user.setUserType(userdto.getUserType());
 
		user.setUser_Gender(userdto.getUser_Gender());
		
		user.setUserDob(userdto.getUserDob());
	
		user.setUserMobileNumber(userdto.getUserMobileNumber());
	
		userRepo.save(user);
 
		return true;
 
	}
 
	public boolean deleteUserById(Long userId) {
 
		userRepo.deleteById(userId);
 
		return true;
 
	}
 
	public List<user> getAllUsers() {
 
		return userRepo.findAll();
 
	}
 
	public List<userDTO> getAllCustomers() {
		Iterator<user> iterator = userRepo.viewAllCustomers().iterator();
		List<userDTO> userList = new ArrayList<>();
 
		while (iterator.hasNext()) {
 
			user user = iterator.next();
 
			userDTO userdto = new userDTO();
 
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());
				userdto.setUserLastName(user.getUserLastName());
				userdto.setUserEmailId(user.getUserEmailId());
				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
                userdto.setUser_Gender(user.getUser_Gender());
                userdto.setUserDob(user.getUserDob());
				userList.add(userdto);
		}
		return userList;
 
	}
	
	
	public List<userDTO> getAllCustomersToView() {
		Iterator<user> iterator = userRepo.viewAllCustomers().iterator();
		List<userDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {
			user user = iterator.next();
			userDTO userdto = new userDTO();
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());
				userdto.setUserLastName(user.getUserLastName());
				userdto.setUserEmailId(user.getUserEmailId());
                userdto.setUser_Gender(user.getUser_Gender());
                userdto.setUserDob(user.getUserDob());
				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
				
				userList.add(userdto);
		
		}
		return userList;
 
	}
}