package com.tinz.ssh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.SiteInfor")
public class SiteInfor {
	private int id;
	private String statCode;
	private String statBJH;
	private String statName;
	private int siteTypeId;
	private String chargeMan;
	private String telephone;
	private Float longitude;
	private Float latitude;
	private String department;
	private String address;
	private int countryId;
	private String street;
	private Float square;
	private Date proStartTime;
	private String stage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "StatCode")
	public String getStatCode() {
		return statCode;
	}
	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}
	@Column(name = "StatBJH")
	public String getStatBJH() {
		return statBJH;
	}
	public void setStatBJH(String statBJH) {
		this.statBJH = statBJH;
	}
	@Column(name = "StatName")
	public String getStatName() {
		return statName;
	}
	public void setStatName(String statName) {
		this.statName = statName;
	}
	@Column(name = "SiteTypeID")
	public int getSiteTypeId() {
		return siteTypeId;
	}
	public void setSiteTypeId(int siteTypeId) {
		this.siteTypeId = siteTypeId;
	}
	@Column(name = "ChargeMan")
	public String getChargeMan() {
		return chargeMan;
	}
	public void setChargeMan(String chargeMan) {
		this.chargeMan = chargeMan;
	}
	@Column(name = "Telephone")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name = "Longitude")
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	@Column(name = "Latitude")
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	@Column(name = "Department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(name = "Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "CountryID")
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	@Column(name = "Street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name = "Square")
	public Float getSquare() {
		return square;
	}
	public void setSquare(Float square) {
		this.square = square;
	}
	@Column(name = "ProStartTime")
	public Date getProStartTime() {
		return proStartTime;
	}
	public void setProStartTime(Date proStartTime) {
		this.proStartTime = proStartTime;
	}
	@Column(name = "Stage")
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "SiteInfor [id=" + id + ", statCode=" + statCode + ", statBJH="
				+ statBJH + ", statName=" + statName + ", siteTypeId="
				+ siteTypeId + ", chargeMan=" + chargeMan + ", telephone="
				+ telephone + ", longitude=" + longitude + ", latitude="
				+ latitude + ", department=" + department + ", address="
				+ address + ", countryId=" + countryId + ", street=" + street
				+ ", square=" + square + ", proStartTime=" + proStartTime
				+ ", stage=" + stage + "]";
	}
	
}
