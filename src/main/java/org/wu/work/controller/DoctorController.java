package org.wu.work.controller;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.Doctor;
import org.wu.work.entity.Register;
import org.wu.work.entity.User;
import org.wu.work.service.DoctorService;
import org.wu.work.service.RegisterService;
import org.wu.work.service.UserService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private DoctorService doctorService;
	@Resource
	private RegisterService registerService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping(value="/showDiagnose")
	public ModelAndView show(String diagnose,String userId,String userName){
		System.out.println("diagnose= "+diagnose);
		ModelAndView model = new ModelAndView("diagnoseResult");
		model.addObject("diagnose",diagnose);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	
	@RequestMapping(value="/showUpdate")
	public ModelAndView showUpdate(String diagnose,String vistId,String userId,String userName){
		System.out.println("diagnose= "+diagnose);
		ModelAndView model = new ModelAndView("diagnoseUpdate");
		model.addObject("diagnose",diagnose);
		model.addObject("vistId",vistId);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	
	//医生更改诊断结果
	@RequestMapping(value="/updateDiagnose")
	@ResponseBody
	public Map<String,Object> updateDiagnose(String diagnose,String vistId,HttpSession session){
		User user = (User)session.getAttribute("userInfo");
		Map<String,Object> map=new HashMap<String,Object>();
		Register register = registerService.queryRegisterById(vistId);
		if(register.getDoctorCode().equals(user.getUserName()))
		{
			register.setDiagnose(diagnose);
			Register save = registerService.modifyRegister(register);
			if(save!=null)
			{
			  map.put("flag",true); 
			  map.put("status","0000"); 
			  map.put("msg","修改成功");
			}else{
		      map.put("flag",false); 
		      map.put("status","修改失败");
			}
		}else{
			 map.put("flag",false); 
		     map.put("status","1111");
		     map.put("msg","没有权限");
		}
		return map;
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addDoctor(Doctor doctor){
		Map<String,Object> map=new HashMap<String,Object>();
		User user = new User();
		user.setUserName(doctor.getDoctorCode());
		user.setTrueName(doctor.getDoctorName());
		user.setPassWord("123456");
		user.setUserType(2);
		user.setStatus(0);
		User flag = userService.queryUserByName(doctor.getDoctorCode());
		if(flag!=null)
		{
			map.put("flag",false); 
			map.put("msg","该用户已存在"); 
		}else{
			  User savaUser = userService.insertUser(user);
		      if(savaUser!=null)
			  {
			    Doctor save = doctorService.insertDoctor(doctor);
				if(save != null)
				{
					System.out.println("插入成功");
			    	map.put("flag",true); 
			    	map.put("msg","添加成功"); 
				}else{
					map.put("flag",false); 
					map.put("msg","添加失败");
				}
			  }else{
				  map.put("flag",false); 
				  map.put("msg","添加失败");
			  }
		}
		return map;
	}
	
	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryDoctor(int page,int pageSize,int flag,String doctorCode,String doctorName) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Doctor> list = null;
		List<Doctor> dataNum = null;
		if(flag==1)
		{
			   list = doctorService.queryDoctorByCode(page, pageSize,doctorCode);
			   dataNum = doctorService.queryDataNumByCode(doctorCode);
		}else if(flag==2){
			   list = doctorService.queryDoctorByName(page, pageSize,doctorName);
			   dataNum = doctorService.queryDataNumByName(doctorName);
		}else{
			   list = doctorService.queryDoctorList(page, pageSize);
			   dataNum = doctorService.queryDataNum();
		}
		
		if(list != null){
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",list); 
		}else{
			map.put("flag",false);
			map.put("status","1111");
		}
		return map;
	}
	
	@RequestMapping(value="/getDoctorList")
	@ResponseBody
	public JSONObject getDoctorList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<Doctor> dataNum = doctorService.queryDataNum();
		List<Doctor> list = doctorService.queryDoctorList(page, pageSize);
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			 json.put("flag",true); 
			 json.put("status","0000"); 
			 json.put("currentPage",page/pageSize+1); 
			 json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			 json.put("dataNum",dataNum.size()); 
			 json.put("list",list); 
		}else{
			 json.put("flag",false); 
			 json.put("status","1111"); 
		}
		return json;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView queryUserDetailById(String doctorCode) {
		System.out.println(doctorCode);
		ModelAndView model = new ModelAndView("doctorDetail");
		Doctor doctor=null;
		doctor=doctorService.queryDoctorByCode(doctorCode);
		if(doctor != null){
			System.out.println(doctor.toString());
			model.addObject("flag",true);
			model.addObject("doctor", doctor);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	@RequestMapping(value="/sel")
	@ResponseBody
	public Map<String,Object> queryDoctorByCode1(String code) {
		Map<String,Object> map=new HashMap<String,Object>();
		Doctor doctor=null;
		doctor=doctorService.queryDoctorByCode(code);
		if(doctor != null){
			System.out.println(doctor.toString());
			map.put("flag",true);
			map.put("obj", doctor);
		}else{
			map.put("flag",false);
		}
		return map;
	}

	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyDoctor(Doctor doctor) {
		Map<String,Object> map=new HashMap<String,Object>();
			Doctor olddoctor = doctorService.queryDoctorByCode(doctor.getDoctorCode());
			System.out.println(doctor.toString());
			System.out.println(olddoctor.toString());
			olddoctor.merge(doctor);
			Doctor save = doctorService.modifyDoctor(olddoctor);
			if(save!=null)
			{
			  map.put("flag",true); 
			}else{
		      map.put("flag",false); 
			}
		
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deleteDoctorById(Doctor doctor,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = doctorService.deleteDoctor(doctor);
		List<Doctor> list = doctorService.queryDoctorList(page, pageSize);
		if(flag ==false || list == null){
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
		}else{
			map.put("flag",true);
			map.put("status","0000");
			map.put("list",list);
			map.put("mes", "删除成功");
		}
		return map;
	}

	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(Doctor doctor,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Doctor> dataNum = null;
		List<Doctor> list = null;
		Doctor status = doctorService.queryDoctorByCode(doctor.getDoctorCode());
		if(status == null)
		{
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			Doctor change = doctorService.changStatus(status);
			if(flag == 1)
			{
				 list = doctorService.queryDoctorByCode(page, pageSize, doctor.getDoctorCode());
				 dataNum = doctorService.queryDataNumByCode(doctor.getDoctorCode());
			}else if(flag == 2){
				 list = doctorService.queryDoctorByName(page, pageSize, doctor.getDoctorName());
				 dataNum = doctorService.queryDataNumByName(doctor.getDoctorName());
			}else{
				 list = doctorService.queryDoctorList(page, pageSize);
				 dataNum = doctorService.queryDataNum();
			}
			if(change ==null || list == null){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
				map.put("flag",true);
				map.put("status","0000");
				map.put("currentPage",page/pageSize+1); 
			    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
			    map.put("list",list); 
			}
			return map;
		}
	}

	
}
