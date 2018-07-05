package com.lgw.biz.impl;

import com.lgw.biz.StageBiz;
import com.lgw.dao.StageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StageBizImpl<Stage,StageExample,String> extends CommonBizImpl implements StageBiz {

    @Autowired
    private StageMapper stageMapper;

    @Autowired
    public void setStageMapper(){
        super.setBaseMapper(stageMapper);
    }
}
