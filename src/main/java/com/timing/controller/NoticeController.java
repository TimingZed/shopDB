package com.timing.controller;

import com.timing.pojo.Notice;
import com.timing.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;

    @RequestMapping("/listNotice")
    public String listNotice(Model model){
        List<Notice> list = noticeService.listNotice();
        model.addAttribute("list",list);
        return "manageGonggao";
    }

    @RequestMapping("/removeNoticeId")
    public void removeNoticeId(Integer[] removeNoticeId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(null!=removeNoticeId){
            noticeService.removeNoticeId(removeNoticeId);
            response.sendRedirect(request.getContextPath()+"/notice/listNotice");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<script>window.alert('没有要删除的哦');window.location.href=history.back();</script>");
    }

    @RequestMapping("/saveNotice")
    public void saveNotice(Notice notice, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(notice);
        boolean isnull=notice.getTitle().equals(null)||notice.getTitle().equals("")||
                notice.getContent().equals(null)||notice.getContent().equals("");
        if(!isnull){
            noticeService.saveNotice(notice);
            response.sendRedirect(request.getContextPath()+"/notice/listNotice");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<script>window.alert('标题和内容不能为空哦！');window.location.href=history.back();</script>");
    }

}
