package com.ecommerce.base.dto;

public class cartDTO {
	
    private Long cartId;

	private Long userId;
    
   	private Long productId;

	public cartDTO() {
		super();
	}

	public cartDTO(Long cartId, Long userId, Long productId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
   	
}
