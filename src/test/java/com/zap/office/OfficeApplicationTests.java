package com.zap.office;


import com.zap.office.commonutils.GetRandom;
import com.zap.office.entity.Department;
import com.zap.office.entity.Employee;
import com.zap.office.mapper.EmployeeMapper;
import com.zap.office.service.DepartmentService;
import com.zap.office.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@SpringBootTest
class OfficeApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    DataSource dataSource;
    @Test
    void insertEmp() throws SQLException {
//        Employee employee = new Employee(null, "Evan", 18, 9600, 1, new Date(), new Date());
//        employeeService.save(employee);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    void getDeptInfo() {
        List<Department> deptInfo = departmentService.getDeptInfo();
        for (Department dep:deptInfo
             ) {
            System.out.println(dep);
        }
    }

    @Test
    public void test(){
        System.out.println(GetRandom.getSixBitRandom());
    }

}
