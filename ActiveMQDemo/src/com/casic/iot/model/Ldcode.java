package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

public class Ldcode extends LdcodeKey implements Serializable{
    private String codeName;

    private String status;

    private Long createuser;

    private Date createtime;

    private Long updateuser;

    private Date updatetime;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codename) {
        this.codeName = codename == null ? null : codename.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Long createuser) {
        this.createuser = createuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(Long updateuser) {
        this.updateuser = updateuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}