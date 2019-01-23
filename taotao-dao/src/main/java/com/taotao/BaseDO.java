package com.taotao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
public class BaseDAO implements Serializable {

    private Date created;
    private Date updated;

}
