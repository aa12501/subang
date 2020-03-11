package com.subang.vote.controller;

import com.subang.vote.pojo.Vote;
import com.subang.vote.service.VoteService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        // 查询全部文章
        return new Result(true, StatusCode.OK, "查询成功", voteService.findAll());
    }

    @RequestMapping(value = "/{voteid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String voteid) {
        // 根据id查询文章
        return new Result(true, StatusCode.OK, "查询成功", voteService.findById(voteid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Vote vote) {
        // 增加文章
        voteService.save(vote);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{voteid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Vote vote, @PathVariable String voteid) {
        // 根据id修改文章
        voteService.updateById(vote, voteid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{voteid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String voteid) {
        // 根据id删除文章
        voteService.deleteById(voteid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findsearch(@RequestBody Vote vote) {
        // 根据条件查询文章
        return new Result(true, StatusCode.OK, "查询成功", voteService.findSearch(vote));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findsearchByPage(@RequestBody Vote vote, @PathVariable int page, @PathVariable int size) {
        // 根据条件查询文章（分页）
        Page<Vote> pageData = voteService.findSearchByPage(vote, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }


}
