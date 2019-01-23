package com.taotao;

import lombok.Data;

@Data
public class ItemDescDAO extends BaseDAO{
    
    private Long itemId;
    
    private String itemDesc;

}
