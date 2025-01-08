package com.ecommerce.base.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.address;
import com.ecommerce.base.bean.login;

@Repository
public interface loginRepository extends JpaRepository<login, Long>  {

	@Query(value="select * from tbl_login where login_id=?", nativeQuery = true)
	public List<login> findByLoginId(long loginId);
	
	@Modifying
	@Query("update tbl_login a set a.loginUserName = ?1, a.password = ?2, a.userEmailId =?3 where a.loginId = ?4")
	public void setLoginInfoById(String loginUserName, String password, String userEmailId, Long loginId);

	@Query(value="select * from tbl_login where user_email_id=?", nativeQuery = true)
	public List<login> findByUserEmailId(String userEmailId);
	
}
