package com.taotao.serivce;

import com.taotao.po.UserDO;

import java.util.List;

public interface IUserService {

    List<UserDO> selectUser(UserDO condition);

    void update(UserDO data);
}
