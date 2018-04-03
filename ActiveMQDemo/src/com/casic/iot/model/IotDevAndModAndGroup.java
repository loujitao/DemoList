package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

public class IotDevAndModAndGroup implements Serializable{
	private String id;
	private String mname;
	private String devison;
	private String devnum;
	private String deviceId;
	private String des;
	private Long iotId;
	private String status;
	private Date createTime;
	private String gname;
	private String devAddress;
	private Long orgId;
	private String iotName;
	private String iotType;
	
	private String devAddr;

	private String model;
	private String province;
	private String city;
	private String country;


	private String iotIdentityName;
	
	private int iotColPointCount;

	private String iname;
	private String accessKey;
	private String commCode;
	private String installAdress;
	private String ides;
	
	
	
	
	public String getDevAddr() {
		return devAddr;
	}
	
	public void setDevAddr(String devAddr) {
		this.devAddr = devAddr;
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIotType() {
		return iotType;
	}
	
	public void setIotType(String iotType) {
		this.iotType = iotType;
	}
	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getCommCode() {
		return commCode;
	}

	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}

	public String getInstallAdress() {
		return installAdress;
	}

	public void setInstallAdress(String installAdress) {
		this.installAdress = installAdress;
	}

	public String getIdes() {
		return ides;
	}

	public void setIdes(String ides) {
		this.ides = ides;
	}

	public String getIotName() {
		return iotName;
	}
	
	public void setIotName(String iotName) {
		this.iotName = iotName;
	}
	@Override
	public String toString() {
		return "IotDevAndModAndGroup [id=" + id + ", mname=" + mname + ", devison=" + devison + ", devnum=" + devnum
				+ ", deviceId=" + deviceId + ", des=" + des + ", iotId=" + iotId + ", status=" + status
				+ ", createTime=" + createTime + ", gname=" + gname + ", devAddress=" + devAddress + ", orgId=" + orgId
				+ ", iotName=" + iotName + ", iotType=" + iotType + ", devAddr=" + devAddr + ", model=" + model
				+ ", province=" + province + ", city=" + city + ", country=" + country + ", iotIdentityName="
				+ iotIdentityName + ", iotColPointCount=" + iotColPointCount + ", iname=" + iname + ", accessKey="
				+ accessKey + ", commCode=" + commCode + ", installAdress=" + installAdress + ", ides=" + ides + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDevison() {
		return devison;
	}

	public void setDevison(String devison) {
		this.devison = devison;
	}

	public String getDevnum() {
		return devnum;
	}

	public void setDevnum(String devnum) {
		this.devnum = devnum;
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

	public Long getIotId() {
		return iotId;
	}

	public void setIotId(Long iotId) {
		this.iotId = iotId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getDevAddress() {
		return devAddress;
	}

	public void setDevAddress(String devAddress) {
		this.devAddress = devAddress;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getIotIdentityName() {
		return iotIdentityName;
	}

	public void setIotIdentityName(String iotIdentityName) {
		this.iotIdentityName = iotIdentityName;
	}

	public int getIotColPointCount() {
		return iotColPointCount;
	}

	public void setIotColPointCount(int iotColPointCount) {
		this.iotColPointCount = iotColPointCount;
	}
	
	

	
}
