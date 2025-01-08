package com.ecommerce.base.dto;
import java.sql.Date;

public class sellerDTO {

    private Long sellerId;

    private String sellerName;

    private Float sellerRate;
    
    private Date addedDate;

    private Long sellerPhoneNumber;

	public sellerDTO() {
		super();
	}

	public sellerDTO(Long sellerId, String sellerName, Float sellerRate, Date addedDate, Long sellerPhoneNumber) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerRate = sellerRate;
		this.addedDate = addedDate;
		this.sellerPhoneNumber = sellerPhoneNumber;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Float getSellerRate() {
		return sellerRate;
	}

	public void setSellerRate(Float sellerRate) {
		this.sellerRate = sellerRate;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Long getSellerPhoneNumber() {
		return sellerPhoneNumber;
	}

	public void setSellerPhoneNumber(Long sellerPhoneNumber) {
		this.sellerPhoneNumber = sellerPhoneNumber;
	}
	
}