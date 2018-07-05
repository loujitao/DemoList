package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.XueliBiz;
import com.lgw.po.Xueli;
import com.lgw.po.XueliExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/xueli")
public class XueliAction {

    @Autowired
    private XueliBiz xueliBiz;

    @RequestMapping("/listxueli")
    public String liststatus(Model model, Xueli xueli, @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int pages){
        XueliExample example=new XueliExample();
        String name=null;
        if(xueli!=null&&xueli.getXname()!=null&&!"".equals(xueli.getXname())){
            //条件查询
            XueliExample.Criteria c=example.createCriteria();
            name=xueli.getXname();
            c.andXnameLike("%"+xueli.getXname()+"%");
        }
        PageInfo pageInfo=xueliBiz.selectByExample(example,pageNum,pageSize);
        List<Xueli> sList=pageInfo.getList();
        if (null!=sList){
            model.addAttribute("xList",sList);
            model.addAttribute("pageInfo",pageInfo);
            if(name!=null){
                model.addAttribute("name",name);
            }
//            return "forward:/static/xueli/list.jsp";
            return "/xueli/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }

    @RequestMapping("addxueli")
    public String addXueli(Model model,Xueli xueli){
        XueliExample example=new XueliExample();
        XueliExample.Criteria c=example.createCriteria();
        c.andXidIsNotNull();
        List<Xueli> xList=xueliBiz.selectByExample(example);
        model.addAttribute("xList",xList);
//        return "forward:/static/xueli/add.jsp";
        return "/xueli/add";
    }

    @RequestMapping("add")
    public String add(Model model,Xueli xueli){
        int i=xueliBiz.insertSelective(xueli);
        if (i>0){
            model.addAttribute("msg","添加成功！");
        }else {
            model.addAttribute("msg","添加失败！");
        }
        return "redirect:/xueli/listxueli";
    }

    @RequestMapping("deletexueli")
    public String deleteXueli(Model model,Xueli xueli){
        if (xueli!=null){
            int i=xueliBiz.deleteByPrimaryKey(xueli.getXid());
            if (i>0){
                model.addAttribute("delete","删除成功");
            }else {
                model.addAttribute("delete","删除失败！");
            }
        }else {
            model.addAttribute("delete","用户为空！");
        }
        return "redirect:/xueli/listxueli";
    }

    @RequestMapping("updatexueli")
    public String updateXueli(Model model,Xueli xueli){
        if (xueli!=null&&xueli.getXid()!=null){
            xueli=(Xueli) xueliBiz.selectByPrimaryKey(xueli.getXid());
            model.addAttribute("xueli",xueli);
//            return "forward:/static/xueli/update.jsp";
            return "/xueli/update";
        }else {
            model.addAttribute("update","用户为空！");
            return "redirect:/xueli/listxueli";
        }
    }

    @RequestMapping("update")
    public String update(Model model,Xueli xueli){
        if (xueli!=null){
            XueliExample example=new XueliExample();
            XueliExample.Criteria c=example.createCriteria();
            c.andXidEqualTo(xueli.getXid());
            int i=xueliBiz.updateByExample(xueli,example);
            if (i>0){
                model.addAttribute("update","修改成功");
            }else {
                model.addAttribute("update","修改失败");
            }
        }else {
            model.addAttribute("update","用户为空");
        }
        return "redirect:/xueli/listxueli";
    }

}
