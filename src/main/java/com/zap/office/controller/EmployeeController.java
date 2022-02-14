package com.zap.office.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zap.office.commonutils.Result;
import com.zap.office.entity.Employee;
import com.zap.office.entity.vo.FindEmpVo;
import com.zap.office.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @author: ZhuApeng
 * @Title: EmployeeController
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 13:19
 */

@RestController
@RequestMapping("/office/emp")
@Api(tags = "员工管理")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "查询员工信息")
    @GetMapping ("/insertEmp/{empId}")
    public Result insertEmp(@PathVariable("empId")String empId){
        Employee employee = employeeService.selectEmp(empId);
        return Result.ok().data("emp",employee);
    }

    @ApiOperation(value = "插入员工信息")
    @PostMapping ("/insertEmp")
    public Result insertEmp(@RequestBody Employee employee){
        employeeService.save(employee);
        return Result.ok();
    }

    @ApiOperation(value = "修改员工信息")
    @PutMapping ("/updateEmp/{empId}")
    public Result updateEmp(@PathVariable("empId")String empId,@RequestBody Employee employee){
        employee.setId(empId);
        employeeService.updateEmp(employee);
        return Result.ok();
    }

    @ApiOperation(value = "删除员工信息")
    @DeleteMapping ("/deleteEmp/{empId}")
    public Result deleteEmp(@PathVariable("empId")String empId){
        boolean idSuccess = employeeService.deleteEmp(empId);
        if(idSuccess) {
            return Result.ok();
        }else {
            return Result.error().msg("删除失败！");
        }
    }

    @ApiOperation(value = "查询所有分页员工信息")
    @GetMapping("/getAllEmp/{current}/{limit}")
    public Result getAllPageEmp(@PathVariable("current")long current,@PathVariable("limit")long limit){
        Page<Employee> empPage = employeeService.getAllPageEmp(current,limit);
        return Result.ok().data("emp",empPage);
    }

    @ApiOperation(value = "按条件查询所有分页员工信息")
    @GetMapping("/getAllEmpByCondition/{current}/{limit}")
    public Result getAllPageEmpByCondition(@PathVariable("current")long current,
                                           @PathVariable("limit")long limit,
                                           @RequestBody(required = false) FindEmpVo findEmpVo){
        Page<Employee> page = new Page<>(current,limit);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(findEmpVo.getEmpName())){
            wrapper.like("emp_name",findEmpVo.getEmpName());
        }

        if(!StringUtils.isEmpty(findEmpVo.getAge())){
            wrapper.eq("emp_age",findEmpVo.getAge());
        }
        if(!StringUtils.isEmpty(findEmpVo.getBegin())){
            wrapper.ge("gmt_create",findEmpVo.getBegin());
        }
        if(!StringUtils.isEmpty(findEmpVo.getEnd())){
            wrapper.le("gmt_modified",findEmpVo.getEnd());
        }
        Page<Employee> empPage = employeeService.page(page, wrapper);
        return Result.ok().data("emp",empPage);
    }
}
