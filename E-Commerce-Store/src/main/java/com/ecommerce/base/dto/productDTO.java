package com.ecommerce.base.dto;
import java.sql.Date;

public class productDTO {

    private Long productId;

    private String productName;

    private Date addedDate;

    private Long productAmount;
    
    private Date manufactureDate;
    
    private Long productQuatity;
    
   	private Long categoryId;

   	private Long sellerId;

	public productDTO() {
		super();
	}

	public productDTO(Long productId, String productName, Date addedDate, Long productAmount, Date manufactureDate,
			Long productQuatity, Long categoryId, Long sellerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.addedDate = addedDate;
		this.productAmount = productAmount;
		this.manufactureDate = manufactureDate;
		this.productQuatity = productQuatity;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Long getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Long productAmount) {
		this.productAmount = productAmount;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Long getProductQuatity() {
		return productQuatity;
	}

	public void setProductQuatity(Long productQuatity) {
		this.productQuatity = productQuatity;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
   	
}
