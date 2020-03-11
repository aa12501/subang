package com.subang.article.controller;

import com.subang.article.pojo.Article;
import com.subang.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        // 查询全部文章
        return new Result(true, StatusCode.OK, "查询成功", articleService.findAll());
    }

    @RequestMapping(value = "/{articleid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String articleid) {
        // 根据id查询文章
        return new Result(true, StatusCode.OK, "查询成功", articleService.findById(articleid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        // 增加文章
        articleService.save(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{articleid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Article article, @PathVariable String articleid) {
        // 根据id修改文章
        articleService.updateById(article, articleid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{articleid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String articleid) {
        // 根据id删除文章
        articleService.deleteById(articleid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findsearch(@RequestBody Article article) {
        // 根据条件查询文章
        return new Result(true, StatusCode.OK, "查询成功", articleService.findSearch(article));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findsearchByPage(@RequestBody Article article, @PathVariable int page, @PathVariable int size) {
        // 根据条件查询文章（分页）
        Page<Article> pageData = articleService.findSearchByPage(article, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }


}
