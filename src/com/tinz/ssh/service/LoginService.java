package com.tinz.ssh.service;

import java.util.Date;
import java.util.List;

import com.tinz.ssh.model.AlarmRecordData;
import com.tinz.ssh.model.Enterprise;
import com.tinz.ssh.model.EnterpriseInfo;
import com.tinz.ssh.model.EquipmentInfor;
import com.tinz.ssh.model.HourData;
import com.tinz.ssh.model.MonitorFactor;
import com.tinz.ssh.model.RealtimeData;
import com.tinz.ssh.model.SiteMonitorInfo;


public interface LoginService {
	public String validate(String username,String password);
	public List<EquipmentInfor> getEquipmentInfors();
	public List<MonitorFactor> getMonitorFactors();
	//public List<RealtimeData> getRealtimeData(int devCodeId);
	//public List<HourData> getHourData(int devCodeId);
	public List<AlarmRecordData> getAlarmRecordData(Date date);
	public List<HourData> getHourData(int devCodeId, int monitorFactorId);
	public List<SiteMonitorInfo> getSiteMonitorInfo();
	public List<Enterprise> getEnterpriseInfo();
	public List<RealtimeData> getRealtimeData(Integer devCodeId, Integer portId);
}
