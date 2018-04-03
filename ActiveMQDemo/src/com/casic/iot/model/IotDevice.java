package com.casic.iot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IotDevice implements Serializable{
    private String id; //主键 设备id

    private String copyid; //返回前台页面
    
    private String name; // 设备名称，暂时没用，

    private String isDelete; //删除标识 0 未删除  1已删除

    private String des; //设备描述

    private String type; 

    private String address; //设备安装地址

    private String agreement;

    private String port;

    private String serialNumber;

    private String baudRate;

    private String dataBits;

    private String checkBits;

    private String stopBits;

    private String ip;

    private String deviceId;
    
    private String isIot; //是否是iot设备 0 不是 1是

    private Long orgId; //企业id

    private Long deviceGroupId; //设备组id
    
    private Long iotId; //挂载的网关id

    private String status; //是否启用状态，目前未用

    private Long createUser; //创建者

    private Date createTime; //创建时间

    private Long updateUser; //更新者

    private Date updateTime; //更新时间
    
    private String devAdress;
    
    private String devison;
    
    private String devnum; //设备
    
    private String work; //前台显示使用
    
    private String unwork; //前台显示使用
    
    private String devGroupName; //设备组名称，前台传值显示使用
    
    private String lastActiveTime; //暂时未用，设备最后活跃时间
    
    private String Model; //所属设备类型
    
    private String province; //省
    
    private String city; //市
    
    private String country; //区
    
    
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

	public String getCopyid() {
		return copyid;
	}

	public void setCopyid(String copyid) {
		this.copyid = copyid;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getUnwork() {
    	if("0".equals(status)){
    		return "启用";
    	}else if("1".equals(status)){
    		return "禁用";
    	}else{
    		return "";
    	}
	}

	public void setUnwork(String unwork) {
		this.unwork = unwork;
	}

	

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	//传参
	
	
    private List<IotCollectionPoint> collections=new ArrayList<IotCollectionPoint>();
    	
	public String getDevGroupName() {
		return devGroupName;
	}

	public void setDevGroupName(String devGroupName) {
		this.devGroupName = devGroupName;
	}

	

	public String getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(String lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
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

	public String getDevAdress() {
		return devAdress;
	}

	public void setDevAdress(String devAdress) {
		this.devAdress = devAdress;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(String baudRate) {
		this.baudRate = baudRate;
	}

	public String getDataBits() {
		return dataBits;
	}

	public void setDataBits(String dataBits) {
		this.dataBits = dataBits;
	}

	public String getCheckBits() {
		return checkBits;
	}

	public void setCheckBits(String checkBits) {
		this.checkBits = checkBits;
	}

	public String getStopBits() {
		return stopBits;
	}

	public void setStopBits(String stopBits) {
		this.stopBits = stopBits;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getDeviceGroupId() {
		return deviceGroupId;
	}

	public void setDeviceGroupId(Long deviceGroupId) {
		this.deviceGroupId = deviceGroupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<IotCollectionPoint> getCollections() {
		return collections;
	}

	public void setCollections(List<IotCollectionPoint> collections) {
		this.collections = collections;
	}

	public String getIsIot() {
		return isIot;
	}

	public void setIsIot(String isIot) {
		this.isIot = isIot;
	}

	public Long getIotId() {
		return iotId;
	}

	public void setIotId(Long iotId) {
		this.iotId = iotId;
	}

    
    
}