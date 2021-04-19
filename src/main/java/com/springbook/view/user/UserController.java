package com.springbook.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userservice;

	@RequestMapping("createUser.do")
	public String userCreate(UserVO vo) {
		userservice.createUser(vo);
		return "index.jsp";
	}
}
