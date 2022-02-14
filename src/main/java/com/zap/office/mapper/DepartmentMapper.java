package com.zap.office.mapper;

import com.zap.office.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: DepartmentMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 15:33
 */

@Repository
public interface DepartmentMapper {
    //查询部门信息
    List<Department> getDeptInfo();
}
