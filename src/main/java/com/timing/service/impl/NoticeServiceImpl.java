package com.timing.service.impl;

import com.timing.dao.INoticeDao;
import com.timing.pojo.Notice;
import com.timing.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeDao noticeDao;

    @Override
    public List<Notice> listNotice() {
        return noticeDao.listNotice();
    }

    @Override
    public void removeNoticeId(Integer[] noticeIds) {
        noticeDao.removeNoticeId(noticeIds);
    }

    @Override
    public void saveNotice(Notice notice) {
        noticeDao.saveNotice(notice);
    }


}
