package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

public class IotCollectionPoint  implements Serializable{
    private Long id;

    private String name;

    private String isdelete;

    private String des;

    private String type;

    private String functioncode;

    private String startaddress;

    private Integer datalength;

    private Integer frequency;

    private String crccheck;

    private String deviceid;

    private Long createuser;

    private Date createtime;

    private Long updateuser;

    private Date updatetime;
    
    private Long colPointTempId;

    private String keyName;
    
    private String stat;
    
  

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}



	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Long getColPointTempId() {
		return colPointTempId;
	}

	public void setColPointTempId(Long colPointTempId) {
		this.colPointTempId = colPointTempId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode == null ? null : functioncode.trim();
    }

    public String getStartaddress() {
        return startaddress;
    }

    public void setStartaddress(String startaddress) {
        this.startaddress = startaddress == null ? null : startaddress.trim();
    }

    public Integer getDatalength() {
        return datalength;
    }

    public void setDatalength(Integer datalength) {
        this.datalength = datalength;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getCrccheck() {
        return crccheck;
    }

    public void setCrccheck(String crccheck) {
        this.crccheck = crccheck == null ? null : crccheck.trim();
    }

   

    public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
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