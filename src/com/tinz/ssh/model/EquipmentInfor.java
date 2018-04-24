package com.tinz.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.EquipmentInfor")
public class EquipmentInfor {
	private Integer id;
	private Integer stateCodeId;
	private String factorTypeId;
	private String monitorPortName;
	private String devCode;
	private String mn;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "企业基本信息ID")
	public Integer getStateCodeId() {
		return stateCodeId;
	}
	public void setStateCodeId(Integer stateCodeId) {
		this.stateCodeId = stateCodeId;
	}
	@Column(name = "排放口名称")
	public String getMonitorPortName() {
		return monitorPortName;
	}
	public void setMonitorPortName(String monitorPortName) {
		this.monitorPortName = monitorPortName;
	}
	@Column(name = "排放口编码")
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	@Column(name = "污染物类别ID")
	public String getFactorTypeId() {
		return factorTypeId;
	}
	public void setFactorTypeId(String factorTypeId) {
		this.factorTypeId = factorTypeId;
	}
	@Column(name = "企业端数采MN")
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	
}
