package com.zap.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zap.office.entity.User;
import com.zap.office.entity.vo.EmpUserVo;
import org.springframework.stereotype.Repository;

/**
 * @author: ZhuApeng
 * @Title: UserLoginMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/11/29 20:01
 */

@Repository
public interface UserCenterMapper extends BaseMapper<User> {
    //验证登录
    User userLogin(User user);
    //获取注册信息
    EmpUserVo getEmpUserVo(EmpUserVo empUserVo);
}
