package com.ecommerce.base.dto;
import java.sql.Date;

public class categoryDTO {

    private Long categoryId;

    private String categoryName;

    private Date addedDate;

	public categoryDTO() {
		super();
	}

	public categoryDTO(Long categoryId, String categoryName, Date addedDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.addedDate = addedDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
       
}
