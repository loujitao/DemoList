package com.casic.iot.model;

import java.io.Serializable;
import java.util.Date;

public class IotSubject implements Serializable{

	private static final long serialVersionUID = 4869271853631350153L;

	private Long id; //主键id
	
	private Integer isDelete; //是否删除，0 未删除，1删除
	
	private String subName; //主题名称
	
	private String subject; //模板  -- 主题
	
	private String auth; //权限
	
	private String newsDescribe; //消息描述
	
	private String remark; //备注
		
	private Long devTypeId; //设备型号id
	
	private Long createUser; //创建者
	
	private Date createTime; //创建时间
	
	private Long updateUser; //更新者
	
	private Date updateTime; //更新时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getNewsDescribe() {
		return newsDescribe;
	}

	public void setNewsDescribe(String newsDescribe) {
		this.newsDescribe = newsDescribe;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getDevTypeId() {
		return devTypeId;
	}

	public void setDevTypeId(Long devTypeId) {
		this.devTypeId = devTypeId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
}
