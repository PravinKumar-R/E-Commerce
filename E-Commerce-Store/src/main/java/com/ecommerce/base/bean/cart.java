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

@Entity(name = "tbl_cart")
@Table(name = "tbl_cart")
@Component
public class cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private user user;
    
    @ManyToOne(cascade = CascadeType.MERGE)
   	@JoinColumn(name = "product_id")
   	private product product;
    
	public cart() {
		super();
	}

	public cart(Long cartId, com.ecommerce.base.bean.user user, com.ecommerce.base.bean.product product) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.product = product;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}
    
}
