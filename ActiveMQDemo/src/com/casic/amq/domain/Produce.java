package com.casic.amq.domain;

import java.io.Serializable;

/** 
* @author 作者 ：walker 
* @time 创建时间：2018年1月30日 上午9:43:35 
* @describe  amq  list推送此类
*/
public class Produce<T extends Serializable> implements Serializable {

	/** 
	* @author 作者 ：walker 
	* @time 创建时间：2018年1月31日上午11:15:16
	* @field 字段：serialVersionUID
	*/ 
	private static final long serialVersionUID = 1L;

	private String name; //用于区分是什么对象
	
	private String operate; //增删改什么操作。。
	
	private T t; //具体的对象  

	
	public Produce(String name, String operate, T t) {
		super();
		this.name = name;
		this.operate = operate;
		this.t = t;
	}

	public Produce() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}
	
	
}
