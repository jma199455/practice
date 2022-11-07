package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersVO;
import com.example.demo.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService{
    

    @Autowired
	UsersMapper usersMapper;

	@Override
	public UsersVO getUser(UsersVO usersVO) throws Exception {
		return usersMapper.usersLogin(usersVO);
	}

	@Override
	public UsersVO getUserInfo(UsersVO UsersVO) throws Exception {
		return usersMapper.getUserInfo(UsersVO);
	}

	

}
