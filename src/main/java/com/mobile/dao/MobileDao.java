package com.mobile.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.entity.Mobile;
import com.mobile.repository.MobileRepository;

@Repository
public class MobileDao {
	
	@Autowired
	MobileRepository mobRepo;
	
	public String post(List<Mobile> m) {
		mobRepo.saveAll(m);
		return "Sucessfully posted";
	}
	public List<Mobile> get(){
		return mobRepo.findAll();
		
	}
	public String post(Mobile m) {
		mobRepo.save(m);
		return "PostedOne";
	}

}
