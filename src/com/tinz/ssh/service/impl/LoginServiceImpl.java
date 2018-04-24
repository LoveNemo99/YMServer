package com.tinz.ssh.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.tinz.ssh.dao.UserDao;
import com.tinz.ssh.model.AlarmLimitTimeType;
import com.tinz.ssh.model.AlarmLimitType;
import com.tinz.ssh.model.AlarmRecord;
import com.tinz.ssh.model.AlarmRecordData;
import com.tinz.ssh.model.Enterprise;
import com.tinz.ssh.model.EnterpriseInfo;
import com.tinz.ssh.model.EquipmentInfor;
import com.tinz.ssh.model.HourData;
import com.tinz.ssh.model.HourDataRCDetail;
import com.tinz.ssh.model.HourDataRCMain;
import com.tinz.ssh.model.MeasureUnitCode;
import com.tinz.ssh.model.MonitorFactor;
import com.tinz.ssh.model.RealDataInforRCDetail;
import com.tinz.ssh.model.RealDataInforRCMain;
import com.tinz.ssh.model.RealtimeData;
import com.tinz.ssh.model.SiteInfor;
import com.tinz.ssh.model.SiteMonitorInfo;
import com.tinz.ssh.model.SiteType;
import com.tinz.ssh.model.Userr;
import com.tinz.ssh.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private UserDao userDao;

	@Override
	public String validate(String username, String password) {
		if(userDao == null){
			return "0";
		}
		if(username == null || password == null){
			return "0";
		}
		if(userDao.validate(username, password)){
			Gson gson = new  Gson();
			Userr u = userDao.getUserInfo(username);
			if(u == null)
				return "0";
			return "1"+gson.toJson(u);
		}
		return "0";
	}
	
	@Override
	public List<EquipmentInfor> getEquipmentInfors(){
		List<EquipmentInfor> data = new ArrayList<EquipmentInfor>();
		data = userDao.getEquipmentInfors();
		return data;
	}
	public List<EquipmentInfor> getPort(Integer id,List<EquipmentInfor> portList){
		List<EquipmentInfor> data = new ArrayList<EquipmentInfor>();
		if(portList==null){
			return null;
		}else{
			for(int i=0;i<portList.size();i++){
				if(portList.get(i).getStateCodeId() == id){
					data.add(portList.get(i));
				}
			}
		}
		if(data.size()==0)
			return null;
		return data;
	}
	@Override
	public List<Enterprise> getEnterpriseInfo(){
		List<Enterprise> data = new ArrayList<Enterprise>();
		List<EnterpriseInfo> data2 = new ArrayList<EnterpriseInfo>();
		data2 = userDao.getEnterpriseInfo();
		List<EquipmentInfor> portList = userDao.getEquipmentInfors();
		for(EnterpriseInfo info:data2){
			if(info.getDisplay().equals("是")){
				List<EquipmentInfor> ports = getPort(info.getId(),portList);
				if(ports !=null){
					String name = info.getName();
					
					if(ports.size()==1){
						Enterprise en = new Enterprise();
						BeanUtils.copyProperties(info,en);
						en.setNamePort(info.getId()+","+ports.get(0).getId());
						data.add(en);
					}
					if(ports.size()>1){
						for(int j=0;j<ports.size();j++){
							Enterprise en = new Enterprise();
							BeanUtils.copyProperties(info,en);
							en.setName(name+"  "+ports.get(j).getMonitorPortName());
							en.setNamePort(info.getId()+","+ports.get(j).getId());
							data.add(en);
						}
						
					}
				}
				
			}
		}
		return data;
	}
	
	@Override
	public List<SiteMonitorInfo> getSiteMonitorInfo(){
		List<SiteMonitorInfo> data = new ArrayList<SiteMonitorInfo>();
		List<EquipmentInfor> l1 = userDao.getEquipmentInfors();
		List<SiteInfor> l2 = userDao.getSiteInfor();
		for(int i=0;i<l2.size();i++){
			for(int j=0;j<l1.size();j++){
				if(l1.get(j).getStateCodeId()==l2.get(i).getId()){
					SiteMonitorInfo s = new SiteMonitorInfo();
					s.setEquipmentId(l1.get(j).getId());
					s.setMonitorPortName(l1.get(j).getMonitorPortName());
					s.setSiteName(l2.get(i).getStatName());
					s.setSpinnerName(s.getSiteName()+" "+s.getMonitorPortName());
					data.add(s);
				}
			}
		}
		return data;
	}
	
	@Override
	public List<MonitorFactor> getMonitorFactors(){
		List<MonitorFactor> data = new ArrayList<MonitorFactor>();
		data = userDao.getMonitorFactors();
		return data;
	}
	@Override
	public List<RealtimeData> getRealtimeData(Integer devCodeId,Integer portId){
		List<RealtimeData> data = new ArrayList<RealtimeData>();
		List<MonitorFactor> factors = userDao.getMonitorFactors();
		List<MeasureUnitCode> units = userDao.getMeasureUnitCode();
		Map unitMap = new HashMap();
		for(int i=0;i<units.size();i++){
			MeasureUnitCode u = units.get(i);
			unitMap.put(u.getId(), u.getCode());
		}
		Map map = new HashMap();
		for(int i=0;i<factors.size();i++){
			MonitorFactor f=factors.get(i);
			map.put("unit"+f.getId(),unitMap.get(f.getUnitId()));
			map.put("name"+f.getId(), f.getFactorName());
		}
		List<RealDataInforRCMain> l = userDao.getRealtimeDataMain(portId);
		RealDataInforRCMain main = new RealDataInforRCMain();
		for(int i=0;i<l.size();i++){
			if(l.get(i).getDevCodeId() == portId){
				main = l.get(i);
			}	
		}
		if(l!=null && l.size()==1){
			//List<RealDataInforRCDetail> ld = userDao.getRealtimeDataDetail(l.get(0).getId());
			List<RealDataInforRCDetail> ld = userDao.getRealtimeDataDetail(main.getId());
			//System.out.println(ld);
			for(int i=0;i<ld.size();i++){
				RealtimeData rd = new RealtimeData();
				rd.setDevCodeId(main.getDevCodeId());
				rd.setId(main.getId());
				rd.setMonitorFactorId(ld.get(i).getMonitorFactorId());
				rd.setMonitorTime(main.getMonitorTime());
				rd.setRtd(ld.get(i).getRtd());
				rd.setStatCodeId(main.getStatCodeId());
				rd.setFactorName((String)map.get("name"+ld.get(i).getMonitorFactorId()));
				rd.setUnit((String)map.get("unit"+ld.get(i).getMonitorFactorId()));
				data.add(rd);
			}
			/*
			 * 获取污水因子的实时数据
			 */
			RealtimeData rd = new RealtimeData();
			rd.setDevCodeId(l.get(0).getDevCodeId());
			rd.setId(l.get(0).getId());
			rd.setMonitorFactorId(1);
			rd.setMonitorTime(l.get(0).getMonitorTime());
			rd.setRtd(l.get(0).getRtd());
			rd.setStatCodeId(l.get(0).getStatCodeId());
			rd.setFactorName((String)map.get("name"+1));
			rd.setUnit((String)map.get("unit"+1));
			data.add(rd);
		}
		return data;
	}

	@Override
	public List<HourData> getHourData(int devCodeId,int monitorFactorId){
		List<HourData> data = new ArrayList<HourData>();
		List<MonitorFactor> factors=userDao.getMonitorFactors();
		List<MeasureUnitCode> units = userDao.getMeasureUnitCode();//---mend_1
		Map unitMap = new HashMap();
		for(int i=0;i<units.size();i++){
			MeasureUnitCode u = units.get(i);
			unitMap.put(u.getId(), u.getCode());
		}//---mend_1
		Map map = new HashMap();
		for(int i=0;i<factors.size();i++){
			MonitorFactor f=factors.get(i);
			map.put("unit"+f.getId(),unitMap.get(f.getUnitId()));//---mend_!
			//map.put("unit"+f.getId(),f.getUnit());
			map.put("name"+f.getId(), f.getFactorName());
		}
		Date end = new Date();
		Date start = new Date(end.getTime()-24*60000l*60);
		//Date end2 = new Date(end.getTime()-24*60000l*60*29);
		//System.out.println(start);
		//System.out.println(end);
		List<HourDataRCMain> lhdm = new ArrayList<HourDataRCMain>();
		lhdm = userDao.getHourDataRCMain(devCodeId,start,end);
		String ids="";
		
		for(int i=0;i<lhdm.size();i++){
			HourDataRCMain hdm = lhdm.get(i);
			if(i==0){
				ids = ids+hdm.getId();
			}
			else{
				ids = ids+","+hdm.getId();
			}
		}
		ids="("+ids+")";
		
		List<HourDataRCDetail> lhdd= new ArrayList<HourDataRCDetail>();
		if(!ids.equals("") && !ids.equals("()")){
			lhdd = userDao.getHourDataRCDetail(ids,monitorFactorId);
		}
		
		if(lhdd!=null){
			for(int i=0;i<lhdm.size();i++){
				HourDataRCMain hdm = lhdm.get(i);
				HourData hd = new HourData();
				for(int j=0;j<lhdd.size();j++){
					if(lhdd.get(j).getHourMainId().compareTo(hdm.getId()) == 0){
						HourDataRCDetail hdd = lhdd.get(j);
						hd.setAvg(hdd.getAvg());
						hd.setMax(hdd.getMax());
						hd.setMin(hdd.getMin());
						hd.setCou(hdd.getCou());
						hd.setMonitorFactorId(hdd.getMonitorFactorId());
						hd.setMonitorTime(hdm.getMonitorTime());
						hd.setStatCodeId(hdm.getStatCodeId());
						hd.setUnit((String) map.get("unit"+hdd.getMonitorFactorId()));
						hd.setId(hdd.getId());
						hd.setFactorName((String) map.get("name"+hdd.getMonitorFactorId()));
						hd.setDevCodeId(hdm.getDevCodeId());
						data.add(hd);
					}
				}
			}
		}
		
		if(monitorFactorId == 1){
			for(int i=0;i<lhdm.size();i++){
				HourDataRCMain hdm = lhdm.get(i);
				HourData hd = new HourData();
				hd.setCou(hdm.getIntervalAmount());
				hd.setMonitorFactorId(monitorFactorId);
				hd.setMonitorTime(hdm.getMonitorTime());
				hd.setStatCodeId(hdm.getStatCodeId());
				hd.setUnit((String) map.get("unit"+monitorFactorId));
				hd.setId(hdm.getId());
				hd.setFactorName((String) map.get("name"+monitorFactorId));
				hd.setDevCodeId(hdm.getDevCodeId());
				data.add(hd);
			}
		}
		//System.out.println("data:"+data.size());
		return data;
	}
	
	@Override
	public List<AlarmRecordData> getAlarmRecordData(Date date){
		List<AlarmRecordData> data = new ArrayList<AlarmRecordData>();
//		List<MonitorFactor> factors=userDao.getMonitorFactors();
//		List<SiteInfor> siteInfors=userDao.getSiteInfor();
		List<EnterpriseInfo> enterpriseInfos =userDao.getEnterpriseInfo();
		List<EquipmentInfor> equipmentInfors=userDao.getEquipmentInfors();
//		List<AlarmLimitType> alarmLimitType=userDao.getAlarmLimitType();
//		List<AlarmLimitTimeType> alarmLimitTimeType=userDao.getAlarmLimitTimeType();
//		List<SiteType> siteType=userDao.getSiteType();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		/*new Date(date.getTime()-34*24*60*60000l)*/
		String d = sdf.format(date);
		Date start = new Date();
		Date end = new Date();
		try {
			start = sdf1.parse(d+" 00:00:00");
			end = sdf1.parse(d+" 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<AlarmRecord> alarmRecord=userDao.getAlarmRecord(start, end);
		Map map = new HashMap();
//		for(int i=0;i<factors.size();i++){
//			MonitorFactor f=factors.get(i);
//			//map.put("unit"+f.getId(),f.getUnit());
//			map.put("name"+f.getId(), f.getFactorName());
//		}
		for(int i=0;i<enterpriseInfos.size();i++){
			EnterpriseInfo f=enterpriseInfos.get(i);
			map.put("site"+f.getId(),f.getName());
		}
		for(int i=0;i<equipmentInfors.size();i++){
			EquipmentInfor f=equipmentInfors.get(i);
			map.put("equipment"+f.getId(),f.getMonitorPortName());
		}
//		for(int i=0;i<alarmLimitType.size();i++){
//			AlarmLimitType f=alarmLimitType.get(i);
//			map.put("alarmlimit"+f.getId(),f.getTypeName());
//		}
//		for(int i=0;i<alarmLimitTimeType.size();i++){
//			AlarmLimitTimeType f=alarmLimitTimeType.get(i);
//			map.put("alarmtime"+f.getId(),f.getTypeName());
//		}
//		for(int i=0;i<siteType.size();i++){
//			SiteType f=siteType.get(i);
//			map.put("sitetype"+f.getId(),f.getSiteName());
//		}
		
		for(int i=0;i<alarmRecord.size();i++){
			AlarmRecord ar=alarmRecord.get(i);
			AlarmRecordData ard = new AlarmRecordData();
			//ard.setAlarmLimit(ar.getAlarmLimit());
			//ard.setAlarmLimitTimeType((String)map.get("alarmtime"+ar.getAlarmLimitTimeTypeId()));
			//ard.setAlarmLimitType((String)map.get("alarmlimit"+ar.getAlarmLimitTypeId()));
			//ard.setFactor((String)map.get("name"+ar.getFactorId()));
			//ard.setSiteType((String)map.get("sitetype"+ar.getSiteTypeId()));
			//ard.setCount(ar.getCount());
			ard.setContent(ar.getContent());
			ard.setDatetime(ar.getDatetime());
			ard.setId(ar.getId());
			ard.setMonitorName((String)map.get("equipment"+ar.getDevCodeId()));
			ard.setSiteName((String)map.get("site"+ar.getStateCode()));
			ard.setReceiveMan(ar.getReceiveMan());
			ard.setReceiveNumber(ar.getReceiveNumber());
			ard.setRemark(ar.getRemark());
			ard.setSoundAlarm(ar.getSoundAlarm());
			ard.setSend(ar.getSend());
			data.add(ard);
		}
		return data;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
