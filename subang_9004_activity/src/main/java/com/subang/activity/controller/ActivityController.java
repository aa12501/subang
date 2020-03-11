package com.subang.activity.controller;

import com.subang.activity.pojo.Activity;
import com.subang.activity.service.ActivityService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", activityService.findAll());
    }

    @RequestMapping(value = "/{activityid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String activityid){
        return new Result(true, StatusCode.OK, "查询成功", activityService.findById(activityid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Activity activity){
        activityService.save(activity);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{activityid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Activity activity, @PathVariable String activityid){
        activityService.updateById(activity, activityid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{activityid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String activityid){
        activityService.deleteById(activityid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
