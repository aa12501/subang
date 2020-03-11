package com.subang.qa.controller;

import com.subang.qa.pojo.Label;
import com.subang.qa.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String labelid){
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Label label, @PathVariable String labelid){
        labelService.updateById(label, labelid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelid){
        labelService.deleteById(labelid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
