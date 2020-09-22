package com.zyl.flowershop.controller.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyl.flowershop.controller.IFrontController;

@RestController
public class FrontController implements IFrontController {

	@Override
	@RequestMapping("/front/flower/{fid}")
	public ModelAndView detatils(@PathVariable(required = true) Integer fid) {
		return new ModelAndView("/front/details.html");
	}

	@Override
	@RequestMapping("/front/cart")
	public ModelAndView cart() {
		return new ModelAndView("/front/cart.html");
	}

	@Override
	@RequestMapping("/front/orderDetails/{oid}")
	public ModelAndView pay() {
		return new ModelAndView("/front/orderDetails.html");

	}
	
	@Override
	@RequestMapping("/front/viewOrderDetails/{oid}")
	public ModelAndView viewDetails() {
		return new ModelAndView("/front/viewOrderDetails.html");
	}
}
