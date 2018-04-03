package com.casic.iot.model;

import java.io.Serializable;

public class IotData implements Serializable {
	private static final long serialVersionUID = 2754114883696539802L;
	private String iot;
	private String equipment;
	private String name;
	private String type;
	private String k;
	private String v;
	private String t;
	private String host;
	private String rack;
	private String other;
	public String getIot() {
		return iot;
	}
	public void setIot(String iot) {
		this.iot = iot;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	 
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	 
	
	
}
