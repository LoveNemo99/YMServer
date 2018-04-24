package com.tinz.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.用户")
public class Userr {
	private Integer id;
	private String username;
	private String cusername;
	private String password;
	private Integer districtId;
	private String remark;
	private Integer enterpriseId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "用户名")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "中文用户名")
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	@Column(name = "密码")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "行政区ID")
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	@Column(name = "备注")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "运维企业ID")
	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", cusername="
				+ cusername + ", password=" + password + ", districtId="
				+ districtId + ", remark=" + remark + ", enterpriseId="
				+ enterpriseId + "]";
	}
	
}
