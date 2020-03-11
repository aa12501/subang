package com.subang.qa.controller;

import com.subang.qa.pojo.Reply;
import com.subang.qa.service.ReplyService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", replyService.findAll());
    }

    @RequestMapping(value = "/{replyid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String replyid){
        return new Result(true, StatusCode.OK, "查询成功", replyService.findById(replyid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Reply reply){
        replyService.save(reply);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{replyid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Reply reply, @PathVariable String replyid){
        replyService.updateById(reply, replyid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{reply}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String replyid){
        replyService.deleteById(replyid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
