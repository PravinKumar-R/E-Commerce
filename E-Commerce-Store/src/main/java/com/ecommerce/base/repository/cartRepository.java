package com.ecommerce.base.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.cart;
import com.ecommerce.base.bean.user;

@Repository
public interface cartRepository extends JpaRepository<cart, Long>{

	@Query(value="select * from tbl_cart where cart_id=?", nativeQuery = true)
	public List<cart> findByCartId(long cartId);
	
	@Query(value = "select * FROM tbl_cart where user_id=?", nativeQuery = true)
	public user getByUserId(long userId);
}