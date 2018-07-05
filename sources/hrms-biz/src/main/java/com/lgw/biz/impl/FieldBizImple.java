package com.lgw.biz.impl;

import com.lgw.biz.FieldBiz;
import com.lgw.dao.FieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldBizImple<Field,FieldExample,String> extends CommonBizImpl implements FieldBiz {

    @Autowired
    private FieldMapper fieldMapper;

    @Autowired
    public void setMapper() {
        super.setBaseMapper(fieldMapper);
    }

}
