package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: Employee
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 11:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "off_employee")
public class Employee {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String userId;

    private String empName;

    private Integer empAge;

    private Integer empSalary;

    private Integer empDept;

    private String empPhone;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
