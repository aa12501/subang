package com.subang.lost.controller;

import com.subang.lost.pojo.Pic;
import com.subang.lost.service.PicService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private PicService picService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", picService.findAll());
    }

    @RequestMapping(value = "/{picid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String picid){
        return new Result(true, StatusCode.OK, "查询成功", picService.findById(picid));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Pic pic){
        picService.save(pic);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{picid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Pic pic, @PathVariable String picid){
        picService.updateById(pic, picid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{picid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String picid) {
        picService.deleteById(picid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
