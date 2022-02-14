package com.zap.office.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zap.office.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: NoticeMapper
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:05
 */

@Repository
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Notice> getNoticeInfo();
}
