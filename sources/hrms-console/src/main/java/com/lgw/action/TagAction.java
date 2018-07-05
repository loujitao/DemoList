package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.TagBiz;
import com.lgw.po.Tag;
import com.lgw.po.TagExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagAction {

    @Autowired
    private TagBiz tagBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){
        TagExample tagExample=new TagExample();
        TagExample.Criteria c=tagExample.createCriteria();
        c.andTidIsNotNull();
        List<Tag> jobList=tagBiz.selectByExample(tagExample);
        model.addAttribute("tagList",jobList);
//        return "forward:/static/tag/add.jsp";
        return "/tag/add";
    }
    @RequestMapping("/add")
    public String add(Model model, Tag tag){
        int i=tagBiz.insert(tag);
        if (i>0){
            model.addAttribute("msg","添加成功");
            return "redirect:/tag/queryAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:/tag/doadd";
        }
    }

    @RequestMapping("/doupdate")
    public String doupdate(Model model, Tag tag){
        if(null!=tag&&tag.getTid()!=null) {
            tag=(Tag)   tagBiz.selectByPrimaryKey(tag.getTid());
            List<Tag> tagList= tagBiz.selectByExample(new TagExample());
            model.addAttribute("tagList",tagList);
            model.addAttribute("Tag",tag);
//            return "forward:/static/tag/updata.jsp";
            return "/tag/updata";
        } else {
            model.addAttribute("msg","修改失败");
            return "redirect:/tag/queryAll";
        }
    }

    @RequestMapping("/update")
    public String update(Model model, Tag tag){
        if(null!=tag){
            TagExample tagExample=new TagExample();
            TagExample.Criteria c=tagExample.createCriteria();
            c.andTidEqualTo(tag.getTid());
            int i=tagBiz.updateByExample(tag,tagExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/tag/queryAll";
    }
    @RequestMapping("/delete")
    public String delete(Model model, Tag tag){
        if(tag!=null&&tag.getTid()!=null){
            TagExample exa=new TagExample();
            TagExample.Criteria cr=exa.createCriteria();
            cr.andBTTidEqualTo(tag.getTid());
            List jlist=tagBiz.selectByExample(exa);
            if(jlist==null || jlist.size()==0){
                TagExample example=new TagExample();
                TagExample.Criteria c=example.createCriteria();
                c.andTidEqualTo(tag.getTid());
                tagBiz.deleteByExample(example);
                model.addAttribute("msg","删除成功");
            }
        }
        model.addAttribute("msg","删除失败或存在父类型");
        return "redirect:/tag/queryAll";
    }

    /**
     * @param model
     * @param tag   改改
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryAll")
    public String queryAll(Model model, Tag tag, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        TagExample tagExample=new TagExample();
        String jname=null;
        if(tag!=null&&!"".equals(tag.getTname())&&null!=tag.getTname()){
            TagExample.Criteria c=tagExample.createCriteria();
            jname=tag.getTname();
            c.andTnameLike("%"+tag.getTname()+"%");
        }
        PageInfo pageInfo=tagBiz.selectByExample(tagExample,pageNum,pageSize);
        List<Tag> tagList=pageInfo.getList();

        if (null!=tagList){
            model.addAttribute("tagList",tagList);
            model.addAttribute("pageInfo",pageInfo);
            if(jname!=null){model.addAttribute("jname",jname);}
//            return "forward:/static/tag/list.jsp";
            return "/tag/list";
        }else {
            return "forward:/static/background/error.jsp";
        }
    }

}
