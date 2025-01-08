package com.ecommerce.base.bean;
import java.sql.Date;
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

@Entity(name = "tbl_product")
@Table(name = "tbl_product")
@Component
public class product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "product_amount")
    private Long productAmount;
    
    @Column(name = "manufacture_date")
    private Date manufactureDate;
    
    @Column(name = "product_quatity")
    private Long productQuatity;
    
    @ManyToOne(cascade = CascadeType.MERGE)
   	@JoinColumn(name = "categoy_id")
   	private category category;

    @ManyToOne(cascade = CascadeType.MERGE)
   	@JoinColumn(name = "seller_id")
   	private seller seller;

	public product() {
		super();
	}

	public product(Long productId, String productName, Date addedDate, Long productAmount, Date manufactureDate,
			Long productQuatity, com.ecommerce.base.bean.category category, com.ecommerce.base.bean.seller seller) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.addedDate = addedDate;
		this.productAmount = productAmount;
		this.manufactureDate = manufactureDate;
		this.productQuatity = productQuatity;
		this.category = category;
		this.seller = seller;
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

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public seller getSeller() {
		return seller;
	}

	public void setSeller(seller seller) {
		this.seller = seller;
	}

}
