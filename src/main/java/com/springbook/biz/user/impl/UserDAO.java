package com.springbook.biz.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;



@Repository
public class UserDAO {
	//JDBC ����
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL
	private final String USER_CREATE = "INSERT INTO USERS VALUES(?,?,?,?)";
	
	
	//���
	public void createUser(UserVO vo) {
		jdbcTemplate.update(USER_CREATE, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
}