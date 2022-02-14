package com.zap.office.commonutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ZhuApeng
 * @Title: MyException
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/12/2 10:47
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException{
    //异常状态码
    private Integer code;
    //异常信息
    private String msg;
}
