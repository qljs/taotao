package com.taotao.mapper;

import com.taotao.po.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    List<UserDO> selectUser(UserDO condition);

    int updateUser(UserDO data);

    int insertUser(UserDO data);
}
