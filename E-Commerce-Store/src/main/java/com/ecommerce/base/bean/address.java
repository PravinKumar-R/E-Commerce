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

@Entity(name = "tbl_user_address")
@Table(name = "tbl_user_address")
@Component
public class address {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode", length= 6)
    private Long pincode;

    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private user user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seller_id")
    private seller seller;
    
	public address() {
		super();
	}

	public address(Long addressId, String state, String city, String address, Long pincode,
			com.ecommerce.base.bean.user user, com.ecommerce.base.bean.seller seller) {
		super();
		this.addressId = addressId;
		this.state = state;
		this.city = city;
		this.address = address;
		this.pincode = pincode;
		this.user = user;
		this.seller = seller;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public seller getSeller() {
		return seller;
	}

	public void setSeller(seller seller) {
		this.seller = seller;
	}

}
