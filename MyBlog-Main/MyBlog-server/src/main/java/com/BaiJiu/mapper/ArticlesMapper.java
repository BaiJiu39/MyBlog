package com.BaiJiu.mapper;

import com.BaiJiu.POJO.DTO.ArticlePageDTO;
import com.BaiJiu.POJO.Entity.Articles;
import com.BaiJiu.POJO.VO.ArticlesVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author miku
* @description 针对表【articles】的数据库操作Mapper
* @createDate 2024-03-30 18:32:09
* @Entity com.BaiJiu.Entity.Articles
*/
@Mapper
public interface ArticlesMapper extends BaseMapper<Articles> {


    @Select("select content from articles where article_id = #{id}")
    Articles selectContent(int id);
}




