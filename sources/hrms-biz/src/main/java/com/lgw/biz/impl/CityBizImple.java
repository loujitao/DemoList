package com.lgw.biz.impl;

import com.lgw.biz.CityBiz;
import com.lgw.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityBizImple<City,CityExample,String> extends CommonBizImpl implements CityBiz {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    public void setMapper() {
        super.setBaseMapper(cityMapper);
    }

}
