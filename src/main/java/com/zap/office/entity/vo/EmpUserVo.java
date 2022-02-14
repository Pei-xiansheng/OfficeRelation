package com.zap.office.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: EmpUserVo
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/17 15:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpUserVo {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String userName;

    private String passWord;

    private String empPhone;

    private String avatar;

    private Integer empAge;

    private Integer empSalary;

    private Integer empDept;

    private String checkWord;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
