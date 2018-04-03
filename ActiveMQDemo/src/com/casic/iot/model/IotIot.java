package com.casic.iot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IotIot implements Serializable {
	
	private List<Long> lks=new ArrayList<Long>();
	
    private Long iotId;

    private String name;

    private String isdelete;

    private Long identityid;

    private String deviceId;
    
    private String accesskey;

    private Long createuser;

    private Date createtime;

    private Long updateuser;

    private Date updatetime;

    private String installAdress;
    
    private String des;
    
    private String instanceId;
    
    private String commCode;
     
    private String iotType;
    
    public String getIotType() {
		return iotType;
	}

	public void setIotType(String iotType) {
		this.iotType = iotType;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Long getIotId() {
		return iotId;
	}

	public void setIotId(Long iotId) {
		this.iotId = iotId;
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

    public Long getIdentityid() {
        return identityid;
    }

    public void setIdentityid(Long identityid) {
        this.identityid = identityid;
    }


    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey == null ? null : accesskey.trim();
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

	public String getInstallAdress() {
		return installAdress;
	}

	public void setInstallAdress(String installAdress) {
		this.installAdress = installAdress;
	}

	

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getCommCode() {
		return commCode;
	}

	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}

	public List<Long> getLks() {
		return lks;
	}

	public void setLks(List<Long> lks) {
		this.lks = lks;
	}

    
	
    
}