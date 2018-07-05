package com.lgw.biz.impl;

import com.lgw.biz.MassagetypeBiz;
import com.lgw.dao.MassagetypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MassagetypeBizImpl<Massagetype,MassagetypeExample,String> extends CommonBizImpl implements MassagetypeBiz {

    @Autowired
    private MassagetypeMapper massagetypeMapper;

    @Autowired
    public  void setMapper(){
        super.setBaseMapper(massagetypeMapper);
    }

}
