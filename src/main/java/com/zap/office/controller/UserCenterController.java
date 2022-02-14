package com.zap.office.controller;

import com.zap.office.commonutils.GetRandom;
import com.zap.office.commonutils.JwtUtils;
import com.zap.office.commonutils.Result;
import com.zap.office.entity.User;
import com.zap.office.entity.vo.EmpUserVo;
import com.zap.office.service.UserCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author: ZhuApeng
 * @Title: LoginController
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/11/29 19:45
 */

@RestController
@RequestMapping("/office/center")
@Api(tags = "用户中心")
@CrossOrigin
public class UserCenterController {

    @Autowired
    UserCenterService userCenterService;

    @Autowired
    RedisTemplate redisTemplate;

    @ApiOperation("用户登录")
    @PostMapping("/getTokenInfo")
    public Result getTokenInfo(@RequestBody User user){
        String userToken = userCenterService.userLogin(user);
//        System.out.println(userToken);
        if(StringUtils.isEmpty(userToken)){
            return Result.error().msg("用户信息不存在！");
        }else {
            return Result.ok().msg("用户信息存在！").data("userToken",userToken);
        }
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo")
    public Result getUSerInfo(HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        User userInfo = userCenterService.getById(id);
        if(StringUtils.isEmpty(userInfo)){
            return Result.error().msg("用户未登录或是不存在信息！");
        }else {
            return Result.ok().data("item",userInfo);
        }
    }


    @ApiOperation("用户注册")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody EmpUserVo empUserVo){
       boolean isSuccess = userCenterService.userRegister(empUserVo);
        if(isSuccess){
            return Result.ok().msg("注册成功！");
        }else {
            return Result.error().msg("注册失败！");
        }
    }

    @ApiOperation("获取验证码")
    @GetMapping("/userCheckNum/{empPhone}")
    public Result getCheckNum(@PathVariable("empPhone") String empPhone){
        String checkNum = (String) redisTemplate.opsForValue().get("checkNum");
        if(!StringUtils.isEmpty(checkNum)){
            return Result.ok();
        }
        checkNum = GetRandom.getSixBitRandom();
        redisTemplate.opsForValue().set("checkNum",checkNum,5, TimeUnit.MINUTES);
        boolean flag = userCenterService.getCheckNum(empPhone, checkNum);
        if(flag){
            return Result.ok().msg("获取验证码成功！");
        }else {
            return Result.error().msg("获取验证码失败！");
        }
    }
}
