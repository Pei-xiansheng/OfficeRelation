package com.zap.office.service;

import com.zap.office.entity.Department;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: DepartmentService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 15:30
 */

public interface DepartmentService {
    //获取部门信息
    List<Department> getDeptInfo();

}
