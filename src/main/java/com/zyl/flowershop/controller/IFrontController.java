package com.zyl.flowershop.controller;

import org.springframework.web.servlet.ModelAndView;

public interface IFrontController {
	public ModelAndView detatils(Integer fid);

	public ModelAndView cart();

	public ModelAndView pay();
	
	public ModelAndView viewDetails();

}
