package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.ScaleBiz;
import com.lgw.po.Salary;

import com.lgw.po.Scale;
import com.lgw.po.ScaleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/scale")
public class ScaleAction {

    @Autowired
    private ScaleBiz scaleBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/scale/addScale.jsp";
        return "/scale/addScale";
    }

    @RequestMapping("/addScale")
    public String add(Model model,Scale scale){
        int i= scaleBiz.insert(scale);
        if (i > 0) {
            model.addAttribute("msg", "添加成功");
            return "redirect:/scale/queryAll";
        } else {
            model.addAttribute("msg", "添加失败");
            return "forward:/scale/doadd";
        }
    }


    @RequestMapping("/doupdate")
    public String updateSalary(Model model,String sid,Scale scale){

        if (scale.getSid()!=null&&scale!=null){
            scale =(Scale) scaleBiz.selectByPrimaryKey(scale.getSid());
            model.addAttribute("scale",scale);
//            return "forward:/static/scale/update.jsp";
            return "/scale/update";
        }
        model.addAttribute("msg","修改失败");
        return "redirect:/scale/queryAll";
    }

    @RequestMapping("/update")
    public String update(Model model,Scale scale){
        if(null!=scale){
            ScaleExample scaleExample=new ScaleExample();
            ScaleExample.Criteria c=scaleExample.createCriteria();
            c.andSidEqualTo(scale.getSid());
            int i=scaleBiz.updateByExample(scale,scaleExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/scale/queryAll";

    }


    @RequestMapping("delete")
    public String deletCity(Model model,Scale scale){
        if(scale!=null&&scale.getSid()!=null){
            ScaleExample example=new ScaleExample();
            ScaleExample.Criteria c=example.createCriteria();
            c.andSidEqualTo(scale.getSid());
            int i=  scaleBiz.deleteByExample(example);
            if(i>0){
                model.addAttribute("msg","删除成功");
            }
        }
        model.addAttribute("msg","删除失败");
        return "redirect:/scale/queryAll";
    }



    @RequestMapping("/queryAll")
    public String queryAll(Model model, @RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue ="10") int pageSize){
        PageInfo<Scale> scalePageInfo=scaleBiz.selectByExample(new ScaleExample(),pageIndex,pageSize);
        model.addAttribute("scalePageInfo",scalePageInfo);
//        return "forward:/static/scale/list.jsp";
        return "/scale/list";
    }

}
