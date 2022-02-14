package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author: ZhuApeng
 * @Title: Apply
 * @ProjectName: OfficeRelation
 * @Description:   申请表
 * @date: 2021/10/20 18:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apply {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String EmpId;

    private String applyName;

    private String applyContent;

    private Integer isSuccess;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
