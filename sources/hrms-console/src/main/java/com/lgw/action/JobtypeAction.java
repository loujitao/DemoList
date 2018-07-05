package com.lgw.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgw.biz.CityBiz;
import com.lgw.biz.JobtypeBiz;
import com.lgw.po.City;
import com.lgw.po.Jobtype;
import com.lgw.po.JobtypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jobtype")
public class JobtypeAction {

    @Autowired
    private JobtypeBiz jobtypeBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){
        JobtypeExample jobtypeExample=new JobtypeExample();
        JobtypeExample.Criteria c=jobtypeExample.createCriteria();
        c.andJtidIsNotNull();
            List<Jobtype> jobList=jobtypeBiz.selectByExample(jobtypeExample);
            model.addAttribute("jobtypeList",jobList);
//            return "forward:/static/jobtype/add.jsp";
            return "/jobtype/add";
    }
    @RequestMapping("/add")
    public String add(Model model, Jobtype jobtype){
        int i=jobtypeBiz.insert(jobtype);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/jobtype/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/jobtype/doadd";
        }
    }

    @RequestMapping("/doupdate")
    public String doupdate(Model model, Jobtype jobtype){
        if(null!=jobtype&&jobtype.getJtid()!=null) {
            jobtype=(Jobtype)   jobtypeBiz.selectByPrimaryKey(jobtype.getJtid());
            List<Jobtype> jobtypeList= jobtypeBiz.selectByExample(new JobtypeExample());
            model.addAttribute("jobtypeList",jobtypeList);
            model.addAttribute("jobType",jobtype);
            return "/jobtype/updata";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/jobtype/queryAll";
        }
    }

    @RequestMapping("/update")
    public String update(Model model, Jobtype jobtype){
         if(null!=jobtype){
             JobtypeExample jobtypeExample=new JobtypeExample();
             JobtypeExample.Criteria c=jobtypeExample.createCriteria();
             c.andJtidEqualTo(jobtype.getJtid());
             int i=jobtypeBiz.updateByExample(jobtype,jobtypeExample);
             if (i>0){
                 model.addAttribute("msg","修改成功");
             }else {
                 model.addAttribute("msg","修改失败");
             }
         }else {
             model.addAttribute("msg","未找到修改目标");
         }
        return "redirect:/jobtype/queryAll";
    }
    @RequestMapping("/delete")
    public String delete(Model model, Jobtype jobtype){
        if(jobtype!=null&&jobtype.getJtid()!=null){

            JobtypeExample exa=new JobtypeExample();
            JobtypeExample.Criteria cr=exa.createCriteria();
            cr.andBJJtidEqualTo(jobtype.getJtid());
            List jlist=jobtypeBiz.selectByExample(exa);
            if(jlist==null || jlist.size()==0){
                JobtypeExample example=new JobtypeExample();
                JobtypeExample.Criteria c=example.createCriteria();
                c.andJtidEqualTo(jobtype.getJtid());
                jobtypeBiz.deleteByExample(example);
                model.addAttribute("msg","删除成功");
            }
        }
            model.addAttribute("msg","删除失败或存在父类型");
        return "redirect:/jobtype/queryAll";
    }

    /**
     * @param model
     * @param jobtype   改改
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Jobtype jobtype,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,String parentOrChild){
        JobtypeExample jobtypeExample=new JobtypeExample();
        String jname=null;
        if(jobtype!=null&&!"".equals(jobtype.getJtname())&&null!=jobtype.getJtname()){
            JobtypeExample.Criteria c=jobtypeExample.createCriteria();
            jname=jobtype.getJtname();
            c.andJtnameLike("%"+jobtype.getJtname()+"%");
        }
        if(parentOrChild!=null&&!"2".equals(parentOrChild)){
            JobtypeExample.Criteria c=jobtypeExample.createCriteria();
            //只查询根标签
            if("0".equals(parentOrChild)){
                c.andBJJtidIsNull();
            }
            //只查询子标签
            if("1".equals(parentOrChild)){
                c.andBJJtidIsNotNull();
            }
        }

            PageInfo   pageInfo=jobtypeBiz.selectByExample(jobtypeExample,pageNum,pageSize);
        List<Jobtype> jobtypeList=pageInfo.getList();

        if (null!=jobtypeList){
            model.addAttribute("jobtypeList",jobtypeList);
            model.addAttribute("pageInfo",pageInfo);

            if(jname!=null){model.addAttribute("jname",jname);}
            model.addAttribute("parentOrChild",parentOrChild);
            return "/jobtype/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }

}
