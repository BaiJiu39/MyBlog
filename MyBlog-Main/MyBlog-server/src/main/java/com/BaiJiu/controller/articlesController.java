package com.BaiJiu.controller;

import com.BaiJiu.POJO.DTO.ArticlePageDTO;
import com.BaiJiu.POJO.Entity.Articles;
import com.BaiJiu.POJO.VO.ArticlesVO;
import com.BaiJiu.result.PageResult;
import com.BaiJiu.result.Result;
import com.BaiJiu.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class articlesController {


    @Autowired
    private ArticlesService articlesService;


    /**
     * 查询博客首页文章列表，分页
     *
     * @param
     * @return
     */
    @GetMapping
    public Result<PageResult> articles(ArticlePageDTO articlePageDTO) {
        PageResult Page = articlesService.getList(articlePageDTO);
        return Result.success(Page);
    }

    /**
     * 文章内容查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ArticlesVO> articleContent( @PathVariable int id ) {
        ArticlesVO articlesVO =  articlesService.getContent(id);
        return Result.success(articlesVO);
    }

}
