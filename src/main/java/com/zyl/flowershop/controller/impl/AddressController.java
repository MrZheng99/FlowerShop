package com.zyl.flowershop.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IAddressController;
import com.zyl.flowershop.entity.Address;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.IAddressService;
import com.zyl.flowershop.util.SessionKey;

@RestController
@RequestMapping("address")
public class AddressController implements IAddressController{
	@Autowired
	IAddressService addressService;
	
	@Override
	@RequestMapping("/findCurrent")
	public ResponseJson findCurrent(HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User)obj;
		return addressService.findCurrent(user.getUid());
	}
	
	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestBody Address address,HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User)obj;
		address.setUid(user.getUid());
		return addressService.insert(address);
	}
	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Address address,HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User)obj;
		address.setUid(user.getUid());
		return addressService.update(address);
	}
	
	@Override
	@PostMapping("/updateFlag")
	public ResponseJson updateFlag(@RequestBody Address address,HttpSession session) {
		Object obj = session.getAttribute(SessionKey.CURRENT_USER);
		User user = (User)obj;
		address.setUid(user.getUid());
		return addressService.updateFlag(address);
	}
}
