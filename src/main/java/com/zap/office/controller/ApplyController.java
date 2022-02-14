package com.zap.office.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zap.office.commonutils.Result;
import com.zap.office.entity.Apply;
import com.zap.office.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author: ZhuApeng
 * @Title: ApplyController
 * @ProjectName: OfficeRelation
 * @Description:   申请表
 * @date: 2021/10/20 18:13
 */
@RestController
@RequestMapping("/office/apply")
@Api(tags = "申请表")
@CrossOrigin
public class ApplyController {

    @Autowired
    ApplyService applyService;

    @ApiOperation(value = "添加申请表")
    @PostMapping("/addApply/{id}")
    public Result addApplyInfo(@RequestBody Apply apply){
        boolean save = applyService.save(apply);
        if(save){
            return Result.ok().msg("插入成功！");
        }else {
            return Result.error().msg("删除失败！");
        }
    }

    @ApiOperation(value = "获取申请表")
    @GetMapping("/getApply/{id}")
    public Result getApplyInfo(@PathVariable("id")String id){
        Apply applyInfo =applyService.getApplyInfo(id);
        return Result.ok().data("applyInfo",applyInfo);
    }

    @ApiOperation(value = "修改申请表")
    @PutMapping("/updateApply")
    public Result updateApplyInfo(@RequestBody Apply apply){
        QueryWrapper<Apply> wrapper = new QueryWrapper<>();
        wrapper.eq("emp_id",apply.getEmpId());
        boolean update = applyService.update(apply, wrapper);
        if(update){
            return Result.ok().msg("申请表修改成功！");
        }else {
            return Result.error().msg("申请表申请失败！");
        }
    }

    @ApiOperation(value = "删除申请表")
    @DeleteMapping("/deleteApply/{id}")
    public Result deleteApplyInfo(@PathVariable("id")Integer id){
        QueryWrapper<Apply> wrapper = new QueryWrapper<>();
        wrapper.eq("emp_id",id);
        boolean remove = applyService.remove(wrapper);
        if(remove){
            return Result.ok().msg("申请表删除成功！");
        }else {
            return Result.error().msg("申请表删除失败！");
        }
    }

    @ApiOperation(value = "审批申请表")
    @PutMapping("/approvalApply/{id}")
    public Result approvalApply(@PathVariable("id")String id){
        boolean isSuccess = applyService.approvalApply(id);
        if(isSuccess){
            return Result.ok().msg("审批成功！");
        }else {
            return Result.error().msg("未通过审批！");
        }
    }

    @ApiOperation(value = "获取所有申请表")
    @GetMapping("/getAllApply/{current}/{limit}")
    public Result getAllApply(@PathVariable("current")long current,@PathVariable("limit")long limit){
        QueryWrapper<Apply> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("gmt_create");
        Page<Apply> page = new Page<>(current, limit);
        Page<Apply> pageInfo = applyService.page(page, wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("applyList",pageInfo.getRecords());
        map.put("currentPage",pageInfo.getCurrent());
        map.put("size",pageInfo.getSize());
        map.put("total",pageInfo.getTotal());
        map.put("hasNext",pageInfo.hasNext());
        map.put("hasPrevious",pageInfo.hasPrevious());
        return Result.ok().map(map);
    }

}
