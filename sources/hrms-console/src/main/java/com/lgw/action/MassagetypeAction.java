package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.MassagetypeBiz;
import com.lgw.po.Massagetype;
import com.lgw.po.MassagetypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/massagetype")
public class MassagetypeAction {

    @Autowired
    private MassagetypeBiz massagetypeBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){
        MassagetypeExample massagetypeExample=new MassagetypeExample();
        MassagetypeExample.Criteria c=massagetypeExample.createCriteria();
        c.andMidIsNotNull();
        List<Massagetype> jobList=massagetypeBiz.selectByExample(massagetypeExample);
        model.addAttribute("massagetypeList",jobList);
//        return "forward:/static/massagetype/add.jsp";
        return "/massagetype/add";
    }
    @RequestMapping("/add")
    public String add(Model model, Massagetype massagetype){
        int i=massagetypeBiz.insert(massagetype);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/massagetype/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/massagetype/doadd";
        }
    }

    @RequestMapping("/doupdate")
    public String doupdate(Model model, Massagetype massagetype){
        if(null!=massagetype&&massagetype.getMid()!=null) {
            massagetype=(Massagetype)   massagetypeBiz.selectByPrimaryKey(massagetype.getMid());
            List<Massagetype> massagetypeList= massagetypeBiz.selectByExample(new MassagetypeExample());
            model.addAttribute("massagetypeList",massagetypeList);
            model.addAttribute("massageType",massagetype);
//            return "forward:/static/massagetype/updata.jsp";
            return "/massagetype/updata";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/massagetype/queryAll";
        }
    }

    @RequestMapping("/update")
    public String update(Model model, Massagetype massagetype){
        if(null!=massagetype){
            MassagetypeExample massagetypeExample=new MassagetypeExample();
            MassagetypeExample.Criteria c=massagetypeExample.createCriteria();
            c.andMidEqualTo(massagetype.getMid());
            int i=massagetypeBiz.updateByExample(massagetype,massagetypeExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/massagetype/queryAll";
    }
    @RequestMapping("/delete")
    public String delete(Model model, Massagetype massagetype){
        if(massagetype!=null&&massagetype.getMid()!=null){
            MassagetypeExample exa=new MassagetypeExample();
            MassagetypeExample.Criteria cri=exa.createCriteria();
            cri.andBMMidEqualTo(massagetype.getMid());
            List<Massagetype> mlist= massagetypeBiz.selectByExample(exa);
            if(mlist==null || mlist.size()==0){
                MassagetypeExample example=new MassagetypeExample();
                MassagetypeExample.Criteria c=example.createCriteria();
                c.andMidEqualTo(massagetype.getMid());
                massagetypeBiz.deleteByExample(example);
                model.addAttribute("msg","删除成功");
            }
        }else {
            model.addAttribute("msg","删除失败或存在父类型");}
        return "redirect:/massagetype/queryAll";
    }

    /**
     * @param model
     * @param massagetype   改改
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Massagetype massagetype, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        MassagetypeExample massagetypeExample=new MassagetypeExample();
        String mname=null;
        if(massagetype!=null&&!"".equals(massagetype.getMname())&&null!=massagetype.getMname()){
            MassagetypeExample.Criteria c=massagetypeExample.createCriteria();
            mname=massagetype.getMname();
            c.andMnameLike("%"+massagetype.getMname()+"%");
        }
        PageInfo pageInfo=massagetypeBiz.selectByExample(massagetypeExample,pageNum,pageSize);
        List<Massagetype> massagetypeList=pageInfo.getList();

        if (null!=massagetypeList){
            model.addAttribute("massagetypeList",massagetypeList);
            model.addAttribute("pageInfo",pageInfo);
            if(mname!=null){model.addAttribute("mname",mname);}
//            return "forward:/static/massagetype/list.jsp";
            return "/massagetype/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }
}
