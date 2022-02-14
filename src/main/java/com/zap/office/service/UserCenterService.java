package com.zap.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zap.office.entity.User;
import com.zap.office.entity.vo.EmpUserVo;

/**
 * @author: ZhuApeng
 * @Title: UserLoginService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/11/29 19:57
 */

public interface UserCenterService extends IService<User> {
    //登录校验
    String userLogin(User user);

    //注册用户
    boolean userRegister(EmpUserVo empUserVo);

    //获取验证码
    boolean getCheckNum(String empPhone,String code);
}
