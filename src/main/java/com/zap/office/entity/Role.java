package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: Role
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 17:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "off_role")
public class Role {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String roleName;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
