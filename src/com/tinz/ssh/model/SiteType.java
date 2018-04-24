package com.tinz.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.工地类型")
public class SiteType {
	private int id;
	private String siteCode;
	private String siteName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "工地代码")
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	@Column(name = "工地名称")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@Override
	public String toString() {
		return "SiteType [id=" + id + ", siteCode=" + siteCode + ", siteName="
				+ siteName + "]";
	}

}
