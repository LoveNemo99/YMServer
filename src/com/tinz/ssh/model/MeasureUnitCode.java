package com.tinz.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.MeasureuNnitCode")
public class MeasureUnitCode {
	private Integer id;
	private String code;
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "代码")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "计量单位名称")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
