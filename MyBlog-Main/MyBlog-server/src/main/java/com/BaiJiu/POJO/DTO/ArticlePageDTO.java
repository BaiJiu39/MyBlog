package com.BaiJiu.POJO.DTO;

import lombok.Data;

@Data
public class ArticlePageDTO {
    /**
     * 当前页数
     */
    private int page;
    /**
     * 每页显示数量
     */
    private int pageSize;
}
