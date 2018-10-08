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
import org.wu.work.entity.DoctorWork;
import org.wu.work.entity.Patient;
import org.wu.work.entity.Register;
import org.wu.work.entity.User;
import org.wu.work.model.Mdiagnose;
import org.wu.work.model.MdoctorWork;
import org.wu.work.model.Mregister;
import org.wu.work.model.MregisterCount;
import org.wu.work.service.DoctorService;
import org.wu.work.service.DoctorWorkService;
import org.wu.work.service.OfficeService;
import org.wu.work.service.PatientService;
import org.wu.work.service.RegisterService;
import org.wu.work.service.UserService;
import org.wu.work.util.DateUtil;
import org.wu.work.util.Sequence;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/register")
public class RegisterController{
	
	/**
	 * 
	 * @author zhangwei
	 * @time 2017/02/18
	 *
	 */
	
	@Resource
	private RegisterService registerService;
	@Resource
	private DoctorWorkService doctorWorkService;
	@Resource
	private DoctorService doctorService;
	@Resource
	private OfficeService officeService;
	@Resource
	private UserService userService;
	@Resource
	private PatientService patientService;
	
	@RequestMapping(value="/showForm")
	public ModelAndView show(String vistid,String userId,String userName){
		System.out.println("vistid= "+vistid);
		ModelAndView model = new ModelAndView("diagnoseForm");
		model.addObject("vistid",vistid);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addRegister(){
		Map<String,Object> map=new HashMap<String,Object>();
		Register register = new Register();
		register.setCreateTime(new Timestamp(System.currentTimeMillis()));
		register.setDiagnose("手腕扭伤");
		register.setDoctorCode("D1001");
		register.setFeetype("现金");
		register.setRegisterFee(30);
		register.setOffice("A000");
		register.setUserId("4504231987");
		register.setVistId(Sequence.nextId());
		register.setStatus(0);
		 Register save = registerService.insertRegister(register);
			if(save != null)
			{
				System.out.println("插入成功");
		    	map.put("flag",true); 
			}
		return map;
	}
	
	//预约挂号列表
	@SuppressWarnings("unused")
	@RequestMapping(value="/registerList")
	@ResponseBody
	public Map<String,Object> queryRegisterList(int page,int pageSize){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = registerService.queryRegisterList(page, pageSize);
		List<Map<String,String>> dataNum = registerService.queryDataNum();
		if(list != null)
		{
			List<MdoctorWork> listRegister = new ArrayList<MdoctorWork>();
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MdoctorWork();
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setTitle(obj.get("title"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setTrueDate(obj.get("workDate"));
				 model.setClinicType(obj.get("clinicType"));
				 model.setReaminCount(obj.get("reaminCount")+"/"+obj.get("registerCount"));
				 model.setRegisterFee(obj.get("registerFee"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setOfficeCode(obj.get("officeCode"));
				 listRegister.add(model);
				 
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listRegister); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//根据输入条件查询预约挂号列表
	@RequestMapping(value="/registerListByCondiction")
	@ResponseBody
	public Map<String,Object> queryRegisterListByCondiction(int page,int pageSize,int flag,String officeType,String doctorName){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			list = registerService.queryRegisterListByType(officeType,page, pageSize);
		    dataNum = registerService.queryDataNumByType(officeType);
		}else if(flag==2){
			list = registerService.queryRegisterListByName(doctorName,page, pageSize);
			dataNum = registerService.queryDataNumByName(doctorName);
		}else if(flag==3){
			list = registerService.queryRegisterListByNameAndType(officeType,doctorName,page, pageSize);
			dataNum = registerService.queryDataNumByNameAndType(doctorName,officeType);
		}else{
			list = registerService.queryRegisterList(page, pageSize);
			dataNum = registerService.queryDataNum();
		}
		if(list != null)
		{
			List<MdoctorWork> listRegister = new ArrayList<MdoctorWork>();
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MdoctorWork();
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setTitle(obj.get("title"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setTrueDate(obj.get("workDate"));
				 model.setClinicType(obj.get("clinicType"));
				 model.setReaminCount(obj.get("reaminCount")+"/"+obj.get("registerCount"));
				 model.setRegisterFee(obj.get("registerFee"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setOfficeCode(obj.get("officeCode"));
				 listRegister.add(model);
				 
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listRegister); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//预约挂号
	@RequestMapping(value="/register")
	@ResponseBody
	public Map<String,Object> register(String code,String officeCode,String workDate,String userId,int payType){
		Map<String,Object> map=new HashMap<String,Object>();
		User user = userService.queryUserByName(userId);
		if(user == null)
		{
			System.out.println("系统没有该用户信息，请重新录入！");
			map.put("flag",false); 
			map.put("msg","系统没有该用户信息,请重新录入！"); 
			return map;
		}else{
			List<Map<String,String>> test = registerService.queryRegisterByUserId(userId, code,officeCode, workDate);
			if(test.size() == 0)
			{
			List<Map<String,String>> list = doctorWorkService.queryDoctorWorkByCodeAndDate(code, workDate);
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model = null;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MdoctorWork();
				 model.setId(obj.get("id"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setRegisterCount(obj.get("registerCount"));
				 model.setReaminCount(obj.get("reaminCount"));
			    }
			  synchronized(this)   //同步锁
			  {
				if(model != null && Integer.parseInt(model.getReaminCount()) > 0)
				{
					Doctor doctor = doctorService.queryDoctorByCode(code);
					Register register = new Register();
					register.setVistId(Sequence.nextId());
					register.setDoctorCode(code);
					register.setOffice(doctor.getOfficeCode());
					register.setCreateTime(new Timestamp(System.currentTimeMillis()));
					register.setRegisterFee(doctor.getRegisterFee());
					register.setUserId(userId);
					register.setSeeTime(DateUtil.parse(workDate,DateUtil.SHORT_FORMAT));
				    if(payType == 0)
				    {
					   register.setFeetype("现金");
				    }else if(payType == 1){
				    	Patient patient=patientService.queryPatientById(userId);
				    	if((patient.getBalanceMedical()-doctor.getRegisterFee()) >= 0)
				    	{
				    		patient.setBalanceMedical(patient.getBalanceMedical()-doctor.getRegisterFee());
				    		Patient save = patientService.modifyPatient(patient);
				    		if(save != null){
				    			register.setFeetype("账户余额");
				    		}else{
				    			map.put("flag",false); 
								map.put("msg","挂号失败"); 
								return map;
				    		}
				    		
				    	}else{
				    		map.put("flag",false); 
							map.put("msg","账户余额不足"); 
							return map;
				    	}
				       
				    }
				    register.setStatus(0);
				    Register save = registerService.insertRegister(register);
					if(save != null)
					{
						DoctorWork oldwork = doctorWorkService.queryDoctorWorkById(model.getId());
						oldwork.setReaminCount(Integer.parseInt(model.getReaminCount())-1);
						DoctorWork saveold = doctorWorkService.modifyDoctorWork(oldwork);
						if(saveold != null)
						{
							System.out.println("预约成功");
					    	map.put("flag",true); 
					    	map.put("msg","预约成功"); 
						}else{
							System.out.println("预约失败");
							map.put("flag",false); 
					    	map.put("msg","预约失败"); 
						}
						
					}else{
						System.out.println("预约失败");
						map.put("flag",false); 
				    	map.put("msg","预约失败");
					}
				}else{
					System.out.println("预约已满");
					map.put("flag",false);
					map.put("msg","预约已满"); 
				}
			  }  //synchronized
	    	}else{
	    		map.put("flag",false);
				map.put("msg","预约失败,重复预约"); 
				return map;
	    	}
		}
		
		return map;
	}
	
	@RequestMapping(value="/registerPatient")
	@ResponseBody
	public Map<String,Object> registerPatient(String code,String officeCode,String workDate,int payType,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		User userInfo = (User)session.getAttribute("userInfo");
		User user = userService.queryUserByName(userInfo.getUserName());
		if(user == null)
		{
			map.put("flag",false); 
			map.put("msg","非法用户！"); 
			return map;
		}else{
			List<Map<String,String>> test = registerService.queryRegisterByUserId(user.getUserName(), code,officeCode, workDate);
			if(test.size() == 0)
			{
			List<Map<String,String>> list = doctorWorkService.queryDoctorWorkByCodeAndDate(code, workDate);
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model = null;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MdoctorWork();
				 model.setId(obj.get("id"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setRegisterCount(obj.get("registerCount"));
				 model.setReaminCount(obj.get("reaminCount"));
			    }
			 synchronized(this)   //同步锁
			  {
				if(model != null && Integer.parseInt(model.getReaminCount()) > 0)
				{
					Doctor doctor = doctorService.queryDoctorByCode(code);
					Register register = new Register();
					register.setVistId(Sequence.nextId());
					register.setDoctorCode(code);
					register.setOffice(doctor.getOfficeCode());
					register.setCreateTime(new Timestamp(System.currentTimeMillis()));
					register.setRegisterFee(doctor.getRegisterFee());
					register.setUserId(userInfo.getUserName());
					register.setSeeTime(DateUtil.parse(workDate,DateUtil.SHORT_FORMAT));
				    if(payType == 1)
				    {
					   register.setFeetype("支付宝");
				    }else if(payType == 0){
				    	Patient patient=patientService.queryPatientById(userInfo.getUserName());
				    	if((patient.getBalanceMedical()-doctor.getRegisterFee()) >= 0)
				    	{
				    		patient.setBalanceMedical(patient.getBalanceMedical()-doctor.getRegisterFee());
				    		Patient save = patientService.modifyPatient(patient);
				    		if(save != null){
				    			register.setFeetype("账户余额");
				    		}else{
				    			map.put("flag",false); 
								map.put("msg","挂号失败"); 
								return map;
				    		}
				    		
				    	}else{
				    		map.put("flag",false); 
							map.put("msg","账户余额不足"); 
							return map;
				    	}
				       
				    }
				    register.setStatus(0);
				    Register save = registerService.insertRegister(register);
					if(save != null)
					{
						DoctorWork oldwork = doctorWorkService.queryDoctorWorkById(model.getId());
						oldwork.setReaminCount(Integer.parseInt(model.getReaminCount())-1);
						DoctorWork saveold = doctorWorkService.modifyDoctorWork(oldwork);
						if(saveold != null)
						{
							System.out.println("预约成功");
					    	map.put("flag",true); 
					    	map.put("msg","预约成功"); 
						}else{
							System.out.println("预约失败");
							map.put("flag",false); 
					    	map.put("msg","预约失败"); 
						}
						
					}else{
						System.out.println("预约失败");
						map.put("flag",false); 
				    	map.put("msg","预约失败");
					}
				}else{
					System.out.println("预约已满");
					map.put("flag",false);
					map.put("msg","预约已满"); 
				}
			  }
		}else{
			map.put("flag",false);
			map.put("msg","预约失败,重复预约"); 
			return map;
		}
		}
		
		return map;
	}
	
	//查看挂号量，退号量，总挂号费
	@RequestMapping(value="/findRegisterCountAndFee")
	@ResponseBody
	public Map<String,Object> queryRegisterCount(String stime,String etime) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> listCountAndFee = registerService.queryRegisterCount(stime, etime);
		List<Map<String,String>> listBackCount = registerService.queryRegisterBackCount(stime, etime);
		System.out.println(listCountAndFee.get(0).get("num"));
		MregisterCount model = new MregisterCount();
		model.setStime(stime);
		model.setEtime(etime);
		List<MregisterCount> listCount = new ArrayList<MregisterCount>();
		if(listCountAndFee != null && listBackCount!=null)
		{
				for (Map<String,String> obj : listCountAndFee) {
					model.setRegisterNum(obj.get("num"));
					if((obj.get("num")).equals("0"))
					{
					  model.setRegisterFee("0");
					}else{
					  model.setRegisterFee(obj.get("registerFee"));
					}
					model.setTuihaoNum("0");//如果listBackCount返回空，则显示0
				}
				for (Object o : listBackCount) {
					Map<String,String> obj = (Map<String,String>) o;
					model.setTuihaoNum(obj.get("num"));
				}
			listCount.add(model);
			
			//echarts图展示数据
			 JSONArray json = new JSONArray();
			 JSONObject jo1 = new JSONObject();
			 jo1.put("name", "挂号量");
			 jo1.put("value", model.getRegisterNum());
			 json.add(jo1);
			 JSONObject jo2 = new JSONObject();
			 jo2.put("name", "退号量");
			 jo2.put("value", model.getTuihaoNum());
			 json.add(jo2);
 
			map.put("flag",true);
			map.put("status", "0000");
			map.put("list", listCount);
			map.put("data", json);
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return  map;
	}
	
	//挂号统计（折线图）
	@RequestMapping(value="/findRegisterCount")
	@ResponseBody
	public Map<String,Object> queryRegisterCount() {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> listCount = registerService.queryRegisterCount();
		 System.out.println(listCount.get(0).get("Ctime"));
		//echarts图展示数据
		 JSONArray jsonT = new JSONArray();
		 JSONArray jsonC = new JSONArray();
		 JSONObject josonTime = new JSONObject();
		 JSONObject josonCount = new JSONObject();
		 if(listCount != null)
		  { 
			for (Map<String,String> obj : listCount) {		
				josonTime = new JSONObject();
			    josonCount = new JSONObject();
				josonTime.put("name", obj.get("Ctime"));
				josonTime.put("value", obj.get("Ctime")); 
				josonCount.put("name", obj.get("Ctime"));
				josonCount.put("value", obj.get("count"));
				jsonT.add(josonTime);
				jsonC.add(josonCount); 
			}
		 
			map.put("flag",true);
			map.put("status", "0000");
			map.put("time", jsonT);
			map.put("count", jsonC);
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return  map;
	}
	//医生诊断列表
	@SuppressWarnings("unused")
	@RequestMapping(value="/diagnose")
	@ResponseBody
	public Map<String,Object> queryRegisterByCode(int page,int pageSize,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> dataNum = registerService.queryDataNum(doctor.getDoctorCode());
		List<Map<String,String>> list = registerService.queryRegisterByCode(page, pageSize, doctor.getDoctorCode());
		System.out.println(list.size());
		if(list != null)
		{
			List<Mdiagnose> listRegister = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setStatus(obj.get("status"));
				 model.setUserId(obj.get("userId"));
				 if((obj.get("status")).equals("0"))
				 {
				    model.setFlag("正常");
				 }else if((obj.get("status")).equals("2")){
					model.setFlag("已完成");
				 }else if((obj.get("status")).equals("3")){
					 model.setFlag("已退号");
				 }
				 
				 listRegister.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listRegister); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//医生根据条件查找患者列表
	@RequestMapping(value="/findRegisterByVistId")
	@ResponseBody
	public Map<String,Object> queryRegisterByCodeAndVistId(String vistId,String userName,int flag,int page,int pageSize,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			list = registerService.queryRegisterByCodeAndVistId(page, pageSize,vistId, doctor.getDoctorCode());
			dataNum = registerService.queryDataNumByVistId(vistId, doctor.getDoctorCode());
		}else if(flag==2){
			list = registerService.queryRegisterByCodeAndName(page, pageSize,userName, doctor.getDoctorCode());
			dataNum = registerService.queryDataNumByPatientName(userName,doctor.getDoctorCode());
		}else{
			list = registerService.queryRegisterByCode(page, pageSize,doctor.getDoctorCode());
			dataNum = registerService.queryDataNum(doctor.getDoctorCode());
		}
		if(list != null)
		{
			List<Mdiagnose> listRegister = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setStatus(obj.get("status"));
				 model.setUserId(obj.get("userId"));
				 if((obj.get("status")).equals("0"))
				 {
				    model.setFlag("正常");
				 }else if((obj.get("status")).equals("2")){
					model.setFlag("已完成");
				 }else if((obj.get("status")).equals("3")){
					 model.setFlag("已退号");
				 }
				 
				 listRegister.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listRegister); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//诊断单管理列表
	@SuppressWarnings("unused")
	@RequestMapping(value="/findDiagnoseByCode")
	@ResponseBody
	public Map<String,Object> queryDiagnoseByCode(int page,int pageSize,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> list = registerService.queryDiagnoseByCode(page,pageSize,doctor.getDoctorCode());
		List<Map<String,String>> dataNum = registerService.queryDataNumResult(doctor.getDoctorCode());
		System.out.println(list.size());
		if(list != null)
		{
			List<Mdiagnose> listDiagnose = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setDiagnose(obj.get("diagnose"));
				 model.setSeeTime(obj.get("seeTime"));
				 model.setStatus(obj.get("status"));
				 model.setUserId(obj.get("userId"));
				 
				 listDiagnose.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listDiagnose); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//医生通过挂号序号或用户ID，查出患者所有诊断单
	@RequestMapping(value="/findDiagnoseByVistId")
	@ResponseBody
	public Map<String,Object> queryAllDiagnoseByVistId(int page,int pageSize,int flag,String vistId,String userId,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = registerService.queryDiagnoseByVistId(page, pageSize, vistId);
			   dataNum = registerService.queryDataNumResultByVistId(vistId);
		}else if(flag==2){
			   list = registerService.queryDiagnoseByUserId(page, pageSize, userId);
			   dataNum = registerService.queryDataNumResultByPatientId(userId);
		}else if(flag==3){
			   list = registerService.queryDiagnoseByVU(page, pageSize, vistId,userId);
			   dataNum = registerService.queryDataNumResultByUV(userId, vistId);
		}else{
			   list = registerService.queryDiagnoseByCode(page,pageSize,doctor.getDoctorCode());
			   dataNum = registerService.queryDataNumResult(doctor.getDoctorCode()); //默认加载所有该医生开的诊断单
		}
		if(list != null)
		{
			List<Mdiagnose> listDiagnose = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setDiagnose(obj.get("diagnose"));
				 model.setSeeTime(obj.get("seeTime"));
				 model.setStatus(obj.get("status"));
				 model.setUserId(obj.get("userId"));
				 listDiagnose.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listDiagnose); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	//退号管理
	@RequestMapping(value="/backRegisterFind")
	@ResponseBody
	public Map<String,Object> queryRegisterByUserId(String userId,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = registerService.queryRegisterByUserId(userId,page,pageSize);
		List<Map<String,String>> dataNum = registerService.queryRegisterByUserId(userId);
		if(list != null)
		{
			List<Mregister> listRegister = new ArrayList<Mregister>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mregister model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mregister();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setFeetype(obj.get("feeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("0"))
				 {
				    model.setFlag("正常");
				 }else if((obj.get("status")).equals("2")){
					model.setFlag("已完成");
				 }else if((obj.get("status")).equals("3")){
					 model.setFlag("已退号");
				 }
				 
				 listRegister.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listRegister); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}

	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyRegister(Register register) {
		Map<String,Object> map=new HashMap<String,Object>();
		Register oldregister = registerService.queryRegisterById(register.getVistId());
		oldregister.merge(register);
		registerService.modifyRegister(oldregister);
		map.put("flag",true);
		return map;
	}
	
	
	//输入诊断结果
	@RequestMapping(value="/WriteDiagnose")
	@ResponseBody
	public Map<String,Object> modifyDiagnose(Register register,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Map<String,Object> map=new HashMap<String,Object>();
		Register oldregister = registerService.queryRegisterById(register.getVistId());
		oldregister.setDiagnose(register.getDiagnose());
		oldregister.setStatus(2);       //更改挂号表的状态，表示诊断已完成
		Register save = registerService.modifyRegister(oldregister);
		if(save!=null)
		{
			List<Map<String,String>> list = registerService.queryAddDiagnoseList(register.getVistId(),user.getUserName());
	    	System.out.println("list="+list.size());
	    	List<Mdiagnose> listDiagnose = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setSeeTime(obj.get("seeTime"));
				 model.setDiagnose(obj.get("diagnose"));
				 
				 listDiagnose.add(model);
			}
	    	map.put("flag",true); 
	    	map.put("status","0000"); 
	    	map.put("list",listDiagnose); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//查询指定挂号序号以及医生填写的诊断单
	@RequestMapping(value="/findDiagnose")
	@ResponseBody
	public Map<String,Object> queryDiagnoseList(Register register,String code) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = registerService.queryAddDiagnoseList(register.getVistId(),code);
		if(list!=null)
		{
	    	System.out.println("list="+list.size());
	    	List<Mdiagnose> listDiagnose = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setSeeTime(obj.get("seeTime"));
				 model.setDiagnose(obj.get("diagnose"));
				 
				 listDiagnose.add(model);
			}
	    	map.put("flag",true); 
	    	map.put("status","0000"); 
	    	map.put("list",listDiagnose); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//退号
	@RequestMapping(value="/tuihao")
	@ResponseBody
	public Map<String,Object> registerBackByVistId(Register register) {
		Map<String,Object> map=new HashMap<String,Object>();
		Register status = registerService.queryRegisterById(register.getVistId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("msg", "退号失败");
			return map;
		}else{
			if(status.getSeeTime().getTime() > DateUtil.now().getTime())
			{
				status.setStatus(3);
				Register flag = registerService.changStatus(status);
				List<Map<String,String>> list = registerService.queryRegisterByVistId(register.getVistId());
			synchronized(this)   //同步锁
			{
				if(list != null && flag != null )
				{
					List<Map<String,String>> list_register = doctorWorkService.queryDoctorWorkByCodeAndDate(status.getDoctorCode(), DateUtil.formatDateShort(status.getSeeTime()));
					Iterator<Map<String,String>> iter = list_register.iterator();
					System.out.println(status.getDoctorCode()+status.getSeeTime()+"");
					DoctorWork oldwork=null;
					DoctorWork saveold=null;
					MdoctorWork model_work = null;
					while(iter.hasNext()){
						 Map<String,String> obj = (Map<String,String>)iter.next();
						 model_work = new MdoctorWork();
						 model_work.setId(obj.get("id"));
						 model_work.setDoctorCode(obj.get("doctorCode"));
						 model_work.setWorkDate(obj.get("workDate"));
						 model_work.setWorkTime(obj.get("workTime"));
						 model_work.setRegisterCount(obj.get("registerCount"));
						 model_work.setReaminCount(obj.get("reaminCount"));
						 oldwork = doctorWorkService.queryDoctorWorkById(model_work.getId());
						 oldwork.setReaminCount(Integer.parseInt(model_work.getReaminCount())+1);
						 saveold = doctorWorkService.modifyDoctorWork(oldwork);
						 if(saveold == null)
						 {
							 map.put("flag",false);
							 map.put("status", "1111");
							 break;
						 }
					  }
					
					List<Mregister> listRegister = new ArrayList<Mregister>();
					Iterator<Map<String,String>> iter2 = list.iterator();
					Mregister model;
					while(iter2.hasNext()){
						 Map<String,String> obj = (Map<String,String>)iter2.next();
						 model = new Mregister();
						 model.setVistId(obj.get("vistId"));
						 model.setUserName(obj.get("userName"));
						 model.setFeetype(obj.get("feeType"));
						 model.setDoctorName(obj.get("doctorName"));
						 model.setOfficeType(obj.get("officeType"));
						 model.setCreateTime(obj.get("createTime"));
						 model.setStatus(obj.get("status"));
						 if((obj.get("status")).equals("0"))
						 {
						    model.setFlag("正常");
						 }else if((obj.get("status")).equals("2")){
							model.setFlag("已完成");
						 }else if((obj.get("status")).equals("3")){
							 model.setFlag("已退号");
						 }
						 listRegister.add(model);
					    }
					map.put("flag",true);
					map.put("status", "0000");
					map.put("list", listRegister);
				}else{
					map.put("flag",false);
					map.put("status", "1111");
					map.put("msg", "退号失败");
				}
		}  //synchronized
			}else{
				map.put("flag",false);
				map.put("status", "1111");
				map.put("msg", "退号失败");
			}
			
		}
		return map;
	}

	//用户登录后查看自己的诊断单
	@SuppressWarnings("unused")
	@RequestMapping(value="/findDiagnoseByUser")
	@ResponseBody
	public Map<String,Object> queryAllDiagnoseByUser(int page,int pageSize,int flag,String stime,String etime,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = registerService.queryDiagnoseByUser(page, pageSize, user.getUserName(),stime,etime);
			   dataNum = registerService.queryDiagnoseByUser(user.getUserName(),stime,etime);
		}else{
			   list = registerService.queryDiagnoseByUser(page,pageSize,user.getUserName());
			   dataNum = registerService.queryDiagnoseByUser(user.getUserName()); //默认加载所有该医生开的诊断单
		}
		System.out.println(list.size());
		if(list != null)
		{
			List<Mdiagnose> listDiagnose = new ArrayList<Mdiagnose>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mdiagnose model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mdiagnose();
				 model.setVistId(obj.get("vistId"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setDiagnose(obj.get("diagnose"));
				 model.setSeeTime(obj.get("seeTime"));
				 model.setStatus(obj.get("status"));
				 
				 listDiagnose.add(model);
			    }
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listDiagnose); 
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deleteRegisterById(Register register) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = registerService.deleteRegister(register);
		if(!flag){
			map.put("flag",false);
			map.put("mes", "删除失败");
		}else{
			map.put("flag",true);
			map.put("mes", "删除成功");
		}
		return map;
	}
	 
	
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(Register register) {
		Map<String,Object> map=new HashMap<String,Object>();
		Register status = registerService.queryRegisterById(register.getVistId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			Register flag = registerService.changStatus(status);
			if(flag==null){
				map.put("flag",false);
				map.put("mes", "删除失败");
			}else{
				map.put("flag",true);
				map.put("mes", "删除成功");
			}
			return map;
		}
	}
	
}
