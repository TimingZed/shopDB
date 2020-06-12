package com.timing.service;

import com.timing.pojo.Notice;

import java.util.List;

public interface INoticeService {
    /**
     * 查询所有公告信息
     * @return 所有公告集
     */
    List<Notice> listNotice();

    /**
     * 删除选中的公告
     * @param noticeIds 删除的数据id
     */
    void removeNoticeId(Integer[] noticeIds);

    /**
     * 添加公告
     * @param notice 公告对象
     */
    void saveNotice(Notice notice);
}
