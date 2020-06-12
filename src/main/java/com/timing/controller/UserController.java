package com.timing.controller;

import com.timing.pojo.User;
import com.timing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/listUser")
    public String listUser(Model model){
        List<User> list = userService.listUser();
        model.addAttribute("list",list );
        return "manageUser";
    }

    @RequestMapping("/findUserId")
    public String findUserId(Integer id,Model model) throws IOException {
        User user=userService.findUserId(id);
        model.addAttribute("user",user);
        return "lookUserinfo";
    }

    @RequestMapping("/saveUser")
    public void saveUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/user/listUser");
    }

    @RequestMapping("/removeUserId")
    public void removeUserId(Integer[] removeUserId, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (null==removeUserId){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script>window.alert('没有要删除的哦');window.location.href=history.back();</script>");
        }
        userService.removeUserId(removeUserId);
        response.sendRedirect(request.getContextPath()+"/user/listUser");
    }

}
