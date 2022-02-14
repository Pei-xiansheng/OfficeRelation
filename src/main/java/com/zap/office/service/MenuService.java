package com.zap.office.service;

import com.zap.office.entity.Permission;
import com.zap.office.entity.User;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: MenuService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 17:36
 */

public interface MenuService {
    //获取菜单信息
    public List<Permission> getMenu();
    //通过用户获取菜单
    List<Permission> getMenuByUser(String userId);
}
