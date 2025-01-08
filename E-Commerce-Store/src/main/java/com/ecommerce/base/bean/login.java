package com.ecommerce.base.bean;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="tbl_login")
@Table(name = "tbl_login")
@Component
public class login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "login_user_name")
    private String loginUserName;

    @Column(name = "user_email_id",unique = true)
    private String userEmailId;
    
    @Column(name = "password")
    private String password;
    
    @ManyToOne(cascade = CascadeType.MERGE)
   	@JoinColumn(name = "user_id")
   	private user user;

	public login() {
		super();
	}

	public login(Long loginId, String loginUserName, String userEmailId, String password,
			com.ecommerce.base.bean.user user) {
		super();
		this.loginId = loginId;
		this.loginUserName = loginUserName;
		this.userEmailId = userEmailId;
		this.password = password;
		this.user = user;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
}
