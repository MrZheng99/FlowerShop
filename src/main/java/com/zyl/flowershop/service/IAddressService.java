package com.zyl.flowershop.service;

import com.zyl.flowershop.entity.Address;
import com.zyl.flowershop.entity.ResponseJson;

public interface IAddressService {
	public ResponseJson findCurrent(Integer uid);
	
	public ResponseJson insert(Address address);
	
	public ResponseJson update(Address address);

	public ResponseJson updateFlag(Address address);
}
