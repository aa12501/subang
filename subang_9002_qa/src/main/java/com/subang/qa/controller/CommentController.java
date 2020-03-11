package com.subang.qa.controller;

import com.subang.qa.pojo.Comment;
import com.subang.qa.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", commentService.findAll());
    }

    @RequestMapping(value = "/{commentid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String commentid){
        return new Result(true, StatusCode.OK, "查询成功", commentService.findById(commentid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment){
        commentService.save(comment);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{commentid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Comment comment, @PathVariable String commentid){
        commentService.updateById(comment, commentid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{comment}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String commentid){
        commentService.deleteById(commentid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
