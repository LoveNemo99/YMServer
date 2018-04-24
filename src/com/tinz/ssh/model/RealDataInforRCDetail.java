package com.tinz.ssh.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.RealDataDetail")
public class RealDataInforRCDetail {
	private BigInteger id;
	private BigInteger realMainId;
	private Integer monitorFactorId;
	private Float rtd;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = "污染物编码ID")
	public Integer getMonitorFactorId() {
		return monitorFactorId;
	}
	public void setMonitorFactorId(Integer monitorFactorId) {
		this.monitorFactorId = monitorFactorId;
	}
	
	@Column(name = "主实时数据ID")
	public BigInteger getRealMainId() {
		return realMainId;
	}
	public void setRealMainId(BigInteger realMainId) {
		this.realMainId = realMainId;
	}
	
	@Column(name = "RTD")
	public Float getRtd() {
		return rtd;
	}
	public void setRtd(Float rtd) {
		this.rtd = rtd;
	}
	@Override
	public String toString() {
		return "RealDataInforRCDetail [id=" + id + ", realMainId=" + realMainId
				+ ", monitorFactorId=" + monitorFactorId + ", rtd=" + rtd + "]";
	}

	
}
