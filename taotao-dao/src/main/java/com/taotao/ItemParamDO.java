package com.taotao;

import lombok.Data;

@Data
public class ItemParamDAO extends BaseDAO {

    private Long id;

    private Long itemCatId;

    private String paramData;


}
