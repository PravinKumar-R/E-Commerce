package com.ecommerce.base.repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.product;

@Repository
public interface productRepository extends JpaRepository<product, Long>{

	@Query(value="select * from tbl_product where product_id=?", nativeQuery = true)
	public List<product> findByProductId(long productId);
	
	@Modifying
	@Query("update tbl_product a set a.productName = ?1, a.addedDate = ?2, a.productAmount = ?3, a.manufactureDate = ?4 , a.productQuatity = ?5, a.category = ?6, a.seller = ?7 where a.productId = ?8")
	public void setProductById(String productName, Date addedDate, Long productAmount, Date manufactureDate, Long productQuality, Long category, Long seller, Long productId);
}
