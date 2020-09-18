package com.zyl.flowershop.controller;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Address;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IAddressController {
	public ResponseJson findCurrent(User user);

	public ResponseJson update(Address address, HttpSession session);

	public ResponseJson insert(Address address, HttpSession session);

	public ResponseJson updateFlag(Address address, HttpSession session);

	public ResponseJson deleteByAid(Address address);

}
