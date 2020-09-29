package com.zyl.flowershop.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerService;

@RestController
@RequestMapping("/search")
@Scope("singleton")
public class SearchController {
	@Autowired
	IFlowerService flowerService;

	@GetMapping("")
	public ModelAndView jump2Search() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/html/search.html");
		return mav;
	}

	@RequestMapping("/getKeyWord")
	public ResponseJson saveKeyWords(HttpSession session) {
		try {
			String keyWord = (String) session.getAttribute("keyWord");
			if (keyWord != null) {
				return new ResponseJson(200, "获取关键字成功", keyWord, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseJson(false, "获取关键字失败");
	}

	@GetMapping(value = { "/name/{name}", "/name/{name}/{pageNum}" })
	public ResponseJson queryGoodsByName(@PathVariable("name") String name,
			@PathVariable(value = "pageNum", required = false) Integer pageNum) {
		return flowerService.myLucence(name, pageNum);
	}

	@GetMapping(value = { "/number/{name}", "/number/{name}/{pageNum}" })
	public ResponseJson queryGoodsNumber(@PathVariable("name") String name) {
		return flowerService.myLucenceNumber(name);
	}
}
