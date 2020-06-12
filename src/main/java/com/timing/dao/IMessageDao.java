package com.timing.dao;

import com.timing.pojo.Message;

import java.util.List;

public interface IMessageDao {

    /**
     * 查询 所有留言
     * @return 留言message结果集
     */
    List<Message> listMessage();

    /**
     * 查询  留言信息
     * @param id 留言编号
     * @return 留言信息
     */
    Message findMessageId(Integer id);

    /**
     * 删除选中的留言
     * @param ids 留言id数组
     */
    void removeMessageId(Integer[] ids);
}
