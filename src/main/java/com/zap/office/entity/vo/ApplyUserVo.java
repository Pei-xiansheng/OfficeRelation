package com.zap.office.entity.vo;

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
 * @Title: ApplyUserVo
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 19:34
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyUserVo {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String EmpId;

    private String applyName;

    private String applyContent;

    private Integer isSuccess;

    private String empName;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
