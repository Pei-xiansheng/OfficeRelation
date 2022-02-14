package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: Department
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 12:16
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "off_department")
public class Department {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String deptName;

    private Integer deptNum;

    @TableField(fill = FieldFill.INSERT)
    private java.util.Date gmtCreate;

    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
