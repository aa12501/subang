package com.subang.article.controller;

import com.subang.article.pojo.Comment;
import com.subang.article.service.CommentService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        // 查询全部评论
        return new Result(true, StatusCode.OK, "查询成功", commentService.findAll());
    }

    @RequestMapping(value = "/{commentid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String commentid) {
        // 根据id查询评论
        return new Result(true, StatusCode.OK, "查询成功", commentService.findById(commentid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        // 增加评论
        commentService.save(comment);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{commentid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Comment comment, @PathVariable String commentid) {
        // 根据id修改评论
        commentService.updateById(comment, commentid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{commentid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String commentid) {
        // 根据id删除评论
        commentService.deleteById(commentid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findsearch(@RequestBody Comment comment) {
        // 根据条件查询评论
        return new Result(true, StatusCode.OK, "查询成功", commentService.findSearch(comment));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findsearchByPage(@RequestBody Comment comment, @PathVariable int page, @PathVariable int size) {
        // 根据条件查询评论（分页）
        Page<Comment> pageData = commentService.findSearchByPage(comment, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }
}
