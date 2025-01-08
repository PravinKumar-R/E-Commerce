package com.ecommerce.base.dto;

public class addressDTO {

    private Long addressId;
 
    private String state;

    private String city;

    private String address;

    private Long pincode;

	private Long userId;

	private Long sellerId;
	
	public addressDTO() {
		super();
	}

	public addressDTO(Long addressId, String state, String city, String address, Long pincode, Long userId,
			Long sellerId) {
		super();
		this.addressId = addressId;
		this.state = state;
		this.city = city;
		this.address = address;
		this.pincode = pincode;
		this.userId = userId;
		this.sellerId = sellerId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

}