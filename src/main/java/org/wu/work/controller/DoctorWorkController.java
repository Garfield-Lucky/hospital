package org.wu.work.controller;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.DoctorWork;
import org.wu.work.model.MdoctorWork;
import org.wu.work.service.DoctorWorkService;
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
@RequestMapping(value = "/doctorWork")
public class DoctorWorkController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private DoctorWorkService doctorWorkService;
	
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addDoctorWork(DoctorWork work,String date){
		Map<String,Object> map=new HashMap<String,Object>();
		  work.setId(Sequence.nextId());
		  work.setWorkDate(DateUtil.parse(date, DateUtil.SHORT_FORMAT));
		 DoctorWork save = doctorWorkService.insertDoctorWork(work);
			if(save != null)
			{
				System.out.println("插入成功");
		    	map.put("flag",true); 
			}
		
		return map;
	}
	
//管理员根据不同条件查询值班安排列表
	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryDoctorWorkByCode(int page,int pageSize,int flag,MdoctorWork work) {
		JSONObject json = new JSONObject();
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		if(flag==1)
		{
			   list = doctorWorkService.queryDoctorWorkByD(page, pageSize, work.getDoctorCode());
			   dataNum = doctorWorkService.queryDataNumByD(work.getDoctorCode());
		}else if(flag==2){
			   list = doctorWorkService.queryDoctorWorkByR(page, pageSize, work.getRegisterCount());
			   dataNum = doctorWorkService.queryDataNumByR(work.getRegisterCount());
		}else if(flag==3){
			   list = doctorWorkService.queryDoctorWorkByW(page, pageSize, work.getWorkDate());
			   dataNum = doctorWorkService.queryDataNumByW(work.getWorkDate());
		}else if(flag==4){
			   list = doctorWorkService.queryDoctorWorkByT(page, pageSize, work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByT(work.getWorkTime());
		}else if(flag==5){
			   list = doctorWorkService.queryDoctorWorkByRW(page, pageSize, work.getRegisterCount(),work.getWorkDate());
			   dataNum = doctorWorkService.queryDataNumByRW(work.getRegisterCount(),work.getWorkDate());
		}else if(flag==6){
			   list = doctorWorkService.queryDoctorWorkByRT(page, pageSize, work.getRegisterCount(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByRT(work.getRegisterCount(),work.getWorkTime());
		}else if(flag==7){
			   list = doctorWorkService.queryDoctorWorkByWT(page, pageSize, work.getWorkDate(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByWT(work.getWorkDate(),work.getWorkTime());
		}else if(flag==8){
			   list = doctorWorkService.queryDoctorWorkByDR(page, pageSize, work.getDoctorCode(),work.getRegisterCount());
			   dataNum = doctorWorkService.queryDataNumByDR(work.getDoctorCode(),work.getRegisterCount());
		}else if(flag==9){
			   list = doctorWorkService.queryDoctorWorkByDW(page, pageSize, work.getDoctorCode(),work.getWorkDate());
			   dataNum = doctorWorkService.queryDataNumByDW(work.getDoctorCode(),work.getWorkDate());
		}else if(flag==10){
			   list = doctorWorkService.queryDoctorWorkByDT(page, pageSize, work.getDoctorCode(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByDT(work.getDoctorCode(),work.getWorkTime());
		}else if(flag==11){
			   list = doctorWorkService.queryDoctorWorkByDRW(page, pageSize, work.getDoctorCode(),work.getRegisterCount(),work.getWorkDate());
			   dataNum = doctorWorkService.queryDataNumByDRW(work.getDoctorCode(),work.getRegisterCount(),work.getWorkDate());
		}else if(flag==12){
			   list = doctorWorkService.queryDoctorWorkByDRT(page, pageSize, work.getDoctorCode(),work.getRegisterCount(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByDRT(work.getDoctorCode(),work.getRegisterCount(),work.getWorkTime());
		}else if(flag==13){
			   list = doctorWorkService.queryDoctorWorkByDWT(page, pageSize, work.getDoctorCode(),work.getWorkDate(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByDWT(work.getDoctorCode(),work.getWorkDate(),work.getWorkTime());
		}else if(flag==14){
			   list = doctorWorkService.queryDoctorWorkByRWT(page, pageSize, work.getRegisterCount(),work.getWorkDate(),work.getWorkTime());
			   dataNum = doctorWorkService.queryDataNumByRWT(work.getRegisterCount(),work.getWorkDate(),work.getWorkTime());
		}else{
			   list = doctorWorkService.queryDoctorWorkList(page, pageSize);
			   dataNum = doctorWorkService.queryDataNum();
		}
		
		if(list!=null)
		{
			List<MdoctorWork> listWork = new ArrayList<MdoctorWork>();
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model;
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				 model = new MdoctorWork();
				 model.setId(obj.get("id"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setRegisterCount(obj.get("registerCount"));
				 model.setReaminCount(obj.get("reaminCount"));
				 
				 listWork.add(model);
			    }
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",listWork); 
		}else{
		  json.put("flag",false);
		  json.put("status", "1111");
		}
		return json;
	}
	
	
	@RequestMapping(value="/getDoctorWorkList")
	@ResponseBody
	public JSONObject getOfficeList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<Map<String,String>> list = doctorWorkService.queryDoctorWorkList(page, pageSize);
		List<Map<String,String>> dataNum = doctorWorkService.queryDataNum();
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			List<MdoctorWork> listWork = new ArrayList<MdoctorWork>();
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model;
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				 model = new MdoctorWork();
				 model.setId(obj.get("id"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setRegisterCount(obj.get("registerCount"));
				 model.setReaminCount(obj.get("reaminCount"));
				 
				 listWork.add(model);
			    }
			 json.put("flag",true); 
			 json.put("status","0000"); 
			 json.put("currentPage",page/pageSize+1); 
			 json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			 json.put("dataNum",dataNum.size()); 
			 json.put("list",listWork); 
		}else{
		  json.put("flag",false);
		  json.put("status", "1111");
		}
		return json;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView queryOfficeDetailById(String id) {
		System.out.println(id);
		ModelAndView model = new ModelAndView("doctorWorkDetail");
		DoctorWork work=null;
		work=doctorWorkService.queryDoctorWorkById(id);
		if(work != null){
			System.out.println(work.toString());
			model.addObject("flag",true);
			model.addObject("doctor", work);
			model.addObject("workDate",DateUtil.formatDateShort(work.getWorkDate()));
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyDoctorWork(DoctorWork work,String date) {
		Map<String,Object> map=new HashMap<String,Object>();
		work.setWorkDate(DateUtil.parse(date, DateUtil.SHORT_FORMAT));
		DoctorWork oldwork = doctorWorkService.queryDoctorWorkById(work.getId());
		oldwork.merge(work);
		System.out.println(work.toString());
		DoctorWork save = doctorWorkService.modifyDoctorWork(oldwork);
		if(save != null)
		{
		    map.put("flag",true); 
		}else{
			map.put("flag",false); 
		}
		return map;
	}
	
	
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> changStatusById(DoctorWork work,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = doctorWorkService.deleteDoctorWork(work);
		List<Map<String,String>> list = doctorWorkService.queryDoctorWorkList(page, pageSize);
		if(list != null && flag != false)
		{
			List<MdoctorWork> listWork = new ArrayList<MdoctorWork>();
			Iterator<Map<String,String>> iter = list.iterator();
			MdoctorWork model;
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				 model = new MdoctorWork();
				 model.setId(obj.get("id"));
				 model.setDoctorCode(obj.get("doctorCode"));
				 model.setDoctorName(obj.get("doctorName"));
				 model.setOfficeType(obj.get("officeType"));
				 model.setWorkDate(obj.get("workDate"));
				 model.setWorkTime(obj.get("workTime"));
				 model.setRegisterCount(obj.get("registerCount"));
				 model.setReaminCount(obj.get("reaminCount"));
				 
				 listWork.add(model);
			    }
			map.put("flag",true);
			map.put("status", "0000");
			map.put("list", listWork);
		}else{
			map.put("flag",false);
			map.put("status", "1111");
		}
		return map;
	}
	
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> deleteCheckById(MdoctorWork work,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		DoctorWork status = doctorWorkService.queryDoctorWorkById(work.getId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			DoctorWork change = doctorWorkService.changStatus(status);
			if(flag==1)
			{
				   list = doctorWorkService.queryDoctorWorkByD(page, pageSize, work.getDoctorCode());
				   dataNum = doctorWorkService.queryDataNumByD(work.getDoctorCode());
			}else if(flag==2){
				   list = doctorWorkService.queryDoctorWorkByR(page, pageSize, work.getRegisterCount());
				   dataNum = doctorWorkService.queryDataNumByR(work.getRegisterCount());
			}else if(flag==3){
				   list = doctorWorkService.queryDoctorWorkByW(page, pageSize, work.getWorkDate());
				   dataNum = doctorWorkService.queryDataNumByW(work.getWorkDate());
			}else if(flag==4){
				   list = doctorWorkService.queryDoctorWorkByT(page, pageSize, work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByT(work.getWorkTime());
			}else if(flag==5){
				   list = doctorWorkService.queryDoctorWorkByRW(page, pageSize, work.getRegisterCount(),work.getWorkDate());
				   dataNum = doctorWorkService.queryDataNumByRW(work.getRegisterCount(),work.getWorkDate());
			}else if(flag==6){
				   list = doctorWorkService.queryDoctorWorkByRT(page, pageSize, work.getRegisterCount(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByRT(work.getRegisterCount(),work.getWorkTime());
			}else if(flag==7){
				   list = doctorWorkService.queryDoctorWorkByWT(page, pageSize, work.getWorkDate(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByWT(work.getWorkDate(),work.getWorkTime());
			}else if(flag==8){
				   list = doctorWorkService.queryDoctorWorkByDR(page, pageSize, work.getDoctorCode(),work.getRegisterCount());
				   dataNum = doctorWorkService.queryDataNumByDR(work.getDoctorCode(),work.getRegisterCount());
			}else if(flag==9){
				   list = doctorWorkService.queryDoctorWorkByDW(page, pageSize, work.getDoctorCode(),work.getWorkDate());
				   dataNum = doctorWorkService.queryDataNumByDW(work.getDoctorCode(),work.getWorkDate());
			}else if(flag==10){
				   list = doctorWorkService.queryDoctorWorkByDT(page, pageSize, work.getDoctorCode(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByDT(work.getDoctorCode(),work.getWorkTime());
			}else if(flag==11){
				   list = doctorWorkService.queryDoctorWorkByDRW(page, pageSize, work.getDoctorCode(),work.getRegisterCount(),work.getWorkDate());
				   dataNum = doctorWorkService.queryDataNumByDRW(work.getDoctorCode(),work.getRegisterCount(),work.getWorkDate());
			}else if(flag==12){
				   list = doctorWorkService.queryDoctorWorkByDRT(page, pageSize, work.getDoctorCode(),work.getRegisterCount(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByDRT(work.getDoctorCode(),work.getRegisterCount(),work.getWorkTime());
			}else if(flag==13){
				   list = doctorWorkService.queryDoctorWorkByDWT(page, pageSize, work.getDoctorCode(),work.getWorkDate(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByDWT(work.getDoctorCode(),work.getWorkDate(),work.getWorkTime());
			}else if(flag==14){
				   list = doctorWorkService.queryDoctorWorkByRWT(page, pageSize, work.getRegisterCount(),work.getWorkDate(),work.getWorkTime());
				   dataNum = doctorWorkService.queryDataNumByRWT(work.getRegisterCount(),work.getWorkDate(),work.getWorkTime());
			}else{
				   list = doctorWorkService.queryDoctorWorkList(page, pageSize);
				   dataNum = doctorWorkService.queryDataNum();
			}
			if(list != null && change != null)
			{
				List<MdoctorWork> listWork = new ArrayList<MdoctorWork>();
				Iterator<Map<String,String>> iter = list.iterator();
				MdoctorWork model;
				while(iter.hasNext()){
					Map<String,String> obj = iter.next();
					 model = new MdoctorWork();
					 model.setId(obj.get("id"));
					 model.setDoctorCode(obj.get("doctorCode"));
					 model.setDoctorName(obj.get("doctorName"));
					 model.setOfficeType(obj.get("officeType"));
					 model.setWorkDate(obj.get("workDate"));
					 model.setWorkTime(obj.get("workTime"));
					 model.setRegisterCount(obj.get("registerCount"));
					 model.setReaminCount(obj.get("reaminCount"));
					 listWork.add(model);
				    }
				map.put("flag",true);
				map.put("status","0000");
				map.put("currentPage",page/pageSize+1); 
			    map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
			    map.put("list",listWork); 
			}else{
				map.put("flag",false);
				map.put("status", "1111");
			}
			return map;
		}
	}

	
}
