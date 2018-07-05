package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.SalaryBiz;
import com.lgw.po.Salary;
import com.lgw.po.SalaryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryAction {

    @Autowired
    private SalaryBiz salaryBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/salary/addSalary.jsp";
        return "/salary/addSalary";
    }

    @RequestMapping("/addSalary")
        public String add(Model model,Salary salary){
            int i= salaryBiz.insert(salary);
                if (i > 0) {
                    model.addAttribute("msg", "添加成功");
                    return "redirect:/salary/queryAll";
                } else {
                    model.addAttribute("msg", "添加失败");
                    return "forward:/salary/doadd";
                }
    }

    @RequestMapping("/doupdate")
    public String updateSalary(Model model,String sid,Salary salary){

        if (salary.getSid()!=null&&salary!=null){
            salary =(Salary) salaryBiz.selectByPrimaryKey(salary.getSid());
            model.addAttribute("salary",salary);
//            return "forward:/static/salary/update.jsp";
            return "/salary/update";
        }
        model.addAttribute("msg","修改失败");
        return "redirect:/salary/queryAll";
    }






    @RequestMapping("/update")
    public String update(Model model,Salary salary){
        if(null!=salary){
            SalaryExample salaryExample=new SalaryExample();
            SalaryExample.Criteria c=salaryExample.createCriteria();
            c.andSidEqualTo(salary.getSid());
            int i=salaryBiz.updateByExample(salary,salaryExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/salary/queryAll";

    }


    @RequestMapping("delete")
    public String deletCity(Model model,Salary salary){
        if(salary!=null&&salary.getSid()!=null){
            SalaryExample example=new SalaryExample();
            SalaryExample.Criteria c=example.createCriteria();
            c.andSidEqualTo(salary.getSid());
            int i=  salaryBiz.deleteByExample(example);
            if(i>0){
                model.addAttribute("msg","删除成功");
            }
        }
        model.addAttribute("msg","删除失败");
        return "redirect:/salary/queryAll";
    }




    @RequestMapping("/queryAll")
    public String queryAll(Model model, @RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue ="10") int pageSize){
        PageInfo<Salary> salaryPageInfo=salaryBiz.selectByExample(new SalaryExample(),pageIndex,pageSize);
        model.addAttribute("salaryPageInfo",salaryPageInfo);

//        return "forward:/static/salary/list.jsp";
        return "/salary/list";
    }


}
