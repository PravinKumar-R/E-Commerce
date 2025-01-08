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

@Entity(name = "tbl_seller")
@Table(name = "tbl_seller")
@Component
public class seller {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "seller_rate")
    private Float sellerRate;
    
    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "seller_phone_number", length=10)
    private Long sellerPhoneNumber;

	public seller() {
		super();
	}

	public seller(Long sellerId, String sellerName, Float sellerRate, Date addedDate, Long sellerPhoneNumber) {
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
