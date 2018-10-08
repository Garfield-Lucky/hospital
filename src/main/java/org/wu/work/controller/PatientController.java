package org.wu.work.controller;

 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.Doctor;
import org.wu.work.entity.Patient;
import org.wu.work.entity.User;
import org.wu.work.model.Mpatient;
import org.wu.work.service.DoctorService;
import org.wu.work.service.PatientService;
import org.wu.work.service.UserService;
import org.wu.work.util.DateUtil;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/patient")
public class PatientController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private PatientService patientService;
	@Resource
	private UserService userService;
	@Resource
	private DoctorService doctorService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public JSONObject addPatient(Patient patient){
		JSONObject json = new JSONObject();
		patient.setCreateTime(new Timestamp(System.currentTimeMillis()));
		patient.setStatus(0);
		User user = new User();
		user.setUserName(patient.getUserId());
		user.setTrueName(patient.getUserName());
		user.setPassWord("123456");
		user.setUserType(0);
		user.setStatus(0);
		if(patient.getIdCard().trim()=="")
		{
			json.put("flag",false); 
			json.put("msg","身份证号不能为空");
			return json;
		}
		User flag = userService.queryUserByName(patient.getIdCard());
		if(flag!=null)
		{
			if(flag.getStatus() == 1)
			{
				json.put("flag",false); 
				json.put("msg","该用户为黑名单用户");
				return json;
			}
			json.put("flag",false); 
			json.put("msg","该用户已存在"); 
		}else{
		    User savaUser = userService.insertUser(user);
			if(savaUser!=null)
			{
			    Patient save = patientService.insertPatient(patient);
			    if(save != null)
			    {
				    System.out.println("插入成功");
			 	    json.put("flag",true); 
			    }else{
			    	System.out.println("插入失败");
			    	json.put("flag",false); 
			    }
			}else{
					json.put("flag",false); 
			}
		}
		return json;
	}
	
	//管理员查看所有用户列表
	@RequestMapping(value="/getUserList")
	@ResponseBody
	public JSONObject getUserList(int page,int pageSize){
		List<Map<String,String>> dataNum = patientService.queryDataNum();
		List<Map<String,String>> list = patientService.queryPatientList(page, pageSize);
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			List<Mpatient> listUser = new ArrayList<Mpatient>();
			   Iterator<Map<String,String>> iter = list.iterator();
			   Mpatient model;
			 while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mpatient();
				 model.setUserId(obj.get("userId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicalNum(obj.get("medicalNum"));
				 model.setBalanceMedical(obj.get("balanceMedical"));
				 model.setNation(obj.get("nation"));
				 model.setAddress(obj.get("address"));
				 model.setPhone(obj.get("phone"));
				 model.setIdCard(obj.get("idCard"));
				 model.setMarry(obj.get("marry"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				
				 listUser.add(model);
			    }
			  json.put("flag",true); 
			  json.put("status","0000"); 
			  json.put("currentPage",page/pageSize+1); 
			  json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			  json.put("dataNum",dataNum.size()); 
			  json.put("list",listUser); 
		  json.put("status", "0000");
		}
		return json;
	}
	
	//医生查看患者列表
	@RequestMapping(value="/getUserListToDoctor")
	@ResponseBody
	public JSONObject getUserListToDoctor(int page,int pageSize,HttpSession session){
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> list = patientService.queryPatientListToDoctor(page, pageSize, doctor.getDoctorCode());
		List<Map<String,String>> dataNum = patientService.queryDataNumByCode(doctor.getDoctorCode());
		JSONObject json = new JSONObject();
		  if(list!=null)
		  {
			System.out.println("list="+list.size());
	    	List<Mpatient> listUser = new ArrayList<Mpatient>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mpatient model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mpatient();
				 model.setVistId(obj.get(""));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setPhone(obj.get("phone"));
				 model.setMarry(obj.get("marry"));
				 model.setAddress(obj.get("address"));
				  
				 listUser.add(model);
			    }
		   	  json.put("flag",true); 
			  json.put("status","0000"); 
			  json.put("currentPage",page/pageSize+1); 
			  json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			  json.put("dataNum",dataNum.size()); 
			  json.put("list",listUser); 
		 }else{
			json.put("flag",false); 
			json.put("status","1111"); 
		  }
			return json;
	}
	
	@RequestMapping(value="/sel")
	public ModelAndView queryPatientById(String userid) {
		ModelAndView model = new ModelAndView("registerCheckUser");
		Patient patient=null;
		patient=patientService.queryPatientById(userid);
		if(patient != null){
			System.out.println(patient.toString());
			model.addObject("flag",true);
			model.addObject("patient", patient);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	//挂号员查看指定用户信息
	@RequestMapping(value="/findByRegister")
	@ResponseBody
	public Map<String,Object> queryUserByRegister(String userId) {
		List<Map<String,String>> list = patientService.queryPatientByUserId(userId);
		JSONObject json = new JSONObject();
		if(list!=null)
		  {
			System.out.println("list="+list.size());
	    	List<Mpatient> listUser = new ArrayList<Mpatient>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mpatient model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mpatient();
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicalNum(obj.get("medicalNum"));
				 model.setBalanceMedical(obj.get("balanceMedical"));
				 model.setPhone(obj.get("phone"));
				 model.setIdCard(obj.get("idCard"));
				 model.setCreateTime(obj.get("createTime"));
				 
				 listUser.add(model);
			    }
				json.put("flag",true); 
				json.put("status","0000"); 
				json.put("list",listUser); 
		 }else{
			json.put("flag",false); 
			json.put("status","1111"); 
		  }
			return json;
	}
	
	//医生查看用户信息
	@RequestMapping(value="/findByDoctor")
	@ResponseBody
	public Map<String,Object> queryUserById(int page,int pageSize,int flag,String vistId,String userName,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = patientService.queryPatientByVistId(page, pageSize, doctor.getDoctorCode(), vistId);
			   dataNum = patientService.queryDataNumByvistId(vistId, doctor.getDoctorCode());
		}else if(flag==2){
			   list = patientService.queryPatientByUserName(page, pageSize, doctor.getDoctorCode(), userName);
			   dataNum = patientService.queryDataNumByUserName(userName, doctor.getDoctorCode());
		}else if(flag==3){
			   list = patientService.queryPatientByVU(page, pageSize, doctor.getDoctorCode(), vistId,userName);
			   dataNum = patientService.queryDataNumByUV(userName, vistId, doctor.getDoctorCode());
		}else{
			   list = patientService.queryPatientListToDoctor(page, pageSize, doctor.getDoctorCode());
			   dataNum = patientService.queryDataNumByCode(doctor.getDoctorCode());
		}
		
		JSONObject json = new JSONObject();
		  if(list!=null)
		  {
			System.out.println("list="+list.size());
	    	List<Mpatient> listUser = new ArrayList<Mpatient>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mpatient model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mpatient();
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setPhone(obj.get("phone"));
				 model.setMarry(obj.get("marry"));
				 model.setAddress(obj.get("address"));
				  
				 listUser.add(model);
			    }
			  json.put("flag",true); 
			  json.put("status","0000"); 
			  json.put("currentPage",page/pageSize+1); 
			  json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			  json.put("dataNum",dataNum.size()); 
			  json.put("list",listUser); 
		 }else{
			json.put("flag",false); 
			json.put("status","1111"); 
		  }
			return json;
	}
	
	
	//管理员查看指定用户信息
	@RequestMapping(value="/findByAdmin")
	@ResponseBody
	public Map<String,Object> queryUserByAdmin(int page,int pageSize,int flag,String userId,String userName) {
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = patientService.queryPatientByUserId(page, pageSize, userId);
			   dataNum = patientService.queryDataNumById(userId);
		}else if(flag==2){
			   list = patientService.queryPatientByUserName(page, pageSize, userName);
			   dataNum = patientService.queryDataNumByName(userName);
		}else if(flag==3){
			   list = patientService.queryPatientByUserId(page, pageSize, userId);
			   dataNum = patientService.queryDataNumById(userId);
		}else{
			System.out.println("page="+page+" "+"pageSize="+pageSize);
			   list = patientService.queryPatientList(page, pageSize);
			   dataNum = patientService.queryDataNum();
		}
		 
		JSONObject json = new JSONObject();
		if(list!=null)
		  {
			System.out.println("page="+page+"list="+list.size());
	    	List<Mpatient> listUser = new ArrayList<Mpatient>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mpatient model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mpatient();
				 model.setUserId(obj.get("userId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicalNum(obj.get("medicalNum"));
				 model.setBalanceMedical(obj.get("balanceMedical"));
				 model.setNation(obj.get("nation"));
				 model.setAddress(obj.get("address"));
				 model.setPhone(obj.get("phone"));
				 model.setIdCard(obj.get("idCard"));
				 model.setMarry(obj.get("marry"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 
				 listUser.add(model);
			    }
				json.put("flag",true); 
				json.put("status","0000"); 
				json.put("currentPage",page/pageSize+1); 
				json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				json.put("dataNum",dataNum.size()); 
				json.put("list",listUser); 
		 }else{
			json.put("flag",false); 
			json.put("status","1111"); 
		  }
			return json;
	}
	
	
	//管理员查看用户详细信息
	@RequestMapping(value="/detail")
	public ModelAndView queryUserDetailById(String userid) {
		System.out.println(userid);
		ModelAndView model = new ModelAndView("patientDetail");
		Patient patient=null;
		patient=patientService.queryPatientById(userid);
		if(patient != null){
			System.out.println(patient.toString());
			model.addObject("flag",true);
			model.addObject("user", patient);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	//用户自己查看自己的信息
	@RequestMapping(value="/userInfo")
	public ModelAndView queryUserDetailByUser(HttpSession session) {
		ModelAndView model = new ModelAndView("personInfo");
		User user = (User)session.getAttribute("userInfo");
		Patient patient=null;
		patient=patientService.queryPatientById(user.getUserName());
		if(patient != null){
			System.out.println(patient.toString());
			model.addObject("flag",true);
			model.addObject("user", patient);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}

	//管理员修改用户信息
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyPatient(Patient patient) {
		Map<String,Object> map=new HashMap<String,Object>();
		Patient oldpatient = patientService.queryPatientById(patient);
		oldpatient.merge(patient);
		Patient save = patientService.modifyPatient(oldpatient);
		List<Patient> list = new ArrayList<Patient>();
		list.add(save);
		if(save!=null)
		{
	    	map.put("flag",true); 
	    	map.put("list",list); 
		}
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deletePatientById(Patient patient,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println("uid:"+patient.getUserId());
		List<Map<String,String>> dataNum = patientService.queryDataNum();
		boolean flag = patientService.deletePatient(patient);
		List<Map<String,String>> list = patientService.queryPatientList(page, pageSize);
		if(list!=null && flag !=false)
		{
		   System.out.println("list="+list.size());
    	   List<Mpatient> listUser = new ArrayList<Mpatient>();
		   Iterator<Map<String,String>> iter = list.iterator();
		   Mpatient model;
		 while(iter.hasNext()){
			 Map<String,String> obj = (Map<String,String>)iter.next();
			 model = new Mpatient();
			 model.setUserId(obj.get("userId"));
			 model.setUserName(obj.get("userName"));
			 model.setSex(obj.get("sex"));
			 model.setAge(obj.get("age"));
			 model.setMedicalNum(obj.get("medicalNum"));
			 model.setBalanceMedical(obj.get("balanceMedical"));
			 model.setNation(obj.get("nation"));
			 model.setAddress(obj.get("address"));
			 model.setPhone(obj.get("phone"));
			 model.setIdCard(obj.get("idCard"));
			 model.setMarry(obj.get("marry"));
			 model.setCreateTime(obj.get("createTime"));
			 model.setRemark(obj.get("remark"));
			
			 listUser.add(model);
		    }
		    map.put("flag",true); 
		    map.put("status","0000"); 
		    map.put("currentPage",page/pageSize+1); 
		    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
		    map.put("dataNum",dataNum.size()); 
		    map.put("list",listUser); 
	   }else{
		   map.put("flag",false); 
		   map.put("status","1111"); 
	    }
		 
		return map;
	}

	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(Patient patient,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		
		Patient status = patientService.queryPatientById(patient.getUserId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			System.out.println("page"+page+" "+pageSize);
			Patient change = patientService.changStatus(status);
			int user = userService.deleteUser(patient.getUserId());
			System.out.println("user "+user);
			if(flag == 1)
			{
				 list = patientService.queryPatientByUserId(page, pageSize,patient.getUserId());
				 dataNum = patientService.queryDataNumById(patient.getUserId());
			}else if(flag == 2){
				 list = patientService.queryPatientByUserName(page, pageSize,patient.getUserName());
				 dataNum = patientService.queryDataNumByName(patient.getUserName());
			}else{
				 list = patientService.queryPatientList(page, pageSize);
				 dataNum = patientService.queryDataNum();
			}
			if(change == null || list == null || user == 0){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
				   System.out.println("list="+list.size());
		    	   List<Mpatient> listUser = new ArrayList<Mpatient>();
				   Iterator<Map<String,String>> iter = list.iterator();
				   Mpatient model;
				 while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new Mpatient();
					 model.setUserId(obj.get("userId"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setMedicalNum(obj.get("medicalNum"));
					 model.setBalanceMedical(obj.get("balanceMedical"));
					 model.setNation(obj.get("nation"));
					 model.setAddress(obj.get("address"));
					 model.setPhone(obj.get("phone"));
					 model.setIdCard(obj.get("idCard"));
					 model.setMarry(obj.get("marry"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setRemark(obj.get("remark"));
					
					 listUser.add(model);
				    }
				map.put("flag",true);
				map.put("status","0000");
				map.put("currentPage",page/pageSize+1); 
			    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
			    map.put("list",listUser); 
			}
			return map;
		}
	}
	
}
