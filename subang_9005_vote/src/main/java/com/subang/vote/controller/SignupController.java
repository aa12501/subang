package com.subang.vote.controller;

import com.subang.vote.pojo.Signup;
import com.subang.vote.service.SignupService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", signupService.findAll());
    }

    @RequestMapping(value = "/{signupid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String signupid){
        return new Result(true, StatusCode.OK, "查询成功", signupService.findById(signupid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Signup signup){
        signupService.save(signup);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{signupid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Signup signup, @PathVariable String signupid){
        signupService.updateById(signup, signupid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{signupid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String signupid) {
        signupService.deleteById(signupid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
