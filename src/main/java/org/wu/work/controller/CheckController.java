package org.wu.work.controller;

 
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.Check;
import org.wu.work.entity.CheckFee;
import org.wu.work.entity.Doctor;
import org.wu.work.entity.User;
import org.wu.work.model.MCheck;
import org.wu.work.service.CheckFeeService;
import org.wu.work.service.CheckService;
import org.wu.work.service.DoctorService;
import org.wu.work.util.DateUtil;
import org.wu.work.util.Sequence;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/check")
public class CheckController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private CheckService checkService;
	@Resource
	private DoctorService doctorService;
	@Resource
	private CheckFeeService checkFeeService;
	
	@RequestMapping(value="/checkForm")
	public ModelAndView show(String vistid,String userId,String userName){
		System.out.println("vistid= "+vistid);
		ModelAndView model = new ModelAndView("checkForm");
		model.addObject("vistid",vistid);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	
	@RequestMapping(value="/showCheckForm")
	public ModelAndView showCheckForm(String id,String userId,String userName){
		System.out.println("id= "+id);
		ModelAndView model = new ModelAndView("checkResultForm");
		model.addObject("id",id);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	//检查室查看检查结果
	@RequestMapping(value="/showCheckResult")
	public ModelAndView showCheckResult(String result,String photo,String userId,String userName){
		System.out.println("result= "+result);
		ModelAndView model = new ModelAndView("checkResult");
		model.addObject("checkResult",result);
		model.addObject("checkPhoto",photo);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	@RequestMapping(value="/showUpdate")
	public ModelAndView showUpdate(String checkResult,String id,String userId,String userName){
		System.out.println("checkResult= "+checkResult);
		ModelAndView model = new ModelAndView("checkResultUpdate");
		model.addObject("checkResult",checkResult);
		model.addObject("id",id);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	//检查室更改检查结果
	@RequestMapping(value="/updateCheckResult")
	@ResponseBody
	public Map<String,Object> updateCheckResult(String checkResult,String id,HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<String,Object>();
		Check check = checkService.queryCheckById(id);
		check.setCheckResult(checkResult);
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
        	//转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = System.currentTimeMillis()+"-" + file.getOriginalFilename();  
                        check.setCheckPhoto(fileName);
                        //定义上传路径  
                        @SuppressWarnings("deprecation")
						String path = request.getRealPath(File.separator +"checkImage");
                        System.out.println("path "+path);
                        File localFile = new File(path,fileName);  
                        file.transferTo(localFile);  
                    }  
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
		Check save = checkService.modifyCheck(check);
		if(save!=null)
		{
		  map.put("flag",true); 
		  map.put("status","0000"); 
		}else{
	      map.put("flag",false); 
	      map.put("status","1111");
		}
		return map;
	}
		
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addCheck(Check check,int page,int pageSize,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		 check.setId(Sequence.nextId());
		 check.setDoctorCode(doctor.getDoctorCode());
		 check.setCreateTime(new Timestamp(System.currentTimeMillis()));
		 check.setCheckPerson("");
		 check.setRemark("备注..");
		 
		 Check save = checkService.insertCheck(check);
		 if(save != null)
			{
				System.out.println("插入成功");
				List<Map<String,String>> list = checkService.queryAddCheckListV(page, pageSize, check.getVistId());
				List<Map<String,String>> dataNum = checkService.queryDataNum(check.getVistId());
				System.out.println("list="+list.size());
		    	List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setCheckType(obj.get("checkType"));
					 model.setSpecimenType(obj.get("specimenType"));
					 model.setCheckPlace(obj.get("checkPlace"));
					 model.setCheckMethod(obj.get("checkMethod"));
					 model.setCheckPerson(obj.get("checkPerson"));
					 if((obj.get("status")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
		return map;
	}
	
	//查询刚刚添加的检查单
	@RequestMapping(value="/getAddCheckList")
	@ResponseBody
	public Map<String,Object> getAddCheckList(int page,int pageSize,String vistId){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = checkService.queryAddCheckListV(page, pageSize, vistId);
		List<Map<String,String>> dataNum = checkService.queryDataNum(vistId);
	    List<CheckFee> itemList = checkFeeService.queryCheckFeeList(0,1000);
		if(list != null)
	    {
			List<MCheck> listCheck = new ArrayList<MCheck>();
			Iterator<Map<String,String>> iter = list.iterator();
			MCheck model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MCheck();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setCheckType(obj.get("checkType"));
				 model.setSpecimenType(obj.get("specimenType"));
				 model.setCheckPlace(obj.get("checkPlace"));
				 model.setCheckMethod(obj.get("checkMethod"));
				 model.setCheckPerson(obj.get("checkPerson"));
				 if((obj.get("status")).equals("2"))
				 {
					 model.setStatus("已检查"); 
				 }else{
					 model.setStatus("未检查"); 
				 }
				 listCheck.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listCheck); 
			map.put("itemList",itemList); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//模糊查询
	@SuppressWarnings("unused")
	@RequestMapping(value="/findCheckItem")
	@ResponseBody
	public Map<String,Object> findCheckItem(String checkType){
		Map<String,Object> map=new HashMap<String,Object>();
	    List<CheckFee> itemList = checkFeeService.findCheckItem(checkType);
	    System.out.println(itemList.size());
	     if(itemList != null)
	     {
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("itemList",itemList); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//检查检查单的检查项目是否存在
	@RequestMapping(value="/findCheckType")
	@ResponseBody
	public Map<String,Object> findCheckType(String checkType){
		Map<String,Object> map=new HashMap<String,Object>();
	    List<CheckFee> itemList = checkFeeService.findCheckType(checkType);
	     if(itemList.size() != 0)
	     {
			map.put("flag",true); 
			map.put("status","0000"); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
		
		//医生检查单管理
		@RequestMapping(value="/getCheckList")
		@ResponseBody
		public JSONObject getCheckList(int page,int pageSize,HttpSession session){
			User user = (User)session.getAttribute("userInfo");
			Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
			List<Map<String,String>> list = checkService.queryCheckList(page, pageSize, doctor.getDoctorCode());
			List<Map<String,String>> dataNum = checkService.queryDataNumByCode(doctor.getDoctorCode());
			JSONObject json = new JSONObject();
			if(list!=null)
			{
				System.out.println("list="+list.size());
		    	List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setCheckType(obj.get("checkType"));
					 model.setSpecimenType(obj.get("specimenType"));
					 model.setCheckPlace(obj.get("checkPlace"));
					 model.setCheckMethod(obj.get("checkMethod"));
					 model.setCheckPerson(obj.get("checkPerson"));
					 if((obj.get("status")).equals("2"))
					 {
						 model.setStatus("已检查"); 
						 model.setStyle("danger");
					 }else{
						 model.setStatus("未检查"); 
						 model.setStyle("active");
					 }
					 if((obj.get("checkTime")) != null)
					 {
					     model.setCheckTime(obj.get("checkTime"));
					 }else{
					 }
					 model.setCheckResult(obj.get("checkResult"));
					 model.setUserId(obj.get("userId"));
					 model.setCheckPhoto(obj.get("checkPhoto"));
					 listCheck.add(model);
				}
				json.put("flag",true); 
				json.put("status","0000"); 
				json.put("currentPage",page/pageSize+1); 
				json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				json.put("dataNum",dataNum.size()); 
				json.put("list",listCheck);
			}else{
				json.put("flag",false); 
				json.put("status","1111"); 
			}
			return json;
		}
		
	//检查室查看检查列表
	@RequestMapping(value="/getCheckListInCRoom")
	@ResponseBody
	public JSONObject getCheckListByCheck(int page,int pageSize){
		List<Map<String,String>> list = checkService.queryCheckListInCRoom(page, pageSize);
		List<Map<String,String>> dataNum = checkService.queryCheckListInCRoom();
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			List<MCheck> listCheck = new ArrayList<MCheck>();
			Iterator<Map<String,String>> iter = list.iterator();
			MCheck model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MCheck();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setCheckType(obj.get("checkType"));
				 model.setSpecimenType(obj.get("specimenType"));
				 model.setCheckPlace(obj.get("checkPlace"));
				 model.setCheckMethod(obj.get("checkMethod"));
				 model.setCheckPerson(obj.get("checkPerson"));
				 if((obj.get("status")).equals("2"))
				 {
					 model.setFlag("已检查"); 
				 }else if((obj.get("status")).equals("1")){
					 model.setFlag("未检查"); 
				 }else{
					 model.setFlag("未付费"); 
				 }
				 model.setUserId(obj.get("userId"));
				 listCheck.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listCheck);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//检查室检查单管理列表(默认加载已经检查过的检查单)
	@RequestMapping(value="/getCheckResultList")
	@ResponseBody
	public JSONObject getCheckResultList(int page,int pageSize){
		List<Map<String,String>> list = checkService.queryCheckResultList(page, pageSize);
		List<Map<String,String>> dataNum = checkService.queryCheckResultDataNum();
		JSONObject json = new JSONObject();
		if(list!=null)
		{
	    	List<MCheck> listCheck = new ArrayList<MCheck>();
			Iterator<Map<String,String>> iter = list.iterator();
			MCheck model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MCheck();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setCheckType(obj.get("checkType"));
				 model.setSpecimenType(obj.get("specimenType"));
				 model.setCheckPlace(obj.get("checkPlace"));
				 model.setCheckMethod(obj.get("checkMethod"));
				 model.setCheckPerson(obj.get("checkPerson"));
				 if((obj.get("status")).equals("2"))
				 {
					 model.setStatus("已检查"); 
				 }else{
					 model.setStatus("未检查"); 
				 }
				 model.setCheckResult(obj.get("checkResult"));
				 if((obj.get("checkTime")) != null)
				 {
				     model.setCheckTime(obj.get("checkTime"));
				 }else{
				 }
				 model.setUserId(obj.get("userId"));
				 model.setCheckPhoto(obj.get("checkPhoto"));
				 listCheck.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listCheck);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//检查室检查员输入条件查看检查单	
	@RequestMapping(value="/findCheckResultByInput")
	@ResponseBody
	public Map<String,Object> queryCheckResult(int page,int pageSize,int flag,String vistId,String userId) {
			Map<String,Object> map=new HashMap<String,Object>();

			List<Map<String,String>> list = null;
			List<Map<String,String>> dataNum = null;
			if(flag==1)
			{
				   list = checkService.queryAddCheckResultListV(page, pageSize, vistId);
				   dataNum = checkService.queryAddCheckResultListV(vistId);
			}else if(flag==2){
				   list = checkService.queryAddCheckResultListU(page, pageSize, userId);
				   dataNum = checkService.queryAddCheckResultListU(userId);
			}else if(flag==3){
				   list = checkService.queryAddCheckResultListVU(page, pageSize, vistId,userId);
				   dataNum = checkService.queryAddCheckResultListVU(vistId,userId);
			}else{
				   list = checkService.queryCheckResultList(page, pageSize);
				   dataNum = checkService.queryCheckResultDataNum();
			}
			if(list != null)
		    {
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setCheckType(obj.get("checkType"));
					 model.setSpecimenType(obj.get("specimenType"));
					 model.setCheckPlace(obj.get("checkPlace"));
					 model.setCheckMethod(obj.get("checkMethod"));
					 model.setCheckPerson(obj.get("checkPerson"));
					 if((obj.get("status")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 model.setCheckResult(obj.get("checkResult"));
					 if((obj.get("checkTime")) != null)
					 {
					     model.setCheckTime(obj.get("checkTime"));
					 }else{
					 }
					 model.setUserId(obj.get("userId"));
					 model.setCheckPhoto(obj.get("checkPhoto"));
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck);
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
	}
	//****注意******** 这里需要获取医生编号，现在用的是固定医生编号D1003	
	//医生输入条件查看检查单	
	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryCheckByVistId(int page,int pageSize,int flag,String vistId,String userId,HttpSession session) {
			Map<String,Object> map=new HashMap<String,Object>();
			User user = (User)session.getAttribute("userInfo");
			Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
			List<Map<String,String>> dataNum = null;
			List<Map<String,String>> list = null;
			if(flag==1)
			{
				   list = checkService.queryAddCheckListV(page, pageSize, vistId);
				   dataNum = checkService.queryDataNumByVistId(vistId, doctor.getDoctorCode());
			}else if(flag==2){
				   list = checkService.queryAddCheckListU(page, pageSize, userId);
				   dataNum = checkService.queryDataNumByUserId(userId, doctor.getDoctorCode());
			}else if(flag==3){
				   list = checkService.queryAddCheckListVU(page, pageSize, vistId,userId);
				   dataNum = checkService.queryDataNumByUV(userId,vistId, doctor.getDoctorCode());
			}else{
				   list = checkService.queryCheckList(page, pageSize, doctor.getDoctorCode());
				   dataNum = checkService.queryDataNumByCode(doctor.getDoctorCode());
			}
			if(list != null)
		    {
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setCheckType(obj.get("checkType"));
					 model.setSpecimenType(obj.get("specimenType"));
					 model.setCheckPlace(obj.get("checkPlace"));
					 model.setCheckMethod(obj.get("checkMethod"));
					 model.setCheckPerson(obj.get("checkPerson"));
					 if((obj.get("status")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 model.setCheckResult(obj.get("checkResult"));
					 if((obj.get("checkTime")) != null)
					 {
					     model.setCheckTime(obj.get("checkTime"));
					 }else{
					 }
					 model.setUserId(obj.get("userId"));
					 model.setCheckPhoto(obj.get("checkPhoto"));
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
	}
	//用户查看自己的检查单
	@RequestMapping(value="/findByUser")
	@ResponseBody
	public Map<String,Object> queryCheckByByUser(int page,int pageSize,int flag,String stime,String etime,HttpSession session) {
			Map<String,Object> map=new HashMap<String,Object>();
			User user = (User)session.getAttribute("userInfo");
			List<Map<String,String>> dataNum = null;
			List<Map<String,String>> list = null;
			if(flag==1)
			{
				   list = checkService.queryCheckListByUser(page, pageSize, user.getUserName(),stime,etime);
				   dataNum = checkService.queryCheckListByUser(page,pageSize,user.getUserName());
			}else{
				   list = checkService.queryCheckListByUser(page, pageSize,user.getUserName());
				   dataNum = checkService.queryCheckListByUser(user.getUserName());
			}
			if(list != null)
		    {
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setCheckType(obj.get("checkType"));
					 model.setSpecimenType(obj.get("specimenType"));
					 model.setCheckPlace(obj.get("checkPlace"));
					 model.setCheckMethod(obj.get("checkMethod"));
					 model.setCheckPerson(obj.get("checkPerson"));
					 if((obj.get("status")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 model.setCheckResult(obj.get("checkResult"));
					 if((obj.get("checkTime")) != null)
					 {
					     model.setCheckTime(obj.get("checkTime"));
					 }else{
					 }
					 model.setUserId(obj.get("userId"));
					 model.setCheckPhoto(obj.get("checkPhoto"));
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
	}
		
	//检查化验室查看检查患者列表
	@RequestMapping(value="/findByCheckRoom")
	@ResponseBody
	public Map<String,Object> queryCheckByCheckRoom(int page,int pageSize,int flag,String vistId,String userName) {
			Map<String,Object> map=new HashMap<String,Object>();

			List<Map<String,String>> list = null;
			List<Map<String,String>> dataNum = null;
			if(flag==1)
			{
				   list = checkService.queryCheckListV(page, pageSize, vistId);
				   dataNum = checkService.findDataNumByVistId(vistId);
			}else if(flag==2){
				   list = checkService.queryCheckListU(page, pageSize, userName);
				   dataNum = checkService.findDataNumByUserName(userName);
			}else if(flag==3){
				   list = checkService.queryCheckListVU(page, pageSize, vistId,userName);
				   dataNum = checkService.findDataNumByVU(vistId, userName);
			}else{
				   list = checkService.queryCheckListInCRoom(page, pageSize);
				   dataNum = checkService.queryCheckListInCRoom();
			}
			if(list != null)
		    {
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get(""));
					 model.setVistId(obj.get(""));
					 model.setUserName(obj.get(""));
					 model.setSex(obj.get(""));
					 model.setAge(obj.get(""));
					 model.setOfficeType(obj.get(""));
					 model.setDoctorName(obj.get(""));
					 model.setCreateTime(obj.get(""));
					 model.setCheckType(obj.get(""));
					 model.setSpecimenType(obj.get(""));
					 model.setCheckPlace(obj.get(""));
					 model.setCheckMethod(obj.get(""));
					 model.setCheckPerson(obj.get(""));
					 model.setUserId(obj.get(""));
					 if((obj.get("")).equals("2"))
					 {
						 model.setFlag("已检查"); 
					 }else if((obj.get("")).equals("1")){
						 model.setFlag("未检查"); 
					 }else{
						 model.setFlag("未付费"); 
					 }
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
	}
	
	//检查室通过挂号序号查看检查单
	@RequestMapping(value="/findInCRoom")
	@ResponseBody
	public Map<String,Object> queryCheckByVistIdInCRoom(int page,int pageSize,String vistId) {
			Map<String,Object> map=new HashMap<String,Object>();
			List<Map<String,String>> list = checkService.queryCheckListInCRoom(page, pageSize, vistId);
			if(list != null)
		    {
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get(""));
					 model.setVistId(obj.get(""));
					 model.setUserName(obj.get(""));
					 model.setSex(obj.get(""));
					 model.setAge(obj.get(""));
					 model.setOfficeType(obj.get(""));
					 model.setDoctorName(obj.get(""));
					 model.setCreateTime(obj.get(""));
					 model.setCheckType(obj.get(""));
					 model.setSpecimenType(obj.get(""));
					 model.setCheckPlace(obj.get(""));
					 model.setCheckMethod(obj.get(""));
					 model.setCheckPerson(obj.get(""));
					 if((obj.get("")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 listCheck.add(model);
				}
				map.put("flag",true); 
		    	map.put("status","0000"); 
		    	map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
	}
	//输入检查结果
	@RequestMapping(value="/writeCheckResult")
	@ResponseBody
	public Map<String,Object> writeCheckResult(Check check,HttpSession session,HttpServletRequest request) throws IllegalStateException, IOException {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		Check oldcheck = checkService.queryCheckById(check.getId());
		oldcheck.setCheckResult(check.getCheckResult());
		oldcheck.setCheckTime(new Timestamp(System.currentTimeMillis()));
		oldcheck.setCheckPerson(user.getTrueName());
		oldcheck.setStatus(2);       //更改检查表的状态，表示检查已完成
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String oldFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(oldFileName.trim() !=""){  
                        System.out.println(oldFileName);  
                        //重命名上传后的文件名  
                        String newFileName = System.currentTimeMillis()+"-" + file.getOriginalFilename();  
                        oldcheck.setCheckPhoto(newFileName);
                        //定义上传路径  
                        @SuppressWarnings("deprecation")
						String path = request.getRealPath(File.separator +"checkImage");
                        File localFile = new File(path,newFileName);  
                        file.transferTo(localFile);  
                    }  
                }  
            }  
        }  
		Check save = checkService.modifyCheck(oldcheck);
		if(save!=null)
		{
			List<Map<String,String>> list = checkService.queryCheckResult(check.getId());
	    	System.out.println("list="+list.size());
	    	List<MCheck> listCheck = new ArrayList<MCheck>();
			Iterator<Map<String,String>> iter = list.iterator();
			MCheck model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MCheck();
				 model.setVistId(obj.get(""));
				 model.setUserName(obj.get(""));
				 model.setSex(obj.get(""));
				 model.setAge(obj.get(""));
				 model.setCheckTime(obj.get(""));
				 
				 listCheck.add(model);
			}
	    	map.put("flag",true); 
	    	map.put("status","0000"); 
	    	map.put("list",listCheck); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
   //通过检查单Id查看检查结果
		@RequestMapping(value="/findCheckResult")
		@ResponseBody
		public Map<String,Object> queryCheckResult(Check check) {
			Map<String,Object> map=new HashMap<String,Object>();
			List<Map<String,String>> list = checkService.queryCheckResult(check.getId());
			if(list!=null)
			{
		    	System.out.println("list="+list.size());
		    	List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setVistId(obj.get(""));
					 model.setUserName(obj.get(""));
					 model.setSex(obj.get(""));
					 model.setAge(obj.get(""));
					 model.setCheckTime(obj.get(""));
					 
					 listCheck.add(model);
				}
		    	map.put("flag",true); 
		    	map.put("status","0000"); 
		    	map.put("list",listCheck); 
			}else{
				map.put("flag",false); 
		    	map.put("status","1111"); 
			}
			return map;
		}
		
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyCheck(Check check) {
		Map<String,Object> map=new HashMap<String,Object>();
		Check oldcheck = checkService.queryCheckById(check.getId());
		oldcheck.merge(check);
		checkService.modifyCheck(oldcheck);
		map.put("flag",true); 
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deleteCheckById(Check check,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = checkService.deleteCheck(check);
		List<Map<String,String>> list = checkService.queryAddCheckListV(page, pageSize, check.getVistId());
		if(flag == false || list == null){
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
		}else{
			List<MCheck> listCheck = new ArrayList<MCheck>();
			Iterator<Map<String,String>> iter = list.iterator();
			MCheck model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new MCheck();
				 model.setId(obj.get(""));
				 model.setVistId(obj.get(""));
				 model.setUserName(obj.get(""));
				 model.setSex(obj.get(""));
				 model.setAge(obj.get(""));
				 model.setOfficeType(obj.get(""));
				 model.setDoctorName(obj.get(""));
				 model.setCreateTime(obj.get(""));
				 model.setCheckType(obj.get(""));
				 model.setSpecimenType(obj.get(""));
				 model.setCheckPlace(obj.get(""));
				 model.setCheckMethod(obj.get(""));
				 model.setCheckPerson(obj.get(""));
				 if((obj.get("")).equals("2"))
				 {
					 model.setStatus("已检查"); 
				 }else{
					 model.setStatus("未检查"); 
				 }
				 listCheck.add(model);
			}
			map.put("flag",true);
			map.put("status","0000");
			map.put("list",listCheck);
			map.put("mes", "删除成功");
		}
		return map;
	}

	//添加检查单页面的删除操作
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(Check check,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		Check status = checkService.queryCheckById(check.getId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			if(status.getStatus() == 0)
			{
			status.setStatus(3);
			Check flag = checkService.changStatus(status);
			List<Map<String,String>> list = checkService.queryAddCheckListV(page, pageSize, check.getVistId());
			List<Map<String,String>> dataNum = checkService.queryDataNum(check.getVistId());
			if(flag == null || list == null){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get(""));
					 model.setVistId(obj.get(""));
					 model.setUserName(obj.get(""));
					 model.setSex(obj.get(""));
					 model.setAge(obj.get(""));
					 model.setOfficeType(obj.get(""));
					 model.setDoctorName(obj.get(""));
					 model.setCreateTime(obj.get(""));
					 model.setCheckType(obj.get(""));
					 model.setSpecimenType(obj.get(""));
					 model.setCheckPlace(obj.get(""));
					 model.setCheckMethod(obj.get(""));
					 model.setCheckPerson(obj.get(""));
					 if((obj.get("")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 model.setUserId(obj.get(""));
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}
			
			}else{
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}
			 return map;
		}
	}
	
	//检查单管理页面的删除操作
	@RequestMapping(value="/delCheck")
	@ResponseBody
	public Map<String,Object> deleteCheck(Check check,String userId,int page,int pageSize,int flag,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Map<String,Object> map=new HashMap<String,Object>();
		Check status = checkService.queryCheckById(check.getId());
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			if(status.getStatus() == 0)
			{
			status.setStatus(3);
			Check change = checkService.changStatus(status);
			if(flag==1)
			{
				   list = checkService.queryAddCheckListV(page, pageSize, check.getVistId());
				   dataNum = checkService.queryDataNumByVistId(check.getVistId(), user.getUserName());
			}else if(flag==2){
				   list = checkService.queryAddCheckListU(page, pageSize, userId);
				   dataNum = checkService.queryDataNumByUserId(userId, user.getUserName());
			}else if(flag==3){
				   list = checkService.queryAddCheckListVU(page, pageSize, check.getVistId(),userId);
				   dataNum = checkService.queryDataNumByUV(userId,check.getVistId(), user.getUserName());
			}else{
				   list = checkService.queryCheckList(page, pageSize, user.getUserName());
				   dataNum = checkService.queryDataNumByCode(user.getUserName());
			}
			if(change == null || list == null){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
				List<MCheck> listCheck = new ArrayList<MCheck>();
				Iterator<Map<String,String>> iter = list.iterator();
				MCheck model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new MCheck();
					 model.setId(obj.get(""));
					 model.setVistId(obj.get(""));
					 model.setUserName(obj.get(""));
					 model.setSex(obj.get(""));
					 model.setAge(obj.get(""));
					 model.setOfficeType(obj.get(""));
					 model.setDoctorName(obj.get(""));
					 model.setCreateTime(obj.get(""));
					 model.setCheckType(obj.get(""));
					 model.setSpecimenType(obj.get(""));
					 model.setCheckPlace(obj.get(""));
					 model.setCheckMethod(obj.get(""));
					 model.setCheckPerson(obj.get(""));
					 if((obj.get("")).equals("2"))
					 {
						 model.setStatus("已检查"); 
					 }else{
						 model.setStatus("未检查"); 
					 }
					 if((obj.get("")) != null)
					 {
					     model.setCheckTime(obj.get(""));
					 }else{
					 }
					 model.setCheckResult(obj.get("")+"");
					 model.setUserId(obj.get("")+"");
					 listCheck.add(model);
				}
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listCheck); 
			}
			}else{
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}
			return map;
		}
	}
	
}
