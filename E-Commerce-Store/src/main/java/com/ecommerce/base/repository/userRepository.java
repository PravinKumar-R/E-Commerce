package com.ecommerce.base.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.user;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

	@Query(value="select * from tbl_user where user_type='customer'",nativeQuery=true)
	List<user> viewAllCustomers();

	user findByUserEmailId(String userEmailId);

	user findByUserId(Long userId);
	
	@Query(value = "select * FROM tbl_user where user_id=?", nativeQuery = true)
	public user getByUserId(long userId);
	
}