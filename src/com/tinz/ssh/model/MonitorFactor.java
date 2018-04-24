package com.tinz.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.MonitorFactorCode")
public class MonitorFactor {
	private Integer id;
	private String factorCode;
	private String factorName;
	private Integer factorType;
	private Integer unitId;
	private Integer piUnitId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "污染物代码")
	public String getFactorCode() {
		return factorCode;
	}
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}
	
	@Column(name = "名称")
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	
	@Column(name = "污染物类别ID")
	public Integer getFactorType() {
		return factorType;
	}
	public void setFactorType(Integer factorType) {
		this.factorType = factorType;
	}
	
	@Column(name = "浓度计量单位ID")
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	@Column(name = "排放量计量单位ID")
	public Integer getPiUnitId() {
		return piUnitId;
	}
	public void setPiUnitId(Integer piUnitId) {
		this.piUnitId = piUnitId;
	}
	
}
