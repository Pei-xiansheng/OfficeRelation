package com.zap.office.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zap.office.commonutils.Result;
import com.zap.office.entity.Sign;
import com.zap.office.entity.vo.SignEmpVo;
import com.zap.office.service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author: ZhuApeng
 * @Title: SignController
 * @ProjectName: OfficeRelation
 * @Description:    签到
 * @date: 2021/10/21 21:10
 */

@RestController
@RequestMapping("/office/sign")
@CrossOrigin
@Api(tags = "签到管理")
public class SignController {

    @Autowired
    SignService signService;

    @ApiOperation("员工签到")
    @PostMapping("/updateSign/{id}")
    public Result updateSign(@PathVariable("id")String id){
        boolean isSign = signService.updateState(id);
        if(isSign){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    @ApiOperation("查询员工签到信息")
    @GetMapping("/findSignInfo/{id}")
    public Result findSignInfo(@PathVariable("id")String id){
        SignEmpVo signEmpVo = signService.findSignInfo(id);
        return Result.ok().data("signEmpVo",signEmpVo);
    }

    @ApiOperation("查询签到信息表")
    @GetMapping("/getSignList/{current}/{limit}")
    public Result getSignList(@PathVariable("current")long current, @PathVariable("limit")long limit){
        Page<SignEmpVo> page = new Page<>(current,limit);
        QueryWrapper<SignEmpVo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        Page<SignEmpVo> pageSign = signService.page(page, wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("applyList",pageSign.getRecords());
        map.put("currentPage",pageSign.getCurrent());
        map.put("size",pageSign.getSize());
        map.put("total",pageSign.getTotal());
        map.put("hasNext",pageSign.hasNext());
        map.put("hasPrevious",pageSign.hasPrevious());
        return Result.ok().map(map);
    }
}
