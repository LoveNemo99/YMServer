package com.tinz.ssh.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.HourDataDetail")
public class HourDataRCDetail {
	private BigInteger id;
	private BigInteger hourMainId;
	private Integer monitorFactorId;
	private Float cou;
	private Float min;
	private Float avg;
	private Float max;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	@Column(name = "主小时数据ID")
	public BigInteger getHourMainId() {
		return hourMainId;
	}
	public void setHourMainId(BigInteger hourMainId) {
		this.hourMainId = hourMainId;
	}
	@Column(name = "污染物编码ID")
	public Integer getMonitorFactorId() {
		return monitorFactorId;
	}
	public void setMonitorFactorId(Integer monitorFactorId) {
		this.monitorFactorId = monitorFactorId;
	}
	@Column(name = "Min")
	public Float getMin() {
		return min;
	}
	public void setMin(Float min) {
		this.min = min;
	}
	@Column(name = "Avg")
	public Float getAvg() {
		return avg;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	@Column(name = "Max")
	public Float getMax() {
		return max;
	}
	public void setMax(Float max) {
		this.max = max;
	}
	
	@Column(name = "Cou")
	public Float getCou() {
		return cou;
	}
	public void setCou(Float cou) {
		this.cou = cou;
	}
	@Override
	public String toString() {
		return "CopyOfHourDataRCDetail [id=" + id + ", hourMainId="
				+ hourMainId + ", monitorFactorId=" + monitorFactorId
				+ ", min=" + min + ", avg=" + avg + ", max=" + max + "]";
	}
	
}
