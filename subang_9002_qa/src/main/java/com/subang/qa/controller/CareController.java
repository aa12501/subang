package com.subang.qa.controller;

import com.subang.qa.pojo.Care;
import com.subang.qa.service.CareService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/care")
public class CareController {
    @Autowired
    private CareService careService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", careService.findAll());
    }

    @RequestMapping(value = "/{careid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String careid){
        return new Result(true, StatusCode.OK, "查询成功", careService.findById(careid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Care care){
        careService.save(care);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{careid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String careid){
        careService.deleteById(careid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
