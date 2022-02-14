package com.zap.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zap.office.entity.vo.SignEmpVo;
import com.zap.office.mapper.SignMapper;
import com.zap.office.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZhuApeng
 * @Title: SignServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/21 21:25
 */

@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, SignEmpVo> implements SignService {

    @Autowired
    SignMapper signMapper;

    @Override
    public boolean updateState(String id) {
        Integer isSign = signMapper.updateState(id);
        if(isSign>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SignEmpVo findSignInfo(String id) {
        SignEmpVo signEmpVo = signMapper.findSignInfo(id);
        return signEmpVo;
    }
}
