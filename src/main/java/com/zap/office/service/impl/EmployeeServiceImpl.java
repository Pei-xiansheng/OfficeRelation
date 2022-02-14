package com.zap.office.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zap.office.entity.Employee;
import com.zap.office.mapper.EmployeeMapper;
import com.zap.office.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZhuApeng
 * @Title: EmployeeServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 13:47
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Page<Employee> getAllPageEmp(long current,long limit) {
        Page<Employee> page = new Page<>(current, limit);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        Page<Employee> employeePage = employeeMapper.selectPage(page, wrapper);
        return employeePage;
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.update(employee,null);
    }

    @Override
    public boolean deleteEmp(String empId) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("id",empId);
        int deleteNum = employeeMapper.delete(wrapper);
        if(deleteNum>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Employee selectEmp(String empId) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("id",empId);
        Employee employee = employeeMapper.selectOne(wrapper);
        return employee;
    }

}
