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
import org.wu.work.entity.Prescription;
import org.wu.work.entity.User;
import org.wu.work.model.Mcharge;
import org.wu.work.model.Mprescription;
import org.wu.work.service.CheckService;
import org.wu.work.service.DoctorService;
import org.wu.work.service.PrescriptionService;
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
@RequestMapping(value = "/pres")
public class PrescriptionController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private PrescriptionService prescriptionService;
	@Resource
	private CheckService checkService;
	@Resource
	private DoctorService doctorService;
	
	@RequestMapping(value="/showForm")
	public ModelAndView show(String vistid,String userId,String userName){
		System.out.println("vistid= "+vistid);
		ModelAndView model = new ModelAndView("presForm");
		model.addObject("vistid",vistid);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	//展示处方单里所有的药品名及数量
	@RequestMapping(value="/showMedicine")
	public ModelAndView showMedicineList(String vistId,String userId,String userName){
		System.out.println("vistid= "+vistId);
		ModelAndView model = new ModelAndView("medicineList");
		model.addObject("vistId",vistId);
		model.addObject("userId",userId);
		model.addObject("userName",userName);
		return model;
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addPrescription(Prescription pres,int page,int pageSize,HttpSession session){
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		
		pres.setId(Sequence.nextId());
		pres.setCreateTime(new Timestamp(System.currentTimeMillis()));
		pres.setDoctorCode(doctor.getDoctorCode());
		 
		Prescription save = prescriptionService.insertPrescription(pres);
		if(save != null)
		{
			System.out.println("插入成功");
		    list = prescriptionService.queryAddPresList(page, pageSize, pres.getVistId());
		    dataNum = prescriptionService.queryDataNum(pres.getVistId());
		    System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setFufei("已缴费");
					 model.setFinish("未完成");
				 }else if((obj.get("status")).equals("2")){
					 model.setFufei("已缴费");
					 model.setFinish("已完成");
				 }else{
					 model.setFufei("未缴费");
					 model.setFinish("未完成");
				 }
				 listPres.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listPres); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//查询刚刚添加的处方表
	@RequestMapping(value="/getAddPresList")
	@ResponseBody
	public Map<String,Object> getAddPresList(int page,int pageSize,String vistId){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = prescriptionService.queryAddPresList(page, pageSize, vistId);
		List<Map<String,String>> dataNum = prescriptionService.queryDataNum(vistId);
		if(list != null)
	    {

	    	System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setFufei("已缴费");
					 model.setFinish("未完成");
				 }else if((obj.get("status")).equals("2")){
					 model.setFufei("已缴费");
					 model.setFinish("已完成");
				 }else{
					 model.setFufei("未缴费");
					 model.setFinish("未完成");
				 }
				 listPres.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listPres); 
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	//处方单管理列表
	@RequestMapping(value="/getPrescriptionList")
	@ResponseBody
	public JSONObject getPrescriptionList(int page,int pageSize,HttpSession session){
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> list = prescriptionService.queryPrescriptionList(page, pageSize,doctor.getDoctorCode());
		List<Map<String,String>> dataNum = prescriptionService.queryDataNumByCode(doctor.getDoctorCode());
		JSONObject json = new JSONObject();
		json.put("list", list);
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setFufei("已缴费");
					 model.setFinish("未完成");
				 }else if((obj.get("status")).equals("2")){
					 model.setFufei("已缴费");
					 model.setFinish("已完成");
				 }else{
					 model.setFufei("未缴费");
					 model.setFinish("未完成");
				 }
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listPres);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//初始化摆药列表
	@RequestMapping(value="/getPresList")
	@ResponseBody
	public JSONObject getPresList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<Map<String,String>> list = prescriptionService.queryPresList(page, pageSize);
		List<Map<String,String>> dataNum = prescriptionService.queryPresList();
		JSONObject json = new JSONObject();
		json.put("list", list);
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setStatus("已缴费");
				 model.setUserId(obj.get(""));
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listPres);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView queryPresDetailById(String id) {
		System.out.println(id);
		ModelAndView model = new ModelAndView("presDetail");
		Prescription pres=null;
		pres=prescriptionService.queryPrescriptionById(id);
		if(pres != null){
			System.out.println(pres.toString());
			model.addObject("flag",true);
			model.addObject("pres", pres);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	//划价收费
	@RequestMapping(value="/charge")
	@ResponseBody
	public JSONObject queryChargeItemByVistId(int page,int pageSize,String vistId,int flag) {
		JSONObject json = new JSONObject();
		List<Map<String,String>> listPres = null;
		List<Map<String,String>> listCheck = null;
	    listPres = prescriptionService.getFeeListByVistId(vistId);
		listCheck = checkService.getFeeListByVistId(vistId);
		
		List<Map<String,String>> feeP = prescriptionService.queryFeeByVistId(vistId);//处方单总费用
		List<Map<String,String>> feeC = checkService.queryFeeByVistId(vistId);//检查单总费用
		if(listPres!=null && listCheck!=null && feeP!=null && feeC!=null)
		{
	    	List<Mcharge> listCharge = new ArrayList<Mcharge>();
			Iterator<Map<String,String>> iterP = listPres.iterator();
			Iterator<Map<String,String>> iterC = listCheck.iterator();
			Iterator<Map<String,String>> iterFP = feeP.iterator();
			Iterator<Map<String,String>> iterFC = feeC.iterator();
			Mcharge model = new Mcharge();
			double Fee = 0;
			
			System.out.println("Fee "+Fee);
			while(iterP.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iterP.next();
				 model = new Mcharge();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setChargeItem(obj.get("item"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setPrice(obj.get("price"));
				 model.setItemCount((Double.parseDouble(obj.get("count"))*Double.parseDouble(obj.get("price"))+""));
				 listCharge.add(model);
			}
			//检查单
			while(iterC.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iterC.next();
				 model = new Mcharge();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setChargeItem(obj.get("item"));
				 model.setPrice(obj.get("price"));
				 model.setCount("1");
				 model.setItemCount(Double.parseDouble(obj.get("count"))+"");
				 listCharge.add(model);
			}
			if(flag == 0)
			{
				while(iterFP.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iterFP.next();
					 Fee += Double.parseDouble(obj.get(""));
					 model.setBalanceMedical(obj.get(""));
				}
				while(iterFC.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iterFC.next();
					 Fee += Double.parseDouble(obj.get(""));
					 model.setBalanceMedical(obj.get(""));
				}
			}else{
				
			}
			int dataNum = listCharge.size();
			 //分页显示
			for(int i=0;i<dataNum;i++)
			{
				if(i>=page && i<(page+pageSize))
				{
					continue;
				}else{
					listCharge.remove(0);
				}
				
			}
			
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("Fee",Fee+""); 
			json.put("balance",model.getBalanceMedical()==null?"0.0":model.getBalanceMedical()+""); 
			json.put("vistid",vistId); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum%pageSize != 0?(dataNum/pageSize+1):dataNum/pageSize); 
			json.put("dataNum",dataNum);//把检查单和处方单的数据合起来 
			json.put("list",listCharge);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	@RequestMapping(value="/baiyao")
	@ResponseBody
	public JSONObject queryPresByVistId(int page,int pageSize,String vistId) {
		
		List<Map<String,String>> list = prescriptionService.queryPresByVistId(page, pageSize,vistId);
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setStatus("已缴费");
				 }else if((obj.get("status")).equals("2")){
					 model.setStatus("已取药");
				 }else{
					 model.setStatus("未缴费");
				 }
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("list",listPres); 
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//****注意*** 这里需要获取医生编号，现在用的是固定医生编号D1003
	//处方单管理
   //通过挂号序号查找对应用户的摆药单
	@SuppressWarnings("unused")
	@RequestMapping(value="/find")
	@ResponseBody
	public JSONObject queryPresByVistIdForPresManager(int page,int pageSize,int flag,String vistId,String userId,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Doctor doctor = doctorService.queryDoctorByUserId(user.getUserName());
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		if(flag==1)
		{
			   list = prescriptionService.queryPresByVistIdForPresManagerV(page, pageSize, vistId);
			   dataNum = prescriptionService.queryDataNumByVistId(vistId, doctor.getDoctorCode());
		}else if(flag==2){
			   list = prescriptionService.queryPresByVistIdForPresManagerU(page, pageSize, userId);
			   dataNum = prescriptionService.queryDataNumByUserId(userId, doctor.getDoctorCode());
		}else if(flag==3){
			   list = prescriptionService.queryPresByVistIdForPresManagerVU(page, pageSize, vistId,userId);
			   dataNum = prescriptionService.queryDataNumByUV(userId,vistId, doctor.getDoctorCode());
		}else{
			  list = prescriptionService.queryPrescriptionList(page, pageSize,doctor.getDoctorCode());
			  dataNum = prescriptionService.queryDataNumByCode(doctor.getDoctorCode());
		}
		System.out.println("list="+list.size());
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setFufei("已缴费");
					 model.setFinish("未完成");
				 }else if((obj.get("status")).equals("2")){
					 model.setFufei("已缴费");
					 model.setFinish("已完成");
				 }else{
					 model.setFufei("未缴费");
					 model.setFinish("未完成");
				 }
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listPres);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//用户查看自己的处方单
	@SuppressWarnings("unused")
	@RequestMapping(value="/findByUser")
	@ResponseBody
	public JSONObject queryPresByUser(int page,int pageSize,int flag,String stime,String etime,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		if(flag==1)
		{
			   list = prescriptionService.queryPresByUser(page, pageSize, user.getUserName(),stime,etime);
			   dataNum = prescriptionService.queryPresByUser(user.getUserName(), stime,etime);
		}else{
			  list = prescriptionService.queryPresByUser(page, pageSize,user.getUserName());
			  dataNum = prescriptionService.queryPresByUser(user.getUserName());
		}
		System.out.println("list="+list.size());
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setFufei("已缴费");
					 model.setFinish("未完成");
				 }else if((obj.get("status")).equals("2")){
					 model.setFufei("已缴费");
					 model.setFinish("已完成");
				 }else{
					 model.setFufei("未缴费");
					 model.setFinish("未完成");
				 }
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listPres);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//药房管理
	//通过挂号序号查找对应用户的摆药单
	@SuppressWarnings("unused")
	@RequestMapping(value="/baiyaofind")
	@ResponseBody
	public JSONObject queryPresByVistIdBaiYao(int page,int pageSize,int flag,String vistId,String userId) {
		
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = prescriptionService.queryPresByVistIdBaiYao(page, pageSize, vistId);
			   dataNum = prescriptionService.queryPresByVistIdBaiYao(vistId);
		}else if(flag==2){
			   list = prescriptionService.queryPresByUserIdBaiYao(page, pageSize, userId);
			   dataNum = prescriptionService.queryPresByUserIdBaiYao(userId);
		}else if(flag==3){
			   list = prescriptionService.queryPresByVUBaiYao(page, pageSize, vistId,userId);
			   dataNum = prescriptionService.queryPresByVUBaiYao(vistId,userId);
		}else{
			   list = prescriptionService.queryPresList(page, pageSize);
			   dataNum = prescriptionService.queryPresList();
		}
		System.out.println("list="+list.size());
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 if((obj.get("status")).equals("1"))
				 {
					 model.setStatus("已缴费");
				 }else if((obj.get("status")).equals("2")){
					 model.setStatus("已取药");
				 }else{
					 model.setStatus("未缴费");
				 }
				 model.setUserId(obj.get("userId"));
				 listPres.add(model);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listPres);
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	@RequestMapping(value="/sel")
	@ResponseBody
	public Map<String,Object> queryPrescriptionById(String id) {
		Map<String,Object> map=new HashMap<String,Object>();
		Prescription pres=null;
		pres=prescriptionService.queryPrescriptionById(id);
		if(pres != null){
			System.out.println(pres.toString());
			map.put("flag",true);
			map.put("obj", pres);
		}else{
			map.put("flag",false);
		}
		return map;
	}

	//摆药员查看处方单药品列表
	@RequestMapping(value="/getMedicineList")
	@ResponseBody
	public Map<String,Object> getMedicineList(int page,int pageSize,String vistId){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> list = prescriptionService.queryMedicineList(page, pageSize, vistId);
		List<Map<String,String>> dataNum = prescriptionService.queryMedicineList(vistId);
		if(list != null)
	    {
	    	System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				  
				 listPres.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listPres);
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyPrescription(Prescription pres) {
		Map<String,Object> map=new HashMap<String,Object>();
		Prescription oldpres = prescriptionService.queryPrescriptionById(pres);
		oldpres.merge(pres);
		prescriptionService.modifyPrescription(oldpres);
		map.put("flag",true);
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deletePrescriptionById(Prescription pres,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = prescriptionService.deletePrescription(pres);
		List<Map<String,String>> list = prescriptionService.queryAddPresList(page, pageSize, pres.getVistId());
		if(flag == false || list == null){
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
		}else{
			System.out.println("list="+list.size());
	    	List<Mprescription> listPres = new ArrayList<Mprescription>();
			Iterator<Map<String,String>> iter = list.iterator();
			Mprescription model;
			while(iter.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter.next();
				 model = new Mprescription();
				 model.setId(obj.get("id"));
				 model.setVistId(obj.get("vistid"));
				 model.setUserName(obj.get("userName"));
				 model.setSex(obj.get("sex"));
				 model.setAge(obj.get("age"));
				 model.setMedicinName(obj.get("medicinName"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setCount(obj.get("count"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setCreateTime(obj.get("createTime"));
				 model.setRemark(obj.get("remark"));
				 model.setStatus(obj.get("status"));
				 if((obj.get("")).equals("1"))
				 {
					 model.setStatus("已缴费");
				 }else if((obj.get("")).equals("2")){
					 model.setStatus("已取药");
				 }else{
					 model.setStatus("未缴费");
				 }
				 listPres.add(model);
			}
			map.put("flag",true);
			map.put("status","0000");
			map.put("list",listPres);
			map.put("mes", "删除成功");
		}
		return map;
	}

	//添加处方单页面的删除操作
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(Prescription pres,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		Prescription status = prescriptionService.queryPrescriptionById(pres.getId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(3);
			Prescription flag = prescriptionService.changStatus(status);
			List<Map<String,String>> list = prescriptionService.queryAddPresList(page, pageSize, pres.getVistId());
			List<Map<String,String>> dataNum = prescriptionService.queryDataNum(pres.getVistId());
			if(flag == null || list == null){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
				System.out.println("list="+list.size());
		    	List<Mprescription> listPres = new ArrayList<Mprescription>();
				Iterator<Map<String,String>> iter = list.iterator();
				Mprescription model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new Mprescription();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setMedicinName(obj.get("medicinName"));
					 model.setMedicineSpec(obj.get("medicineSpec"));
					 model.setCount(obj.get("count"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setRemark(obj.get("remark"));
					 model.setStatus(obj.get("status"));
					 if((obj.get("")).equals("1"))
					 {
						 model.setStatus("已缴费");
					 }else if((obj.get("")).equals("2")){
						 model.setStatus("已取药");
					 }else{
						 model.setStatus("未缴费");
					 }
					 listPres.add(model);
				}
				map.put("flag",true);
				map.put("status","0000");
				map.put("currentPage",page/pageSize+1); 
			    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
			    map.put("list",listPres); 
			}
			return map;
		}
	}
		
	//处方单管理页面的删除操作
	@RequestMapping(value="/delPres")
	@ResponseBody
	public Map<String,Object> deletePres(Prescription pres,String userId,int page,int pageSize,int flag,HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		Map<String,Object> map=new HashMap<String,Object>();
		Prescription status = prescriptionService.queryPrescriptionById(pres.getId());
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			if(status.getStatus() == 0)
			{
			status.setStatus(3);
			Prescription change = prescriptionService.changStatus(status);
			if(flag==1)
			{
				   list = prescriptionService.queryPresByVistIdForPresManagerV(page, pageSize, pres.getVistId());
				   dataNum = prescriptionService.queryDataNumByVistId(pres.getVistId(), user.getUserName());
			}else if(flag==2){
				   list = prescriptionService.queryPresByVistIdForPresManagerU(page, pageSize, userId);
				   dataNum = prescriptionService.queryDataNumByUserId(userId, user.getUserName());
			}else if(flag==3){
				   list = prescriptionService.queryPresByVistIdForPresManagerVU(page, pageSize, pres.getVistId(),userId);
				   dataNum = prescriptionService.queryDataNumByUV(userId,pres.getVistId(), user.getUserName());
			}else{
				  list = prescriptionService.queryPrescriptionList(page, pageSize,user.getUserName());
				  dataNum = prescriptionService.queryDataNumByCode(user.getUserName());
			}
			if(change == null || list == null){
				map.put("flag",false);
				map.put("status","1111");
				map.put("mes", "删除失败");
			}else{
		    	List<Mprescription> listPres = new ArrayList<Mprescription>();
				Iterator<Map<String,String>> iter = list.iterator();
				Mprescription model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new Mprescription();
					 model.setId(obj.get("id"));
					 model.setVistId(obj.get("vistid"));
					 model.setUserName(obj.get("userName"));
					 model.setSex(obj.get("sex"));
					 model.setAge(obj.get("age"));
					 model.setMedicinName(obj.get("medicinName"));
					 model.setMedicineSpec(obj.get("medicineSpec"));
					 model.setCount(obj.get("count"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setCreateTime(obj.get("createTime"));
					 model.setRemark(obj.get("remark"));
					 model.setStatus(obj.get("status"));
					 if((obj.get("")).equals("1"))
					 {
						 model.setStatus("已缴费");
					 }else if((obj.get("")).equals("2")){
						 model.setStatus("已取药");
					 }else{
						 model.setStatus("未缴费");
					 }
					 listPres.add(model);
				}
				map.put("flag",true);
				map.put("status","0000");
				map.put("currentPage",page/pageSize+1); 
			    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
			    map.put("list",listPres); 
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
