package com.tinz.ssh.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tinz.ssh.dao.UserDao;
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

public class UserDaoHibernateImpl extends HibernateDaoSupport implements
		UserDao {

	@Override
	public boolean validate(String username, String password) {
		String queryString = "from Userr where username = ?";// where username = ?
		List<Userr> dd=getHibernateTemplate().find(queryString,username);
		if(dd!=null&&dd.size()!=0){
			if(dd.get(0).getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Userr getUserInfo(String username) {
		String queryString = "from Userr where username = ?";// where username = ?
		List<Userr> l=getHibernateTemplate().find(queryString,username);
		if(l.size()==0){
			return null;
		}
		return l.get(0);
	}
	
	@Override
	public List<MonitorFactor> getMonitorFactors(){
		String queryString = "from MonitorFactor";
		List<MonitorFactor> data = new ArrayList<MonitorFactor>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<MeasureUnitCode> getMeasureUnitCode(){
		String queryString = "from MeasureUnitCode";
		List<MeasureUnitCode> data = new ArrayList<MeasureUnitCode>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<EquipmentInfor> getEquipmentInfors(){
		EquipmentInfor.class.getName();
		String queryString = "from EquipmentInfor";
		List<EquipmentInfor> data = new ArrayList<EquipmentInfor>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<SiteType> getSiteType(){
		String queryString = "from SiteType";
		List<SiteType> data = new ArrayList<SiteType>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<EnterpriseInfo> getEnterpriseInfo(){
		String queryString = "from EnterpriseInfo";
		List<EnterpriseInfo> data = new ArrayList<EnterpriseInfo>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<AlarmLimitType> getAlarmLimitType(){
		String queryString = "from AlarmLimitType";
		List<AlarmLimitType> data = new ArrayList<AlarmLimitType>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<AlarmLimitTimeType> getAlarmLimitTimeType(){
		String queryString = "from AlarmLimitTimeType";
		List<AlarmLimitTimeType> data = new ArrayList<AlarmLimitTimeType>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<AlarmRecord> getAlarmRecord(Date start,Date end){
		String queryString = "from AlarmRecord where datetime >= ? and datetime <= ?";
		List<AlarmRecord> data = new ArrayList<AlarmRecord>();
		data = getHibernateTemplate().find(queryString,start,end);
		return data;
	}
	
	@Override
	public List<SiteInfor> getSiteInfor(){
		String queryString = "from SiteInfor";
		List<SiteInfor> data = new ArrayList<SiteInfor>();
		data = getHibernateTemplate().find(queryString);
		return data;
	}
	
	@Override
	public List<RealDataInforRCMain> getRealtimeDataMain(int devCodeId){
		String queryString = "from RealDataInforRCMain where devCodeId = ? and monitorTime=(select max(monitorTime) from RealDataInforRCMain where devCodeId = ?)";
		List<RealDataInforRCMain> data = new ArrayList<RealDataInforRCMain>();
		data = getHibernateTemplate().find(queryString,devCodeId,devCodeId);
		return data;
	}
	@Override
	public List<RealDataInforRCDetail> getRealtimeDataDetail(BigInteger id){
		String queryString = "from RealDataInforRCDetail where realMainId = ?";
		List<RealDataInforRCDetail> data = new ArrayList<RealDataInforRCDetail>();
		data = getHibernateTemplate().find(queryString,id);
		return data;
	}
	
//	@Override
//	public List<HourDataRCMain> getHourDataRCMain(int devCodeId,Date start,Date end){
//		Date now = new Date();
//		String queryString = "from HourDataRCMain where (statCodeId = ? and monitorTime >= ? and monitorTime <= ?) order by monitorTime desc";
//		List<HourDataRCMain> data = new ArrayList<HourDataRCMain>();
//		data = getHibernateTemplate().find(queryString,devCodeId,start,end);
//		return data;
//	}
	
	@Override
	public List<HourDataRCMain> getHourDataRCMain(int devCodeId,Date start,Date end){
		Date now = new Date();
		String queryString = "from HourDataRCMain where (devCodeId = ? and monitorTime >= ? and monitorTime <= ?) order by monitorTime desc";
		List<HourDataRCMain> data = new ArrayList<HourDataRCMain>();
		data = getHibernateTemplate().find(queryString,devCodeId,start,end);
		return data;
	}
	
	@Override
	public List<HourDataRCDetail> getHourDataRCDetail(String ids,int monitorFactorId){
		List<HourDataRCDetail> data = new ArrayList<HourDataRCDetail>();
		String queryString = "from HourDataRCDetail where monitorFactorId = ? and hourMainId in "+ids;
		data = getHibernateTemplate().find(queryString,monitorFactorId);
		return data;
	}

}
