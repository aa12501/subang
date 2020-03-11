package com.subang.vote.controller;

import com.subang.vote.pojo.Selection;
import com.subang.vote.service.SelectionService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/selection")
public class SelectionController {
    @Autowired
    private SelectionService selectionService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        // 查询全部标签
        return new Result(true, StatusCode.OK, "查询成功", selectionService.findAll());
    }

    @RequestMapping(value = "/{selectionid}", method = RequestMethod.GET)
    public Result findById(@PathVariable String selectionid) {
        // 根据id查询标签
        return new Result(true, StatusCode.OK, "查询成功", selectionService.findById(selectionid));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Selection selection) {
        // 增加标签
        selectionService.save(selection);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{selectionid}", method = RequestMethod.POST)
    public Result updateById(@RequestBody Selection selection, @PathVariable String selectionid) {
        // 根据id修改标签
        selectionService.updateById(selection, selectionid);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{selectionid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String selectionid) {
        // 根据id删除标签
        selectionService.deleteById(selectionid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findsearch(@RequestBody Selection selection) {
        // 根据条件查询标签
        return new Result(true, StatusCode.OK, "查询成功", selectionService.findSearch(selection));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findsearchByPage(@RequestBody Selection selection, @PathVariable int page, @PathVariable int size) {
        // 根据条件查询标签（分页）
        Page<Selection> pageData = selectionService.findSearchByPage(selection, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }


}
