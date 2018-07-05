package com.lgw.biz.impl;

import com.lgw.biz.SalaryBiz;
import com.lgw.dao.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryBizImpl<Salary,SalaryExample,String> extends CommonBizImpl implements SalaryBiz {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    public void setSalaryMapper( ) {
        super.setBaseMapper(salaryMapper);
    }
}
