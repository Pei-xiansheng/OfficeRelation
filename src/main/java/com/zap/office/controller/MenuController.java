package com.zap.office.controller;

import com.zap.office.commonutils.Result;
import com.zap.office.entity.Permission;
import com.zap.office.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: MenuController
 * @ProjectName: OfficeRelation
 * @Description: 菜单处理
 * @date: 2021/10/14 17:33
 */
@RestController
@RequestMapping("/office/menu")
@Api(tags = "菜单管理")
@CrossOrigin
public class MenuController {

    @Autowired
    MenuService menuService;

    @ApiOperation(value = "获取菜单")
    @GetMapping("/getMenuList")
    public Result getMenuList(){
       List<Permission> menuList = menuService.getMenu();
       return Result.ok().data("menuList",menuList);
    }

    @ApiOperation(value = "通过用户信息获取菜单")
    @GetMapping("/getMenuByUser/{userId}")
    public Result getMenuByUser(@PathVariable("userId")String userId){
        List<Permission> perList = menuService.getMenuByUser(userId);
        return Result.ok().data("perList",perList);
    }

}
