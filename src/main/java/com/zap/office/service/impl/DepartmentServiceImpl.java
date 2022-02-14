package com.zap.office.service.impl;

import com.zap.office.entity.Department;
import com.zap.office.mapper.DepartmentMapper;
import com.zap.office.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: DepartmentServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 15:31
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDeptInfo() {
        List<Department> deptList = departmentMapper.getDeptInfo();
        return deptList;
    }
}
