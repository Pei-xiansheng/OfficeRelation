package com.zap.office.service.impl;

import com.zap.office.entity.Permission;
import com.zap.office.entity.Role;
import com.zap.office.mapper.MenuMapper;
import com.zap.office.mapper.RoleMapper;
import com.zap.office.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: MenuServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 17:37
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Permission> getMenu() {
        List<Permission> menuList = menuMapper.getMenu();
        return buildMenu(menuList);
    }

    public List<Permission> buildMenu(List<Permission> menuList){
        ArrayList<Permission> finalList = new ArrayList<>();
        for (Permission menuNode:menuList
             ) {
            if("0".equals(menuNode.getPId())){
                System.out.println(menuNode);
                menuNode.setPerLevel(0);
                finalList.add(findChildern(menuNode,menuList));
            }
        }
        return finalList;
    }

    private Permission findChildern(Permission menuNode, List<Permission> menuList) {
        menuNode.setChildern(new ArrayList<Permission>());
        for (Permission childMenuNode:menuList
             ) {
            if(childMenuNode.getPId().equals(menuNode.getId())){
                Integer perLevel = menuNode.getPerLevel();
                childMenuNode.setPerLevel(perLevel+1);
                menuNode.getChildern().add(findChildern(childMenuNode,menuList));
            }
        }
        return menuNode;
    }


    //通过User的id获取菜单
    @Override
    public List<Permission> getMenuByUser(String userId) {
        List<Role> roleList = roleMapper.getRoleByUserId(userId);
        if(roleList.contains("admin")){
            return getMenu();
        }
        List<Permission> perList = menuMapper.getMenuByUser(userId);
        return perList;
    }
}
