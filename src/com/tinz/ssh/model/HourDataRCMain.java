package com.tinz.ssh.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.HourDataMain")
public class HourDataRCMain {
	private BigInteger id;
	private Integer statCodeId;
	private Integer devCodeId;
	private Date monitorTime;
	private Integer pollutantTypeId;
	private Float intervalAmount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	@Column(name = "企业基本信息ID")
	public Integer getStatCodeId() {
		return statCodeId;
	}
	public void setStatCodeId(Integer statCodeId) {
		this.statCodeId = statCodeId;
	}
	
	@Column(name = "设备信息ID")
	public Integer getDevCodeId() {
		return devCodeId;
	}
	public void setDevCodeId(Integer devCodeId) {
		this.devCodeId = devCodeId;
	}
	
	@Column(name = "监测时间")
	public Date getMonitorTime() {
		return monitorTime;
	}
	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}
	
	@Column(name = "污染物类别ID")
	public Integer getPollutantTypeId() {
		return pollutantTypeId;
	}
	public void setPollutantTypeId(Integer pollutantTypeId) {
		this.pollutantTypeId = pollutantTypeId;
	}
	
	@Column(name = "时段量")
	public Float getIntervalAmount() {
		return intervalAmount;
	}
	public void setIntervalAmount(Float intervalAmount) {
		this.intervalAmount = intervalAmount;
	}
	@Override
	public String toString() {
		return "HourDataRCMain [id=" + id + ", statCodeId=" + statCodeId
				+ ", devCodeId=" + devCodeId + ", monitorTime=" + monitorTime
				+ "]";
	}
	
}
