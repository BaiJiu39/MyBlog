package com.BaiJiu.service;

import com.BaiJiu.POJO.DTO.ArticlePageDTO;
import com.BaiJiu.POJO.Entity.Articles;
import com.BaiJiu.POJO.VO.ArticlesVO;
import com.BaiJiu.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author miku
* @description 针对表【articles】的数据库操作Service
* @createDate 2024-03-30 18:32:09
*/
@Service
public interface ArticlesService extends IService<Articles> {

    PageResult getList(ArticlePageDTO articlePageDTO);

    ArticlesVO getContent(int id);
}
