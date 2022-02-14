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
 * @Title: SignEmpVo
 * @ProjectName: OfficeRelation
 * @Description:   用户签到
 * @date: 2021/10/21 21:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignEmpVo {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String empName;

    private String content;

    private Integer isSign;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
