package com.subang.activity.controller;

import com.subang.activity.pojo.Label;
import com.subang.activity.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        // 查询全部标签
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String labelid) {
        // 根据id查询标签
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        // 增加标签
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Label label, @PathVariable String labelid) {
        // 根据id修改标签
        labelService.updateById(label, labelid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{labelid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelid) {
        // 根据id删除标签
        labelService.deleteById(labelid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findsearch(@RequestBody Label label) {
        // 根据条件查询标签
        return new Result(true, StatusCode.OK, "查询成功", labelService.findSearch(label));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findsearchByPage(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        // 根据条件查询标签（分页）
        Page<Label> pageData = labelService.findSearchByPage(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }


}
