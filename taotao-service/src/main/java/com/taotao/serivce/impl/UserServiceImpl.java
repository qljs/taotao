package com.taotao.serivce.impl;

import com.taotao.mapper.UserMapper;
import com.taotao.po.UserDO;
import com.taotao.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDO> selectUser(UserDO condition) {
        return userMapper.selectUser(condition);
    }

    @Override
    public void update(UserDO data) {
        userMapper.updateUser(data);
    }
}
