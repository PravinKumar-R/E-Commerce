package com.ecommerce.base.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.address;

@Repository
public interface addressRepository extends JpaRepository<address, Long> {

	@Query(value="select * from tbl_address where address_id=?", nativeQuery = true)
	public List<address> findByAddressId(long addressId);
	
	@Modifying
	@Query("update tbl_user_address a set a.state = ?1, a.city = ?2, a.pincode = ?3, a.address = ?4 where a.addressId = ?5")
	public void setAddressInfoById(String state, String city, Long pincode, String address, Long addressid);
}