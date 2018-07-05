package com.lgw.biz.impl;

import com.lgw.biz.XueliBiz;
import com.lgw.dao.XueliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XueliBizImpl<Xueli,XueliExample,String> extends CommonBizImpl implements XueliBiz {

    @Autowired
    private XueliMapper xueliMapper;

    @Autowired
    public void setXueliMapper(){
        super.setBaseMapper(xueliMapper);
    }
}
