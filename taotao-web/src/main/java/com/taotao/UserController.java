package com.taotao;

import com.alibaba.fastjson.JSONObject;
import com.taotao.domain.Result;
import com.taotao.po.UserDO;
import com.taotao.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @Transactional(isolation = Isolation.DEFAULT)
    public String test() {
        List<UserDO> userDOS =  this.getUser();
        this.updateUser();
        return JSONObject.toJSONString(userDOS);
    }


    @Transactional(isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.NESTED)
    public  List<UserDO>  getUser(){
        return userService.selectUser(null);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.NESTED)
    public void updateUser(){
        UserDO data = new UserDO();
        data.setId(1);
        data.setAge(10);
        userService.update(data);
    }
}
