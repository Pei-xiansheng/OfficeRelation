package com.zap.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zap.office.entity.Apply;
import com.zap.office.mapper.ApplyMapper;
import com.zap.office.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZhuApeng
 * @Title: ApplyServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:17
 */
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper,Apply> implements ApplyService{
    
    @Autowired
    ApplyMapper applyMapper;
    
    @Override
    public Apply getApplyInfo(String id) {
        Apply applyInfo =applyMapper.getApplyInfo(id);
        return applyInfo;
    }

    @Override
    public boolean approvalApply(String id) {
        Integer integer = applyMapper.approvalApply(id);
        if(integer>0){
            return true;
        }else {
            return false;
        }
    }
}
