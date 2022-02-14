package com.zap.office.mapper;


import com.zap.office.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: PermissionMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 9:54
 */
@Repository
public interface RoleMapper {
    List<Role> getRoleByUserId(String id);
}
