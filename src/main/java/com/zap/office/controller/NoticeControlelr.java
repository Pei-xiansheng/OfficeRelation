package com.zap.office.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zap.office.commonutils.Result;
import com.zap.office.entity.Notice;
import com.zap.office.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.pa.CurrencyNames_pa;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: NoticeControlelr
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 17:58
 */
@RestController
@RequestMapping("/office/notic")
@CrossOrigin
@Api(tags = "公告信息")
public class NoticeControlelr {

    @Autowired
    NoticeService noticeService;

    @ApiOperation(value = "获取公告信息")
    @GetMapping("/getNoticeInfo")
    public Result getNoticeInfo(){
        List<Notice> noticeList = noticeService.getNoticeInfo();
        return Result.ok().data("noticeList",noticeList);
    }

    @ApiOperation(value = "修改公告信息")
    @PutMapping("/updateNotice")
    public Result updateNotice(@RequestBody Notice notice){
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.eq("id",notice.getId());
        boolean update = noticeService.update(notice,wrapper);
        if(update){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "删除公告信息")
    @DeleteMapping("/deleteNotice/{id}")
    public Result updateNotice(@PathVariable("id")String id){
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        boolean remove = noticeService.remove(wrapper);
        if(remove){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "增加公告信息")
    @PostMapping("/addNotice")
    public Result addNotice(@RequestBody Notice notice){
        boolean save = noticeService.save(notice);
        if(save){
            return Result.ok().msg("添加公告信息成功！");
        }else {
            return Result.ok().msg("添加公告信息失败！");
        }
    }

}
