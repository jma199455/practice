package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UsersVO;

@Mapper
public interface UsersMapper {
    
    public UsersVO usersLogin(UsersVO usersVO) throws Exception;
    public UsersVO getUserInfo(UsersVO usersVO) throws Exception;
}
