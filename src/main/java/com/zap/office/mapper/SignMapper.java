package com.zap.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zap.office.entity.vo.SignEmpVo;
import org.springframework.stereotype.Repository;

/**
 * @author: ZhuApeng
 * @Title: SignMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/21 21:28
 */
@Repository
public interface SignMapper extends BaseMapper<SignEmpVo> {
    Integer updateState(String id);

    SignEmpVo findSignInfo(String id);
}
