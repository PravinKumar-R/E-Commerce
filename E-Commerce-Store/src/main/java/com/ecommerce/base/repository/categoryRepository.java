package com.ecommerce.base.repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.base.bean.category;

@Repository
public interface categoryRepository extends JpaRepository<category, Long>{
	
	@Query(value="select * from tbl_category where category_id=?", nativeQuery = true)
	public List<category> findByCategoryId(long categoryId);
	
	@Modifying
	@Query("update tbl_category a set a.categoryName = ?1, a.addedDate = ?2where a.categoryId = ?3")
	public void setCategoryById(String categoryName, Date addedDate, Long categoryId);
}
