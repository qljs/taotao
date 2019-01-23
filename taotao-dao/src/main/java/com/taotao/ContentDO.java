package com.taotao;

import lombok.Data;

@Data
public class ContentDAO extends BaseDAO {

    private Long id;

    private Long categoryId;

    private String title;

    private String subTitle;

    private String titleDesc;

    private String url;

    private String pic;

    private String pic2;

    private String content;


}
