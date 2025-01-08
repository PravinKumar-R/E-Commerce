package com.ecommerce.base.dto;

public class loginDTO {

    private Long loginId;

    private String loginUserName;

    private String password;
    
   	private Long userId;

    private String userEmailId;
    
	public loginDTO() {
		super();
	}

	public loginDTO(Long loginId, String loginUserName, String password, Long userId, String userEmailId) {
		super();
		this.loginId = loginId;
		this.loginUserName = loginUserName;
		this.password = password;
		this.userId = userId;
		this.userEmailId = userEmailId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

}
