package com.subang.qa.controller;

import com.subang.qa.pojo.Problem;
import com.subang.qa.service.ProblemService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", problemService.findAll());
    }

    @RequestMapping(value = "/{problemid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String problemid){
        return new Result(true, StatusCode.OK, "查询成功", problemService.findById(problemid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Problem problem){
        problemService.save(problem);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{problemid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Problem problem, @PathVariable String problemid){
        problemService.updateById(problem, problemid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{problem}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String problemid){
        problemService.deleteById(problemid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
