package com.tinz.ssh.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.tinz.ssh.model.AlarmLimitTimeType;
import com.tinz.ssh.model.AlarmLimitType;
import com.tinz.ssh.model.AlarmRecord;
import com.tinz.ssh.model.EnterpriseInfo;
import com.tinz.ssh.model.EquipmentInfor;
import com.tinz.ssh.model.HourDataRCDetail;
import com.tinz.ssh.model.HourDataRCMain;
import com.tinz.ssh.model.MeasureUnitCode;
import com.tinz.ssh.model.MonitorFactor;
import com.tinz.ssh.model.RealDataInforRCDetail;
import com.tinz.ssh.model.RealDataInforRCMain;
import com.tinz.ssh.model.SiteInfor;
import com.tinz.ssh.model.SiteType;
import com.tinz.ssh.model.Userr;


public interface UserDao {
	public boolean validate(String username, String password);
	public Userr getUserInfo(String username);
	public List<MonitorFactor> getMonitorFactors();
	public List<EquipmentInfor> getEquipmentInfors();
	public List<RealDataInforRCMain> getRealtimeDataMain(int devCodeId);
	public List<RealDataInforRCDetail> getRealtimeDataDetail(BigInteger id);
	public List<HourDataRCMain> getHourDataRCMain(int devCodeId,Date start,Date end);
	public List<SiteType> getSiteType();
	public List<SiteInfor> getSiteInfor();
	public List<AlarmLimitType> getAlarmLimitType();
	public List<AlarmLimitTimeType> getAlarmLimitTimeType();
	public List<AlarmRecord> getAlarmRecord(Date start, Date end);
	public List<HourDataRCDetail> getHourDataRCDetail(String ids,int monitorFactorId);
	public List<EnterpriseInfo> getEnterpriseInfo();
	public List<MeasureUnitCode> getMeasureUnitCode();
}
