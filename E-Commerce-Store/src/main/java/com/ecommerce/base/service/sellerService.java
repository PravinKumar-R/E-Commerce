package com.ecommerce.base.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.base.bean.address;
import com.ecommerce.base.bean.seller;
import com.ecommerce.base.dto.sellerDTO;
import com.ecommerce.base.repository.addressRepository;
import com.ecommerce.base.repository.sellerRepository;

@Service
public class sellerService {

	@Autowired
	sellerRepository sellerRepo;
	
	public boolean insertSeller(sellerDTO sellerAdd) {
		
		seller seller = new seller();
		seller.setAddedDate(sellerAdd.getAddedDate());
		seller.setSellerName(sellerAdd.getSellerName());
		seller.setSellerPhoneNumber(sellerAdd.getSellerPhoneNumber());
		seller.setSellerRate(sellerAdd.getSellerRate());
		
		sellerRepo.save(seller);
		return true;
	}

	public boolean updateSeller(String sellerName, Float sellerRate, Date addedDate, Long sellerPhoneNumber, Long sellerId) {
        sellerRepo.setSellerById(sellerName, sellerRate, addedDate, sellerPhoneNumber, sellerId);
		return true;
	}
	
	public boolean deleteSeller(Long id) {
		sellerRepo.deleteById(id);
		return true;
	}

	public List<seller> getAllSellerDetails() {
		Iterator<seller> it = sellerRepo.findAll().iterator();
		ArrayList<seller> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<seller> getSeller(long sellerId) {
		Iterator<seller> it = sellerRepo.findBySellerId(sellerId).iterator();
		ArrayList<seller> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
