package com.zap.office.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zap.office.entity.Notice;
import com.zap.office.mapper.NoticeMapper;
import com.zap.office.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: NoticeServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:02
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper,Notice> implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;
    //获取公告信息
    @Override
    public List<Notice> getNoticeInfo() {
        List<Notice> noticeList = noticeMapper.getNoticeInfo();
        return noticeList;
    }
}
