package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.CityBiz;
import com.lgw.po.City;
import com.lgw.po.CityExample;
import com.lgw.po.Jobtype;
import com.lgw.po.JobtypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityAction {

    @Autowired
    private CityBiz CityBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){
        return "city/cityadd";
    }

    @RequestMapping("/addCity")
    public String add(Model model, City city){
      if(city!=null){

        int i= CityBiz.insert(city);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/city/selectAllCity";
        }else {
            model.addAttribute("msg","添加失败");
            return "redirect:/city/selectAllCity";
        }
      }else{
          model.addAttribute("msg","添加内容不能为空");
          return "redirect:/city/selectAllCity";
      }
    }

    /**
     * list
     * add
     * edit
     * detail
     * 分页查询所有城市
     * @return
     */
    @RequestMapping("selectAllCity")
    public String selectAllCity(Model model, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue ="10") int pageSize){
       PageInfo<City> cityPageInfo=CityBiz.selectByExample(new CityExample(),pageNum,pageSize);
       model.addAttribute("cityPageInfo",cityPageInfo);
       return "city/list";
    }

    /**
     * 删除城市
     * @return
     */
    @RequestMapping("deleteCity")
    public String deletCity(Model model,City city){
        CityBiz.deleteByPrimaryKey(city.getCid());
       return "redirect:/city/selectAllCity";
    }

    @RequestMapping("doupdate")
    public String doupdate(Model model,City city){
        if(null!=city&&city.getCid()!=null) {

           City citya=(City)CityBiz.selectByPrimaryKey(city.getCid());

            model.addAttribute("city",citya);
            return "city/cityupdate";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/city/queryAll";
        }

    }


    /**
     * 修改城市
     * @param model
     * @param city
     * @return
     */
    @RequestMapping("updateCity")
    public String updateCity(Model model,City city) {
        if (city != null) {
            CityExample cityExample = new CityExample();
            CityExample.Criteria c = cityExample.createCriteria();
            c.andCidEqualTo(city.getCid());
            int i = CityBiz.updateByExample(city, cityExample);
            if (i > 0) {
                model.addAttribute("msg", "修改成功");
            } else {
                model.addAttribute("msg", "修改失败");
            }
        }else{
            model.addAttribute("msg", "未找到修改对象");
        }
        return "redirect:/city/queryAll";
    }

    /**
     * 模糊查询城市
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, City city, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        CityExample cityExample=new CityExample();
        String cname=null;
        if(city.getCname()!=null&&!city.getCname().equals("")){
            CityExample.Criteria c=cityExample.createCriteria();
            cname=city.getCname();
            c.andCnameLike("%"+city.getCname()+"%");
        }
        PageInfo   pageInfo=CityBiz.selectByExample(cityExample,pageNum,pageSize);
        List<City> cList=pageInfo.getList();

        if (null!=cList){
            model.addAttribute("cList",cList);
            model.addAttribute("cityPageInfo",pageInfo);
            if(cname!=null){model.addAttribute("cname",cname);}
            return "city/list";
        }else {
            return "city/list";
        }
    }



}
