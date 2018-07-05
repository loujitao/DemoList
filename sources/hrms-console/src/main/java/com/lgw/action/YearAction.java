package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.YearBiz;
import com.lgw.po.Year;
import com.lgw.po.YearExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/year")
public class YearAction {

    @Autowired
    private YearBiz yearBiz;

    @RequestMapping("/listyear")
    public String liststatus(Model model, Year year, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int pages){
        YearExample example=new YearExample();
        String name=null;
        if(year!=null&&year.getYname()!=null&&!"".equals(year.getYname())){
            YearExample.Criteria c=example.createCriteria();
            name=year.getYname();
            c.andYnameLike("%"+year.getYname()+"%");
            example.equals(" yname DESC ");
        }
        PageInfo pageInfo=yearBiz.selectByExample(example,pageNum,pageSize);
        List<Year> sList=pageInfo.getList();
        if (null!=sList){
            model.addAttribute("yList",sList);
            model.addAttribute("pageInfo",pageInfo);
            if(name!=null){
                model.addAttribute("name",name);
            }
//            return "forward:/static/year/list.jsp";
            return "/year/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }

    @RequestMapping("addyear")
    public String addXueli(Model model,Year year){
        YearExample example=new YearExample();
        YearExample.Criteria c=example.createCriteria();
        c.andYidIsNotNull();
        List<Year> xList=yearBiz.selectByExample(example);
        model.addAttribute("xList",xList);
//        return "forward:/static/year/add.jsp";
        return "/year/add";
    }

    @RequestMapping("add")
    public String addStatus(Model model, Year year){
        int i=yearBiz.insertSelective(year);
        if (i>0){
            model.addAttribute("msg","添加成功！");
        }else {
            model.addAttribute("msg","添加失败！");
        }
        return "redirect:/year/listyear";
    }

    @RequestMapping("deleteyear")
    public String deleteXueli(Model model,Year year){
        if (year!=null){
            int i=yearBiz.deleteByPrimaryKey(year.getYid());
            if (i>0){
                model.addAttribute("delete",year.getYid());
            }else {
                model.addAttribute("delete","删除失败！");
            }
        }else {
            model.addAttribute("delete","用户为空！");
        }
        return "redirect:/year/listyear";
    }

    @RequestMapping("updateyear")
    public String updateYear(Model model,Year year){
        if (year!=null&&year.getYid()!=null){
            year=(Year) yearBiz.selectByPrimaryKey(year.getYid());
            model.addAttribute("year",year);
//            return "forward:/static/year/update.jsp";
            return "/year/update";
        }
        model.addAttribute("year","用户为空！");
        return "redirect:/year/listyear";
    }

    @RequestMapping("update")
    public String update(Model model,Year year){
        if (year!=null){
            YearExample example=new YearExample();
            YearExample.Criteria c=example.createCriteria();
            c.andYidEqualTo(year.getYid());
            int i=yearBiz.updateByExample(year,example);
            if (i>0){
                model.addAttribute("msg","修改成功！");
            }else {
                model.addAttribute("msg","修改失败！");
            }
        }else {
            model.addAttribute("msg","用户为空！");
        }
        return "redirect:/year/listyear";
    }
}
