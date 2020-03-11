package com.subang.lost.controller;

import com.subang.lost.pojo.Lost;
import com.subang.lost.service.LostService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", lostService.findAll());
    }

    @RequestMapping(value = "/{lostid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String lostid){
        return new Result(true, StatusCode.OK, "查询成功", lostService.findById(lostid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Lost lost){
        lostService.save(lost);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{lostid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Lost lost, @PathVariable String lostid){
        lostService.updateById(lost, lostid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{lostid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String lostid){
        lostService.deleteById(lostid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
