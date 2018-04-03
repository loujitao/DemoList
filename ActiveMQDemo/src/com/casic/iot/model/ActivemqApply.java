package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @author 作者 ：walker 
* @time 创建时间：2018年2月5日 下午1:24:34 
* @describe 
*/
public class ActivemqApply implements Serializable{

	/** 
	* @author 作者 ：walker 
	* @time 创建时间：2018年2月5日下午1:25:20
	* @field 字段：serialVersionUID
	*/ 
	private static final long serialVersionUID = 7966093448189931379L;

	private Long id;
	
	private String systemName;
	
	private String clientId;
	
	private Integer systemId;
	
	private String systemIP;
	
	private Integer isDelete;
	
	private String state;
	
	private String topic;
	
	private Long createUser;
	
	private Date createTime;
	
	private Long updateUser;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getSystemIP() {
		return systemIP;
	}

	public void setSystemIP(String systemIP) {
		this.systemIP = systemIP;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getState() {
		if("0".equals(state)){
			state="启用";
		}
		if("1".equals(state)){
			state="禁用";
		}
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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
	
	
	
	
}
