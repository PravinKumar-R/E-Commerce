package com.ecommerce.base.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.base.bean.user;
import com.ecommerce.base.dto.loginDTO;
import com.ecommerce.base.repository.loginRepository;
import com.ecommerce.base.repository.userRepository;
import com.ecommerce.base.bean.login;

@Service
public class loginService {

	@Autowired
	userRepository userRepo;

	@Autowired
	loginRepository loginRepo;

	public boolean insertLogin(loginDTO login) {

		user user = userRepo.findById(login.getUserId()).get();

		login log = new login();
		log.setLoginUserName(login.getLoginUserName());
		log.setPassword(login.getPassword());
		log.setUserEmailId(login.getUserEmailId());
		log.setUser(user);

		loginRepo.save(log);
		return true;
	}

	public boolean updateLogin(String loginUserName, String password, String UserEmailId, Long loginId) {
        loginRepo.setLoginInfoById(loginUserName, password, UserEmailId, loginId);
		return true;
	}

	public boolean deleteLogin(Long id) {
		loginRepo.deleteById(id);
		return true;
	}

	public List<login> getAllLoginDetails() {
		Iterator<login> it = loginRepo.findAll().iterator();
		ArrayList<login> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<login> getLogin(long loginId) {
		Iterator<login> it = loginRepo.findByLoginId(loginId).iterator();
		ArrayList<login> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<login> getLoginByEmailId(String userEmailId) {
		Iterator<login> it = loginRepo.findByUserEmailId(userEmailId).iterator();
		ArrayList<login> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
}