package com.taotao.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 7217615638729119277L;

    private Integer id;

    private String username;
}
