package com.taotao.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 4211517433038705767L;

    private Integer id;

    private String userName;

    private Integer age;
}
