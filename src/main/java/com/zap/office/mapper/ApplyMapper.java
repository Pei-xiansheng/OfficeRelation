package com.zap.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zap.office.entity.Apply;
import org.springframework.stereotype.Repository;

/**
 * @author: ZhuApeng
 * @Title: ApplyMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:20
 */
@Repository
public interface ApplyMapper extends BaseMapper<Apply> {
    Apply getApplyInfo(String id);

    Integer approvalApply(String id);
}
