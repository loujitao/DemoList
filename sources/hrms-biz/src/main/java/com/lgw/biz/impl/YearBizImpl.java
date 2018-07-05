package com.lgw.biz.impl;

import com.lgw.biz.YearBiz;
import com.lgw.dao.YearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearBizImpl<Year,YearExample,String> extends CommonBizImpl implements YearBiz {

    @Autowired
    private YearMapper yearMapper;

    @Autowired
    public void setYearMapper(){
        super.setBaseMapper(yearMapper);
    }
}
