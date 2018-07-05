package com.lgw.action;

import com.github.pagehelper.PageInfo;
import com.lgw.biz.StageBiz;
import com.lgw.po.Scale;
import com.lgw.po.Stage;
import com.lgw.po.StageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/stage")
public class StageAction {

    @Autowired
    private StageBiz stageBiz;

    @RequestMapping("/doadd")
    public String doadd(Model model){

//        return "forward:/static/stage/addStage.jsp";
        return "/stage/addStage";
    }

    @RequestMapping("/addStage")
    public String add(Model model,Stage stage){
        int i= stageBiz.insert(stage);
        if (i > 0) {
            model.addAttribute("msg", "添加成功");
            return "redirect:/stage/queryAll";
        } else {
            model.addAttribute("msg", "添加失败");
            return "forward:/stage/doadd";
        }
    }

    @RequestMapping("/doupdate")
    public String updateSalary(Model model,Stage stage){

        if (stage.getStid()!=null&&stage!=null){
            stage =(Stage) stageBiz.selectByPrimaryKey(stage.getStid());
            model.addAttribute("stage",stage);
//            return "forward:/static/stage/update.jsp";
            return "/stage/update";
        }
        model.addAttribute("msg","修改失败");
        return "redirect:/stage/queryAll";
    }

    @RequestMapping("/update")
    public String update(Model model,Stage stage){
        if(null!=stage){
            StageExample stageExample=new StageExample();
            StageExample.Criteria c=stageExample.createCriteria();
            c.andStidEqualTo(stage.getStid());
            int i=stageBiz.updateByExample(stage,stageExample);
            if (i>0){
                model.addAttribute("msg","修改成功");
            }else {
                model.addAttribute("msg","修改失败");
            }
        }else {
            model.addAttribute("msg","未找到修改目标");
        }
        return "redirect:/stage/queryAll";

    }

    @RequestMapping("delete")
    public String deletCity(Model model,Stage stage){
        if(stage!=null&&stage.getStid()!=null){
            StageExample example=new StageExample();
            StageExample.Criteria c=example.createCriteria();
            c.andStidEqualTo(stage.getStid());
            int i=  stageBiz.deleteByExample(example);
            if(i>0){
                model.addAttribute("msg","删除成功");
            }
        }
        model.addAttribute("msg","删除失败");
        return "redirect:/stage/queryAll";
    }

    @RequestMapping("/queryAll")
    public String queryAll(Model model, @RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue ="10") int pageSize){
        PageInfo<Scale> stagePageInfo=stageBiz.selectByExample(new StageExample(),pageIndex,pageSize);
        model.addAttribute("stagePageInfo",stagePageInfo);
//        return "forward:/static/stage/list.jsp";
        return "/stage/list";
    }
}
