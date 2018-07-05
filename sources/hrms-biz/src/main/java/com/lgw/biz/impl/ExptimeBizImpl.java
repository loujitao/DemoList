package com.lgw.biz.impl;

import com.lgw.biz.ExptimeBiz;
import com.lgw.dao.ExptimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExptimeBizImpl<Exptime,ExptimeExample,String>
        extends CommonBizImpl implements ExptimeBiz {
    @Autowired
    private ExptimeMapper exptimeMapper;

    @Autowired
    public void setMapper() {
        super.setBaseMapper(exptimeMapper);
    }

}
