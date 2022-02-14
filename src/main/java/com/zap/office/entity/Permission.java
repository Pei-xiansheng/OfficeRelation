package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: Permission
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 17:28
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "off_permission")
public class Permission {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String pId;

    private String perName;

    private Integer perLevel;

    private List<Permission> childern;

    private String perPath;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
