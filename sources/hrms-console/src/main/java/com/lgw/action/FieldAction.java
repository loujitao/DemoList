package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.FieldBiz;
import com.lgw.biz.ResumetypeBiz;
import com.lgw.po.Field;
import com.lgw.po.FieldExample;
import com.lgw.po.Resumetype;
import com.lgw.po.ResumetypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/field")
public class FieldAction {
    @Autowired
    private FieldBiz fieldBiz;

    /**
     * 新增的中间方法
     * @param model
     * @return
     */
    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/field/add.jsp";
        return "/field/add";
    }

    /**
     * 新增
     * @param model
     * @param field
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model, Field field){
        int i=fieldBiz.insert(field);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/field/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/field/doadd";
        }
    }

    /**
     * 修改的中间方法
     * @param model
     * @param field
     * @return
     */
    @RequestMapping("/doupdate")
    public String doupdate(Model model, Field field){
        if(null!=field&&field.getFid()!=null) {
            field=(Field)fieldBiz.selectByPrimaryKey(field.getFid());
            model.addAttribute("field",field);
//            return "forward:/static/field/updata.jsp";
            return "/field/updata";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/field/queryAll";
        }
    }

    /**
     * 修改的方法
     * @param model
     * @param field
     * @return
     */
    @RequestMapping("/update")
    public String update(Model model, Field field){
        if(null!=field){
            FieldExample fieldExample=new FieldExample();
            FieldExample.Criteria c=fieldExample.createCriteria();
            c.andFidEqualTo(field.getFid());
            int i=fieldBiz.updateByExample(field,fieldExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/field/queryAll";
    }


    /**
     * 删除的方法
     * @param model
     * @param field
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Model model, Field field){
        if(field!=null&&field.getFid()!=null){
            FieldExample example=new FieldExample();
            FieldExample.Criteria c=example.createCriteria();
                c.andFidEqualTo(field.getFid());
              int i=fieldBiz.deleteByExample(example);
              if(i>0){
                  model.addAttribute("msg","删除成功");
              }
        }
        model.addAttribute("msg","删除失败");
        return "redirect:/field/queryAll";
    }

    /**
     * @param model
     * @param field   改改
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Field field, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        FieldExample fieldExample=new FieldExample();
        String fname=null;
        if(field!=null&&!"".equals(field.getFname())&&null!=field.getFname()){
            FieldExample.Criteria c=fieldExample.createCriteria();
            fname=field.getFname();
            c.andFnameLike("%"+field.getFname()+"%");
        }
        PageInfo pageInfo=fieldBiz.selectByExample(fieldExample,pageNum,pageSize);
        List<Field> fList=pageInfo.getList();

        if (null!=fList){
            model.addAttribute("fList",fList);
            model.addAttribute("pageInfo",pageInfo);
            if(fname!=null){model.addAttribute("fname",fname);}
//            return "forward:/static/field/list.jsp";
            return "/field/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }
}
