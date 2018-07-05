package com.lgw.biz.impl;

import com.lgw.biz.ScaleBiz;

import com.lgw.dao.ScaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScaleBizImpl<Scale,ScaleExample,String> extends CommonBizImpl  implements ScaleBiz {

    @Autowired
    private ScaleMapper scaleMapper;

    @Autowired
    public void setScaleMapper(){
        super.setBaseMapper(scaleMapper);
    }
}
