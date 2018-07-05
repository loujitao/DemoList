package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.StatusBiz;
import com.lgw.po.Status;
import com.lgw.po.StatusExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusAction{

    @Autowired
    private StatusBiz statusBiz;

    @RequestMapping("/liststatus")
    public String liststatus(Model model, Status status, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "10") int pages){
        StatusExample example=new StatusExample();
        String name=null;
        if(status!=null&&status.getStname()!=null&&!"".equals(status.getStname())){
            StatusExample.Criteria c=example.createCriteria();
            name=status.getStname();
            c.andStnameLike("%"+status.getStname()+"%");
        }
        PageInfo pageInfo=statusBiz.selectByExample(example,pageNum,pageSize);
        List<Status> sList=pageInfo.getList();
        if (null!=sList){
            model.addAttribute("sList",sList);
            model.addAttribute("pageInfo",pageInfo);
            if(name!=null){
                model.addAttribute("name",name);
            }
//            return "forward:/static/status/list.jsp";
            return "/status/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }

    @RequestMapping("selectstatus")
    public String selectstatus(Model model,Status status){
        StatusExample example=new StatusExample();
        StatusExample.Criteria c=example.createCriteria();
        c.andStnameEqualTo(status.getStname());
        List<Status> sList=statusBiz.selectByExample(example);
        if (sList!=null){
            model.addAttribute("select",sList);
        }
//        return "forward:/static/status/list.jsp";
        return "/status/list";
    }

    @RequestMapping("addstatus")
    public String addStatus(Model model, Status status){
        StatusExample example=new StatusExample();
        StatusExample.Criteria c=example.createCriteria();
        c.andStidIsNotNull();
        List<Status> sList=statusBiz.selectByExample(example);
        model.addAttribute("add",sList);
//        return "forward:/static/status/add.jsp";
        return "/status/add";
    }

    @RequestMapping("/add")
    public String add(Model model, Status status){
        int i=statusBiz.insertSelective(status);
        if (i>0) {
            model.addAttribute("add", "添加成功");
            return "redirect:/status/liststatus";
        }else {
            model.addAttribute("add", "添加失败");
//            return "forward:/static/status/add.jsp";
            return "/status/add";
        }
    }

    @RequestMapping("deletestatus")
    public String deleteStatus(Model model, Status status){
        if (status!=null){
            int i=statusBiz.deleteByPrimaryKey(status.getStid());
            if (i>0){
                model.addAttribute("delete",status.getStid());
            }else {
                model.addAttribute("delete","删除失败");
            }
        }else {
            model.addAttribute("delete","用户为空");
        }
        return "redirect:/status/liststatus";
    }

    @RequestMapping("updatestatus")
    public String updateStatus(Model model,Status status){
        if (status.getStid()!=null&&status!=null){
            status =(Status) statusBiz.selectByPrimaryKey(status.getStid());
            model.addAttribute("status",status);
//            return "forward:/static/status/update.jsp";
            return "/status/update";
        }
        model.addAttribute("msg","修改失败");
        return "redirect:/status/liststatus";
    }

    @RequestMapping("update")
    public String update(Model model,Status status){
        if (status!=null){
            StatusExample example=new StatusExample();
            StatusExample.Criteria c=example.createCriteria();
            c.andStidEqualTo(status.getStid());
            int i=statusBiz.updateByExample(status,example);

            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }

        }else {
            model.addAttribute("msg", "修改失败");
        }
        return "redirect:/status/liststatus";
    }

    /*@RequestMapping("/list")
    public String list(Model model, Status status, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int pages){
        StatusExample example=new StatusExample();
        String name=null;
        if(status!=null&&status.getStname()!=null){
            StatusExample.Criteria c=example.createCriteria();
            name=status.getStname();
        }
        PageInfo pageInfo=statusBiz.selectByExample(example,pageNum,pageSize);
        List<Status> sList=pageInfo.getList();
        if (null!=sList){
            model.addAttribute("sList",sList);
            model.addAttribute("pageInfo",pageInfo);
            return "forward:/static/status/list1.jsp";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }*/
}
