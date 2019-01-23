package com.taotao;

import lombok.Data;

@Data
public class ItemDAO extends BaseDAO {


    private Long id;

    private String title;

    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Integer status;

}
