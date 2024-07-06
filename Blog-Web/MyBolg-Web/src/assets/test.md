# 开发日志

## 开发目标
- 实现增删改查功能 
- 制作图形化界面
- 添加季度追番功能
- 实现追番更新提醒
- 爬取季度番剧数据


## 技术栈
- java
- SQLite

```java
 public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements ArticlesService {

    @Autowired
    ArticlesMapper articlesMapper;


    @Override
    public PageResult getList(ArticlePageDTO articlePageDTO) {
        //查询前十条
        Page<Articles> page = new Page<>(articlePageDTO.getPage(), articlePageDTO.getPageSize());
        QueryWrapper<Articles> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Articles.class,tableFieldInfo -> !tableFieldInfo.getProperty().equals("content"));
        IPage<Articles> articlesPage = articlesMapper.selectPage(page,queryWrapper);

        return new PageResult(articlesPage.getTotal(), articlesPage.getRecords());
    }


}

 
```

![alt text](/src/assets/R.jpg )