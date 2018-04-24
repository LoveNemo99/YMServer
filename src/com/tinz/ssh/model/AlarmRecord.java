package com.tinz.ssh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.报警记录")
public class AlarmRecord {
	private Integer id;
	private Integer stateCode;
	private Integer devCodeId;
	private Date datetime;
	private String content;
	private Boolean send;
	private String receiveMan;
	private String receiveNumber;
	private String soundAlarm;
	private String remark;
	
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
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	@Column(name = "设备信息ID")
	public Integer getDevCodeId() {
		return devCodeId;
	}
	public void setDevCodeId(Integer devCodeId) {
		this.devCodeId = devCodeId;
	}
	@Column(name = "时间")
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Column(name = "内容")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "短信是否发送")
	public Boolean getSend() {
		return send;
	}
	public void setSend(Boolean send) {
		this.send = send;
	}
	@Column(name = "短信接收人")
	public String getReceiveMan() {
		return receiveMan;
	}
	public void setReceiveMan(String receiveMan) {
		this.receiveMan = receiveMan;
	}
	@Column(name = "短信手机号")
	public String getReceiveNumber() {
		return receiveNumber;
	}
	public void setReceiveNumber(String receiveNumber) {
		this.receiveNumber = receiveNumber;
	}
	@Column(name = "是否需要声光报警")
	public String getSoundAlarm() {
		return soundAlarm;
	}
	public void setSoundAlarm(String soundAlarm) {
		this.soundAlarm = soundAlarm;
	}
	@Column(name = "备注")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AlarmRecord [id=" + id + ", stateCode=" + stateCode
				+ ", devCodeId=" + devCodeId + ", datetime=" + datetime
				+ ", content=" + content + ", send=" + send + ", receiveMan="
				+ receiveMan + ", receiveNumber=" + receiveNumber
				+ ", soundAlarm=" + soundAlarm + ", remark=" + remark + "]";
	}
	
}
