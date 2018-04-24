package com.tinz.ssh.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tinz.ssh.service.LoginService;

public class LoginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
//	private String username;
//	private String password;
//	
	private LoginService loginService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public void login() throws Exception{
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		Gson gson = new  Gson();
		//String result = gson.toJson(loginService.validate(username,pass));
		String result = loginService.validate(username,pass);
		System.out.println("GSON-->"+result+username+pass);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}
	
	public void getEquipmentInfors() throws Exception{
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getEquipmentInfors());
		//System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}
	
	public void getEnterpriseInfo() throws Exception{
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getEnterpriseInfo());
		System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}
	
	public void getSiteMonitorInfo() throws Exception{
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getSiteMonitorInfo());
		System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}

	public void getMonitorFactors() throws Exception{
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getMonitorFactors());
		//System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}
	
	public void getRealtimeData() throws Exception{
		String devCodeId = request.getParameter("dev");
		System.out.println("devCodeId-->"+devCodeId);
		String[] ss = devCodeId.split(",");
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getRealtimeData(Integer.parseInt(ss[0]),Integer.parseInt(ss[1])));
		System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {
			e.printStackTrace();    
		}
	}
	
	public void getHourData() throws Exception{
		String monitorFactorId = request.getParameter("factor");
		String devCodeId = request.getParameter("dev");
		String[] ss = devCodeId.split(",");
		Gson gson = new  Gson();
		String result = gson.toJson(loginService.getHourData(Integer.parseInt(ss[1]),Integer.parseInt(monitorFactorId)));
		//System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getAlarmRecordData() throws Exception{
		String offset = request.getParameter("offset");
		Gson gson = new  Gson();
		Date date = new Date();
		int gap = Integer.parseInt(offset);
		String result = gson.toJson(loginService.getAlarmRecordData(new Date(date.getTime()+gap*24*60*60000l)));
		//System.out.println("GSON-->"+result);
		try {
            response.setCharacterEncoding("utf-8");    
            this.response.getWriter().write(result);    
		} catch (IOException e) {    
			e.printStackTrace();    
		}
	}
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0; 
	}
}
