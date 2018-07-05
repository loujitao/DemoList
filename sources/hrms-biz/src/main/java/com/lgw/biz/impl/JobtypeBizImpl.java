package com.lgw.biz.impl;

import com.lgw.biz.JobtypeBiz;
import com.lgw.dao.JobMapper;
import com.lgw.dao.JobtypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobtypeBizImpl<Jobtype,JobtypeExample,String> extends CommonBizImpl implements JobtypeBiz {

    @Autowired
    private JobtypeMapper jobtypeMapper;

    @Autowired
    public void setJobMapper( ) {
        super.setBaseMapper(jobtypeMapper);
    }
}
