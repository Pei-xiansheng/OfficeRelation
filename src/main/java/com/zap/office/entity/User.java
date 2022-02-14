package com.zap.office.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: User
 * @ProjectName: OfficeRelation
 * @Description: 用户管理
 * @date: 2021/10/14 17:23
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "off_user")
public class User {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String userName;

    private String passWord;

    private String avatar;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
