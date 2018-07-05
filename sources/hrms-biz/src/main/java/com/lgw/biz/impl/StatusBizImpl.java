package com.lgw.biz.impl;

import com.lgw.biz.StatusBiz;
import com.lgw.dao.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusBizImpl<Status,StatusExample,String> extends CommonBizImpl implements StatusBiz {

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    public void setStatusMapper(){
        super.setBaseMapper(statusMapper);
    }
}
