package com.ecommerce.base.repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.seller;

@Repository
public interface sellerRepository extends JpaRepository<seller, Long> {

	@Query(value="select * from tbl_seller where seller_id=?", nativeQuery = true)
	public List<seller> findBySellerId(long sellerId);

	@Modifying
	@Query("update tbl_seller a set a.sellerName = ?1, a.sellerRate = ?2, a.addedDate = ?3, a.sellerPhoneNumber = ?4 where a.sellerId = ?5")
	public void setSellerById(String sellerName, Float sellerRate, Date addedDate, Long sellerPhoneNumber, Long sellerId);
}