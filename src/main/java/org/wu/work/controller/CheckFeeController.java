package org.wu.work.controller;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.CheckFee;
import org.wu.work.service.CheckFeeService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/checkFee")
public class CheckFeeController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private CheckFeeService checkFeeService;
	
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addCheckFee(CheckFee check){
		Map<String,Object> map=new HashMap<String,Object>();
		    if(checkFeeService.queryCheckFeeByCode(check.getCheckCode()) != null){
				System.out.println("此项目编号已存在！");
				map.put("flag",false);
				map.put("msg", "此项目编号已存在！");
			}else{
				 CheckFee save = checkFeeService.insertCheckFee(check);
				 if(save != null)
				 {
				  System.out.println("插入成功");
		    	  map.put("flag",true); 
				 }
			}
		
		return map;
	}
	

	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryCheckFeeByCode(int page,int pageSize,int flag,String checkCode,String checkItem) {
		Map<String,Object> map=new HashMap<String,Object>();

		List<CheckFee> list = null;
		List<CheckFee> dataNum = null;
		if(flag==1)
		{
			   list = checkFeeService.queryCheckFeeByCode(page, pageSize, checkCode);
			   dataNum = checkFeeService.queryDataNumByCode(checkCode);
		}else if(flag==2){
			   list = checkFeeService.queryCheckFeeByType(page, pageSize, checkItem);
			   dataNum = checkFeeService.queryDataNumByName(checkItem);
		}else if(flag==3){
			   list = checkFeeService.queryCheckFeeByCode(page, pageSize, checkCode);
			   dataNum = checkFeeService.queryDataNumByCode(checkCode);
		}else{
			   list = checkFeeService.queryCheckFeeList(page, pageSize);
			   dataNum = checkFeeService.queryDataNum();
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
	
	
	@RequestMapping(value="/getCheckFeeList")
	@ResponseBody
	public JSONObject getCheckFeeList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<CheckFee> list = checkFeeService.queryCheckFeeList(page, pageSize);
		List<CheckFee> dataNum = checkFeeService.queryDataNum();
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
	public ModelAndView queryCheckFeeDetailByCode(String code) {
		System.out.println(code);
		ModelAndView model = new ModelAndView("checkFeeDetail");
		CheckFee checkFee=null;
		checkFee=checkFeeService.queryCheckFeeByCode(code);
		if(checkFee != null){
			System.out.println(checkFee.toString());
			model.addObject("flag",true);
			model.addObject("checkFee", checkFee);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyCheckFee(CheckFee check) {
		Map<String,Object> map=new HashMap<String,Object>();
		CheckFee oldcheck = checkFeeService.queryCheckFeeByCode(check.getCheckCode());
		oldcheck.merge(check);
		checkFeeService.modifyCheckFee(oldcheck);
		map.put("flag",true); 
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> changStatusByCode(CheckFee check,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = checkFeeService.deleteCheckFee(check);
		List<CheckFee> list = checkFeeService.queryCheckFeeList(page, pageSize);
		if(flag == false || list == null){
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
	public Map<String,Object> deleteCheckByCode(CheckFee check,int page,int pageSize,int flag) {
		System.out.println("CheckCode:"+check.getCheckCode());
		Map<String,Object> map=new HashMap<String,Object>();
		CheckFee status = checkFeeService.queryCheckFeeByCode(check.getCheckCode());
		List<CheckFee> dataNum = null;
		List<CheckFee> list = null;
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			 status.setStatus(1);
			 CheckFee change = checkFeeService.changStatus(status);
			 list = checkFeeService.queryCheckFeeList(page, pageSize);
				if(flag==1)
				{
					   list = checkFeeService.queryCheckFeeByCode(page, pageSize, check.getCheckCode());
					   dataNum = checkFeeService.queryDataNumByCode(check.getCheckCode());
				}else if(flag==2){
					   list = checkFeeService.queryCheckFeeByType(page, pageSize, check.getCheckItem());
					   dataNum = checkFeeService.queryDataNumByName(check.getCheckItem());
				}else if(flag==3){
					   list = checkFeeService.queryCheckFeeByCode(page, pageSize, check.getCheckCode());
					   dataNum = checkFeeService.queryDataNumByCode(check.getCheckCode());
				}else{
					   list = checkFeeService.queryCheckFeeList(page, pageSize);
					   dataNum = checkFeeService.queryDataNum();
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
