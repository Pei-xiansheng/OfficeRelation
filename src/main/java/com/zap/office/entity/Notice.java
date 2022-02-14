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
 * @Title: Notice
 * @ProjectName: OfficeRelation
 * @Description:    公告信息
 * @date: 2021/10/20 17:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String notName;

    private String notContent;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
