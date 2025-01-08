package com.ecommerce.base.bean;
import java.sql.Date;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_user")
@Component

public class user {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long userId;

	    @Column(name = "user_first_name")
	    private String userFirstName;

	    @Column(name = "user_last_name")
	    private String userLastName;

	    @Column(name = "user_email_id",unique = true)
	    private String userEmailId;

	    @Column(name = "user-dob")
	    private Date userDob;
	    
	    @Column(name= "user_gender")
	    private String user_Gender;

	    @Column(name = "user_type")
	    private String userType;

	    @Column(name = "user_mobile_number", unique=true , length=10)
	    private Long userMobileNumber;

		public user() {
			super();
		}

		public user(Long userId, String userFirstName, String userLastName, String userEmailId, Date userDob,
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