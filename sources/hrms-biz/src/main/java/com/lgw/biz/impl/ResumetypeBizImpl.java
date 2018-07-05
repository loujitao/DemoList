package com.lgw.biz.impl;

import com.lgw.biz.ResumetypeBiz;
import com.lgw.dao.ResumetypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumetypeBizImpl<Resumetype,ResumetypeExample,String> extends  CommonBizImpl implements ResumetypeBiz {

    @Autowired
    private ResumetypeMapper resumetypeMapper;

    @Autowired
    public void setMapper(){
        super.setBaseMapper(resumetypeMapper);
    }

}
