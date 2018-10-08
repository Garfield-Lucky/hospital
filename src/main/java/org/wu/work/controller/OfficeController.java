package org.wu.work.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.Office;
import org.wu.work.service.OfficeService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/office")
public class OfficeController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	
	@Resource
	private OfficeService officeService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addOffice(Office office){
		Map<String,Object> map=new HashMap<String,Object>();
		
		if(officeService.queryOfficeByCode(office.getOfficeCode()) != null){
			System.out.println("此科室编号已存在！");
			map.put("flag",false);
			map.put("num","1");
			map.put("msg", "此科室编号已存在！");
		}else{
			Office save = officeService.insertOffice(office);
			if(save != null)
			{
		    	map.put("flag",true); 
			}
		}
		return map;
	}

	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryOfficeByCode(int page,int pageSize,int flag,String officeCode,String officeType) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Office> list = null;
		List<Office> dataNum = null;
	 
		if(flag==1)
		{
			   list = officeService.queryOfficeByCode(page, pageSize,officeCode);
			   dataNum = officeService.queryDataNumByCode(officeCode);
		}else if(flag==2){
			   list = officeService.queryOfficeByType(page, pageSize,officeType);
			   dataNum = officeService.queryDataNumByType(officeType);
		}else if(flag==3){
			   list = officeService.queryOfficeByCode(page, pageSize,officeCode);
			   dataNum = officeService.queryDataNumByCode(officeCode);
		}else{
			   list = officeService.queryOfficeList(page, pageSize);
			   dataNum = officeService.queryDataNum();
		}
		
		if(list == null){
			map.put("flag",false);
			map.put("status","1111");
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
	
	
	@RequestMapping(value="/getOfficeList")
	@ResponseBody
	public JSONObject getOfficeList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<Office> list = officeService.queryOfficeList(page, pageSize);
		List<Office> dataNum = officeService.queryDataNum();
		JSONObject json = new JSONObject();
		json.put("list", list);
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
	public ModelAndView queryOfficeDetailById(int id) {
		System.out.println(id);
		ModelAndView model = new ModelAndView("officeDetail");
		Office office=null;
		office=officeService.queryOfficeById(id);
		if(office != null){
			System.out.println(office.toString());
			model.addObject("flag",true);
			model.addObject("office", office);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyoffice(Office office) {
		Map<String,Object> map=new HashMap<String,Object>();
		
			Office olduser = officeService.queryOfficeById(office.getId());
			olduser.merge(office);
			Office save = officeService.modifyoffice(olduser);
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
	public Map<String,Object> deleteOfficeById(Office office,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = officeService.deleteOffice(office);
		List<Office> list = officeService.queryOfficeList(page, pageSize);
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
	public Map<String,Object> changStatusById(Office office,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		Office status = officeService.queryOfficeByCode(office.getOfficeCode());
		List<Office> dataNum = null;
		List<Office> list = null;
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			Office change = officeService.changStatus(status);
			if(flag==1)
			{
				   list = officeService.queryOfficeByCode(page, pageSize,office.getOfficeCode());
				   dataNum = officeService.queryDataNumByCode(office.getOfficeCode());
			}else if(flag==2){
				   list = officeService.queryOfficeByType(page, pageSize,office.getOfficeType());
				   dataNum = officeService.queryDataNumByType(office.getOfficeType());
			}else if(flag==3){
				   list = officeService.queryOfficeByCode(page, pageSize,office.getOfficeCode());
				   dataNum = officeService.queryDataNumByCode(office.getOfficeCode());
			}else{
				   list = officeService.queryOfficeList(page, pageSize);
				   dataNum = officeService.queryDataNum();
			}
			if(change == null || list == null){
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
