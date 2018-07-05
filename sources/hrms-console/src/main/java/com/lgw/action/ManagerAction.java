package com.lgw.action;

import com.lgw.po.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerAction {

    @RequestMapping("/login")
    public String login(HttpSession session, Model model, Manager manager){
        if(manager!=null){

                if("admin".equals(manager.getMname().trim())&&"123".equals(manager.getMpwd().trim())){
                    session.setAttribute("manager","admin");
                    return "forward:/static/background/index.jsp";
                }else {
                    model.addAttribute("error","用户名或密码错误！（admin/123）");
                    return "forward:/login.jsp";
                }
        }else {
            model.addAttribute("error","用户名或密码错误！（admin/123）");
            return "forward:/login.jsp";
        }

    }

}
