package com.lgw.biz.impl;

import com.lgw.biz.TagBiz;
import com.lgw.dao.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagBizImpl<Tag,TagExample,String> extends CommonBizImpl implements TagBiz {

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    public void setMapper(){
        super.setBaseMapper(tagMapper);
    }
}
