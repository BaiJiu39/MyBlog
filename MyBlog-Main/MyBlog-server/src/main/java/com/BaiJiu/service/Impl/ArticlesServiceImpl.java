package com.BaiJiu.service.Impl;

import com.BaiJiu.POJO.DTO.ArticlePageDTO;
import com.BaiJiu.POJO.Entity.Articles;
import com.BaiJiu.POJO.VO.ArticlesVO;
import com.BaiJiu.mapper.ArticlesMapper;
import com.BaiJiu.result.PageResult;
import com.BaiJiu.service.ArticlesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author miku
 * @description 针对表【articles】的数据库操作Service实现
 * @createDate 2024-03-30 18:32:09
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements ArticlesService {

    @Autowired
    ArticlesMapper articlesMapper;


    //文章首页分页查询
    @Override
    public PageResult getList(ArticlePageDTO articlePageDTO) {
        //查询前十条
        Page<Articles> page = new Page<>(articlePageDTO.getPage(), articlePageDTO.getPageSize());
        QueryWrapper<Articles> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Articles.class, tableFieldInfo -> !tableFieldInfo.getProperty().equals("content"));
        IPage<Articles> articlesPage = articlesMapper.selectPage(page, queryWrapper);

        return new PageResult(articlesPage.getTotal(), articlesPage.getRecords());
    }

    //文章内容请求
    @Override
    public ArticlesVO getContent( int id) {
        Articles articles = articlesMapper.selectContent(id);
        ArticlesVO articlesVO = ArticlesVO.builder()
                .article(articles.getContent())
                .build();
        return articlesVO;
    }


}




