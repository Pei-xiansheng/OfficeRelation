package com.zap.office.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zap.office.entity.Apply;

/**
 * @author: ZhuApeng
 * @Title: ApplyService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:17
 */

public interface ApplyService extends IService<Apply> {
    //获取申请表信息
    Apply getApplyInfo(String id);
    //审批申请表
    boolean approvalApply(String id);
}
