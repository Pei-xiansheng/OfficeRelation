package com.zap.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zap.office.entity.Notice;

import java.util.List;

/**
 * @author: ZhuApeng
 * @Title: NoticeService
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/20 18:02
 */

public interface NoticeService extends IService<Notice> {
    //获取公告信息
    List<Notice> getNoticeInfo();
}
