package com.ecommerce.base.dto;
import java.sql.Date;

public class userDTO {

    private Long userId;

    private String userFirstName;

    private String userLastName;

    private String userEmailId;

    private Date userDob;
    
    private String user_Gender;
    
    private String userType;

    private Long userMobileNumber;

	public userDTO() {
		super();
	}

	public userDTO(Long userId, String userFirstName, String userLastName, String userEmailId, Date userDob,
			String user_Gender, String userType, Long userMobileNumber) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailId = userEmailId;
		this.userDob = userDob;
		this.user_Gender = user_Gender;
		this.userType = userType;
		this.userMobileNumber = userMobileNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public String getUser_Gender() {
		return user_Gender;
	}

	public void setUser_Gender(String user_Gender) {
		this.user_Gender = user_Gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
       
}