package com.zap.office.controller;

import com.zap.office.commonutils.Result;
import com.zap.office.entity.Department;
import com.zap.office.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: DepartmentController
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/12/7 10:15
 */

@RestController
@RequestMapping("/office/dept")
@CrossOrigin
@Api(tags = "部门操作")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @ApiOperation(value = "查询部门信息")
    @RequestMapping("/getDeptInfo")
    public Result getDeptInfo(){
        List<Department> deptList = departmentService.getDeptInfo();
        return Result.ok().data("deptInfo",deptList);
    }
}
