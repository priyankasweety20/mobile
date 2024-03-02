package com.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.dao.MobileDao;
import com.mobile.entity.Mobile;

@Service
public class MobileService {
	@Autowired
	MobileDao mobDao;
	
	public String post(List<Mobile> m) {
		return mobDao.post(m);
	}
	public List<Mobile> get() {
		return mobDao.get();
	}
	public String post(Mobile m) {
		return mobDao.post(m);
	}

}
