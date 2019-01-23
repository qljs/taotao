package com.taotao;

import lombok.Data;

@Data
public class ContentCategoryDAO extends BaseDAO {

    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        this.isParent = parent;
    }
}
