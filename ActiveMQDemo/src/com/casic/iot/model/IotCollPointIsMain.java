package com.casic.iot.model;

import com.hotent.core.model.BaseModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IotCollPointIsMain extends BaseModel {
	private Long id;
	private String name;
	private String isDelete;
	private String des;
	private String status;
	private Long deviceType;
	private Long createUser;
	private Date createTime;
	private Long updateUser;
	private Date updateTime;
	private String keyName;
	private String isReadOnly;
	private String dataType;
	private String minValues;
	private String maxValues;
	private String unit;
	private Integer dataLength;
	private String dataStr;
	
	private List<Long> needUpsids=new ArrayList<>();
	private List<IotEnumeRate> enumeRates = new ArrayList<>();
	
	
	
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	public List<Long> getNeedUpsids() {
		return needUpsids;
	}
	public void setNeedUpsids(List<Long> needUpsids) {
		this.needUpsids = needUpsids;
	}
	public List<IotEnumeRate> getEnumeRates() {
		return enumeRates;
	}
	public void setEnumeRates(List<IotEnumeRate> enumeRates) {
		this.enumeRates = enumeRates;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Long getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Long deviceType) {
		this.deviceType = deviceType;
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
	
	public String getIsReadOnly() {
		return isReadOnly;
	}
	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public String getMinValues() {
		return minValues;
	}
	public void setMinValues(String minValues) {
		this.minValues = minValues;
	}
	public String getMaxValues() {
		return maxValues;
	}
	public void setMaxValues(String maxValues) {
		this.maxValues = maxValues;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getDataLength() {
		return dataLength;
	}
	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}
	
	
	
	
	
	
	
	
	
	
}
