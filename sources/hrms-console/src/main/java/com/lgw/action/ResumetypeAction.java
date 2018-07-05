package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.ResumetypeBiz;
import com.lgw.po.Resumetype;
import com.lgw.po.ResumetypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/resumetype")
public class ResumetypeAction {
    @Autowired
    private ResumetypeBiz resumetypeBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/resumetype/add.jsp";
        return "/resumetype/add";
    }
    @RequestMapping("/add")
    public String add(Model model, Resumetype resumetype){
        int i=resumetypeBiz.insert(resumetype);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/resumetype/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/resumetype/doadd";
        }
    }

    @RequestMapping("/doupdate")
    public String doupdate(Model model, Resumetype resumetype){
        if(null!=resumetype&&resumetype.getRtid()!=null) {
            resumetype=(Resumetype)   resumetypeBiz.selectByPrimaryKey(resumetype.getRtid());
            model.addAttribute("resumetype",resumetype);
//            return "forward:/static/resumetype/updata.jsp";
            return "/resumetype/updata";

        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/resumetype/queryAll";
        }
    }

    @RequestMapping("/update")
    public String update(Model model, Resumetype resumetype){
        if(null!=resumetype){
            ResumetypeExample resumetypeExample=new ResumetypeExample();
            ResumetypeExample.Criteria c=resumetypeExample.createCriteria();
            c.andRtidEqualTo(resumetype.getRtid());
            int i=resumetypeBiz.updateByExample(resumetype,resumetypeExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/resumetype/queryAll";
    }
    @RequestMapping("/delete")
    public String delete(Model model, Resumetype resumetype){
        if(resumetype!=null&&resumetype.getRtid()!=null){
                ResumetypeExample example=new ResumetypeExample();
                ResumetypeExample.Criteria c=example.createCriteria();
                c.andRtidEqualTo(resumetype.getRtid());
              int i=  resumetypeBiz.deleteByExample(example);
              if(i>0){
                  model.addAttribute("msg","删除成功");
              }
        }
        model.addAttribute("msg","删除失败");
        return "redirect:/resumetype/queryAll";
    }

    /**
     * @param model
     * @param resumetype   改改
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Resumetype resumetype, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        ResumetypeExample resumetypeExample=new ResumetypeExample();
        String jname=null;
        if(resumetype!=null&&!"".equals(resumetype.getRtname())&&null!=resumetype.getRtname()){
            ResumetypeExample.Criteria c=resumetypeExample.createCriteria();
            jname=resumetype.getRtname();
            c.andRtnameLike("%"+resumetype.getRtname()+"%");
        }
        PageInfo pageInfo=resumetypeBiz.selectByExample(resumetypeExample,pageNum,pageSize);
        List<Resumetype> resumetypeList=pageInfo.getList();

        if (null!=resumetypeList){
            model.addAttribute("resumetypeList",resumetypeList);
            model.addAttribute("pageInfo",pageInfo);
            if(jname!=null){model.addAttribute("rtname",jname);}
//            return "forward:/static/resumetype/list.jsp";
            return "/resumetype/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }
}
