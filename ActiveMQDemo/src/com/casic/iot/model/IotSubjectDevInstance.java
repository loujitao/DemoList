package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

public class IotSubjectDevInstance implements Serializable{

	private static final long serialVersionUID = 1423018085317332948L;

	private Long id;  //实例化id
	private Long iotId; //绑定的iotid
	private String bindSubject; //绑定的主题
	private String devId; //绑定的设备id
	private Integer isDelete; //是否删除
	private Long createUser; //创建者
	private Date createTime; //创建时间
	private Long subjectId; //设备类型id
	private IotSubject iotSubject;
	private IotDevice iotdevice;
	private IotDeviceType type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIotId() {
		return iotId;
	}
	public void setIotId(Long iotId) {
		this.iotId = iotId;
	}
	public String getBindSubject() {
		return bindSubject;
	}
	public void setBindSubject(String bindSubject) {
		this.bindSubject = bindSubject;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
	
	
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public IotSubject getIotSubject() {
		return iotSubject;
	}
	public void setIotSubject(IotSubject iotSubject) {
		this.iotSubject = iotSubject;
	}
	public IotDevice getIotdevice() {
		return iotdevice;
	}
	public void setIotdevice(IotDevice iotdevice) {
		this.iotdevice = iotdevice;
	}
	public IotDeviceType getType() {
		return type;
	}
	public void setType(IotDeviceType type) {
		this.type = type;
	}
	
}
