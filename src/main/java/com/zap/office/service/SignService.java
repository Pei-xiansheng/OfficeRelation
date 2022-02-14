package com.zap.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zap.office.entity.vo.SignEmpVo;

/**
 * @author: ZhuApeng
 * @Title: SignService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/21 21:24
 */

public interface SignService extends IService<SignEmpVo> {
    //用户签到
    boolean updateState(String id);
    //查询用户签到信息
    SignEmpVo findSignInfo(String id);
}
