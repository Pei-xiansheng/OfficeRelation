package com.zap.office.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author: ZhuApeng
 * @Title: UserMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 9:49
 */
@Repository
public interface UserMapper {
    Integer getRoleId(Integer id);
}
