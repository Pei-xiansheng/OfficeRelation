package com.zap.office.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: FindEmpVo
 * @ProjectName: OfficeRelation
 * @Description: 用于封装查询员工信息条件
 * @date: 2021/10/17 15:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindEmpVo {
    private String empName;
    private Integer age;
    private Date begin;
    private Date end;
}
