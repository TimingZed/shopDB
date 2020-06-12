package com.timing.controller;

import com.timing.pojo.Message;
import com.timing.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("/listMessage")
    public String listMessage(Model model){
        List<Message> list = messageService.listMessage();
        model.addAttribute("list",list);
        return "manageLeaveword";
    }

    @RequestMapping("/findMessageId")
    public ModelAndView findMessageId(Integer id){
        ModelAndView mv=new ModelAndView();
        Message message= messageService.findMessageId(id);
        System.out.println(message);
        mv.addObject("message",message);
        mv.setViewName("leavewordInfo");
        return mv;
    }

    @RequestMapping("/removeMessageId")
    public void removeMessageId(Integer[] removeMessage, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(null!=removeMessage){
            messageService.removeMessageId(removeMessage);

            response.sendRedirect(request.getContextPath()+"/message/listMessage");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<script>window.alert('没有要删除的哦');window.location.href=history.back();</script>");
    }

}
