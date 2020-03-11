package com.subang.lost.controller;

import com.subang.lost.pojo.Collect;
import com.subang.lost.service.CollectService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", collectService.findAll());
    }

    @RequestMapping(value = "/{collectid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String collectid){
        return new Result(true, StatusCode.OK, "查询成功", collectService.findById(collectid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Collect collect){
        collectService.save(collect);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{collectid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Collect collect, @PathVariable String collectid){
        collectService.updateById(collect, collectid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{collect}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String collectid){
        collectService.deleteById(collectid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
