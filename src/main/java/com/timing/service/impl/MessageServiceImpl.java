package com.timing.service.impl;

import com.timing.dao.IMessageDao;
import com.timing.dao.IUserDao;
import com.timing.pojo.Message;
import com.timing.service.IMessageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements IMessageSevice {

    @Autowired
    private IMessageDao messageDao;

    @Override
    public List<Message> listMessage() {
        return messageDao.listMessage();
    }

    @Override
    public Message findMessageId(Integer id) {
        return messageDao.findMessageId(id);
    }

    @Override
    public void removeMessageId(Integer[] ids) {
        messageDao.removeMessageId(ids);
    }
}
