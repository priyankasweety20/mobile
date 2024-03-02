package com.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.entity.Mobile;
import com.mobile.service.MobileService;


@RestController
@RequestMapping(value="/mobile")
@CrossOrigin("http://localhost:4200")
public class MobileController {
	
	@Autowired
	MobileService mobSer;
	 
  @PostMapping(value="/post")
  public String post(@RequestBody List<Mobile> m) {
	  return mobSer.post(m);
  }
  
  @GetMapping(value="/getAll")
  public List<Mobile> get(){
	  return mobSer.get();
  }
 @PostMapping(value="/postone")
 public String post(@RequestBody Mobile m) {
	 return mobSer.post(m);
 }
}
