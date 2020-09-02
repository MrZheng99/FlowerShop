package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IUserController;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
	@Autowired
	UserService userService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return userService.findAll();
	}

	@Override
	@RequestMapping("/find")
	public ResponseJson find(@RequestBody User user) {
		return userService.find(user);
	}

	@Override
	@PutMapping("/insert")
	public ResponseJson insert(@RequestBody User user) {
		return userService.insert(user);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody User user) {
		return userService.update(user);
	}

	@Override
	@PostMapping("/updatePwd")
	public ResponseJson updatePwd(@RequestParam String opwd, @RequestParam String npwd, @RequestParam Integer id) {
		return userService.updatePwd(id, opwd, npwd);
	}

}
