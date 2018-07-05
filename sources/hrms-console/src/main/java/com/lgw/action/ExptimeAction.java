package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.CityBiz;
import com.lgw.biz.ExptimeBiz;
import com.lgw.po.City;
import com.lgw.po.Exptime;
import com.lgw.po.ExptimeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/exptime")
public class ExptimeAction {

    @Autowired
    private ExptimeBiz exptimeBiz;

    /**
     * 添加的中间环节
     * @param model
     * @return
     */
    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/exptime/exptimeadd.jsp";
        return "/exptime/exptimeadd";
    }

    @RequestMapping("/addExptime")
    public String add(Model model, Exptime exptime){
      if(exptime!=null){

        int i= exptimeBiz.insert(exptime);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/exptime/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/static/background/error.jsp";
        }
      }else{
          model.addAttribute("msg","添加内容不能为空");
          return "redirect:/exptime/queryAll";
      }
    }






    /**
     * 删除
     * @return
     */
    @RequestMapping("deleteExptime")
    public String deletCity(Model model,Exptime exptime){
        int i=exptimeBiz.deleteByPrimaryKey(exptime.getYind());
        if(i>0){
             model.addAttribute("msg","删除成功");
            return "redirect:/exptime/queryAll";
        }else {
            model.addAttribute("msg","删除失败");
            return "redirect:/exptime/queryAll";
        }

    }


    /**
     * 修改的中间的环节
     * @param model
     * @param exptime
     * @return
     */
    @RequestMapping("doupdate")
    public String doupdate(Model model,Exptime exptime){
        if(null!=exptime&&exptime.getYind()!=null) {

            Exptime exptime01=(Exptime)exptimeBiz.selectByPrimaryKey(exptime.getYind());

            model.addAttribute("exptime",exptime01);
//            return "forward:/static/exptime/exptimeupdate.jsp";
            return "/exptime/exptimeupdate";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/city/queryAll";
        }

    }


    /**
     * 修改
     * @param model
     * @param
     * @return
     */
    @RequestMapping("updateExptime")
    public String updateCity(Model model,Exptime exptime){
        if(exptime!=null){
            ExptimeExample exptimeExample=new ExptimeExample();
            ExptimeExample.Criteria c=exptimeExample.createCriteria();
            c.andYindEqualTo(exptime.getYind());
            int i=exptimeBiz.updateByExample(exptime,exptimeExample);
        if(i>0){
            model.addAttribute("msg","修改成功");
        }else{
            model.addAttribute("msg","修改失败");
        }
    }else {
            model.addAttribute("msg","未知错误");
            return "forward:/static/background/error.jsp";
        }
        return "redirect:/exptime/queryAll";
    }

    /**
     * 模糊查询
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Exptime exptime, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        ExptimeExample exptimeExample=new ExptimeExample();
        String yname=null;
        if(exptime.getYname()!=null&&!exptime.getYname().equals("")){
            ExptimeExample.Criteria c=exptimeExample.createCriteria();
            yname=exptime.getYname();
            c.andYnameLike("%"+exptime.getYname()+"%");
        }
        PageInfo pageInfo=exptimeBiz.selectByExample(exptimeExample,pageNum,pageSize);
        List<Exptime> eList=pageInfo.getList();

        if (null!=eList){
            model.addAttribute("eList",eList);
            model.addAttribute("pageInfo",pageInfo);
            if(yname!=null){
                model.addAttribute("yname",yname);
            }
//            return "forward:/static/exptime/list.jsp";
            return "/exptime/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }





    /**
     * list
     * add
     * edit
     * detail
     * 分页查询所有城市
     * @return
     *//*
    @RequestMapping("selectAllCity")
    public String selectAllCity(Model model, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue ="10") int pageSize){
       PageInfo<City> cityPageInfo=CityBiz.selectByExample(new CityExample(),pageNum,pageSize);
       model.addAttribute("cityPageInfo",cityPageInfo);
       return "city/list";
    }*/

}
