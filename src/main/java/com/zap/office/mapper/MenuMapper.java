package com.zap.office.mapper;

import com.zap.office.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: MenuMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 17:38
 */

@Repository
public interface MenuMapper {
    //获取全部菜单
    List<Permission> getMenu();
    //通过User获取菜单信息
    List<Permission> getMenuByUser(String userId);
}
