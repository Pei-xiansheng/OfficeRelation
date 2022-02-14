package com.zap.office.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zap.office.entity.Employee;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: EmployeeService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 13:45
 */

public interface EmployeeService extends IService<Employee> {
    //获取所有员工的信息
    Page<Employee> getAllPageEmp(long current, long limit);
    //插入员工
    void insertEmp(Employee employee);
    //修改员工
    void updateEmp(Employee employee);
    //删除员工
    boolean deleteEmp(String empId);
    //查询员工
    Employee selectEmp(String empId);
}
