package org.wu.work.controller;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.Charge;
import org.wu.work.entity.Medicine;
import org.wu.work.entity.Prescription;
import org.wu.work.model.Mmedicine;
import org.wu.work.service.ChargeService;
import org.wu.work.service.MedicineService;
import org.wu.work.service.PrescriptionService;
import org.wu.work.util.DateUtil;
import org.wu.work.util.Sequence;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/medicine")
public class MedicineController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private MedicineService medicineService;
	@Resource
	private ChargeService chargeService;
	@Resource
	private PrescriptionService prescriptionService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addMedicine(Medicine medicine,String sdate,String edate){
		Map<String,Object> map=new HashMap<String,Object>();
		medicine.setMedicineCode(Sequence.nextId());
		medicine.setMakeDate(DateUtil.now());
		medicine.setTproDate(DateUtil.parse(sdate, DateUtil.SHORT_FORMAT));
		medicine.setPeriod(DateUtil.parse(edate, DateUtil.SHORT_FORMAT));
		Medicine model = medicineService.queryMedicineByNameAndSpec(medicine.getMedicineName(),medicine.getSupplier(),medicine.getMedicineSpec());
		if( model!= null){
			model.setRepertory(Double.parseDouble(model.getRepertory()+"")+medicine.getAmount());
			Medicine save = medicineService.modifyMedicine(model);
			if(save != null)
			{
		    	map.put("flag",true);
		    	map.put("status","0000"); 
			}else{
				map.put("flag",false);
				map.put("status","1111"); 
			}
			 
		}else{
			Medicine save = medicineService.insertMedicine(medicine);
			if(save != null)
			{
		    	map.put("flag",true); 
		    	map.put("status","0000"); 
			}else{
				map.put("flag",false);
				map.put("status","1111"); 
			}
		}
		return map;
	}
	
	@RequestMapping(value="/sel")
	@ResponseBody
	public Map<String,Object> queryMedicineByCode(String code) {
		Map<String,Object> map=new HashMap<String,Object>();
		Medicine medicine=null;
		medicine=medicineService.queryMedicineByCode(code);
		if(medicine != null){
			System.out.println(medicine.toString());
			map.put("flag",true);
			map.put("obj", medicine);
		}else{
			map.put("flag",false);
		}
		return map;
	}
	
	//药品管理
	@RequestMapping(value="/find")
	@ResponseBody
	public Map<String,Object> queryMedicineByName(int page,int pageSize,String medicineName,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Medicine> list = null;
		List<Medicine> dataNum = null;
		if(flag == 1)
		{
             list=medicineService.queryMedicineByName(page,pageSize,medicineName);
		     dataNum=medicineService.queryMedicineByName(medicineName);
		}else{
		     list = medicineService.queryMedicineList(page, pageSize);
		     dataNum = medicineService.queryMedicineList();
		}
		if(list != null){
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",list); 
		}else{
			map.put("status","1111");
			map.put("flag",false);
		}
		return map;
	}

	@RequestMapping(value="/getMedicineList")
	@ResponseBody
	public JSONObject getMedicineList(int page,int pageSize){
		System.out.println("page="+page+" "+"pagesize="+pageSize);
		List<Medicine> list = medicineService.queryMedicineList(page, pageSize);
		List<Medicine> dataNum = medicineService.queryMedicineList();
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
	
	//模糊查询
	@RequestMapping(value="/findMedicineName")
	@ResponseBody
	public JSONObject findMedicineName(String name){
		System.out.println("medicineName "+name);
		List<Medicine> list = medicineService.findMedicineName(name);
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("list",list); 
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	
	//根据药品名查找药品规格
	@RequestMapping(value="/findMedicineSpec")
	@ResponseBody
	public JSONObject findMedicineSpec(String name){
		List<Medicine> list = medicineService.findMedicineSpec(name);
		JSONObject json = new JSONObject();
		if(list!=null)
		{
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("list",list); 
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	//检查处方单里的药品是否存在
	@RequestMapping(value="/findMedicineByNameAndSpec")
	@ResponseBody
	public JSONObject findMedicineByNameAndSpec(String name,String spec){
		Medicine medicine = medicineService.queryMedicineByNameAndSpec(name, spec);
		JSONObject json = new JSONObject();
		if(medicine != null)
		{
			json.put("flag",true); 
			json.put("status","0000"); 
		}else{
			json.put("flag",false); 
			json.put("status","1111"); 
		}
		return json;
	}
	//取药
	@RequestMapping(value="/quyao")
	@ResponseBody
	public Map<String,Object> quyao(String vistId) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Charge> list = chargeService.querySaleMedicineList(vistId);
	    List<Prescription>  presList =  prescriptionService.queryPresByVistId(vistId);

	    if(list != null && presList !=null)
	    {
	    	System.out.println("list="+list.size());
			Iterator<Charge> iterC = list.iterator();
			Iterator<Prescription> iterP = presList.iterator();
			while(iterC.hasNext()){
				 Charge charge = iterC.next();
				 int flag = medicineService.updateRepertory(charge.getChargeProject(), charge.getSpec(), charge.getNumber()+"");
				
				 if(flag != 0)
			     {
			    	 map.put("flag",true); 
				     map.put("status","0000"); 
			     }else{
			    	 map.put("flag",false); 
				     map.put("status","1111"); 
			    	 break;
			     }
			}
			while(iterP.hasNext()){
			     Prescription obj = iterP.next();
				 Prescription pres = prescriptionService.queryPrescriptionById(obj.getId());
				 pres.setStatus(2);
				 Prescription save = prescriptionService.modifyPrescription(pres);
				 if(save != null)
				 {
					 map.put("flag",true); 
				     map.put("status","0000"); 
				 }else{
					 map.put("flag",false); 
				     map.put("status","1111"); 
				 }
			}
			
		}else{
			map.put("flag",false); 
	    	map.put("status","1111"); 
		}
		return map;
	}
	
	
	//药品销售排行
	@RequestMapping(value="/getSaleTop")
	@ResponseBody
	public JSONObject getSaleTop(int page,int pageSize,String stime,String etime){
		List<Map<String,String>> list = medicineService.querySaleTop(page, pageSize, stime, etime);
		List<Map<String,String>> list_show = medicineService.querySaleTop(0, 10000, stime, etime);
		List<Map<String,String>> dataNum = medicineService.querySaleTop(stime, etime);
		JSONObject json = new JSONObject();
		if(list != null && list_show!= null)
		{
			List<Mmedicine> saleTop = new ArrayList<Mmedicine>();
			JSONArray jsonArr = new JSONArray();
			JSONObject jo = null;
			 
			Iterator<Map<String,String>> iter = list.iterator();
			Iterator<Map<String,String>> iter_show = list_show.iterator();//柱状图展示数据
			Mmedicine model = null;
			while(iter.hasNext()){
				 Map<String,String> obj = iter.next();
				 model = new Mmedicine();
				 jo = new JSONObject();
				 model.setMedicineName(obj.get("medicineName"));
				 model.setSupplier(obj.get("supplier"));
				 model.setMedicineSpec(obj.get("medicineSpec"));
				 model.setPrice(obj.get("price"));
				 model.setRepertory(obj.get("repertory"));
				 model.setSales(obj.get("sale"));
				 saleTop.add(model);
			}
			while(iter_show.hasNext()){
				 Map<String,String> obj = (Map<String,String>)iter_show.next();
				 jo = new JSONObject();
				 jo.put("name", obj.get("medicineName"));
				 jo.put("value", obj.get("sale"));
				 jsonArr.add(jo);
			}
			json.put("flag",true); 
			json.put("status","0000"); 
			json.put("currentPage",page/pageSize+1); 
			json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			json.put("dataNum",dataNum.size()); 
			json.put("list",saleTop); 
			json.put("data",jsonArr); 
		}else{
			json.put("flag",false); 
			json.put("status","1111");
		}
	
		return json;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView queryMedicineDetailByCode(String code) {
		ModelAndView model = new ModelAndView("medicineDetail");
		Medicine medicine=null;
		medicine=medicineService.queryMedicineByCode(code);
		if(medicine != null){
			System.out.println(medicine.toString());
			model.addObject("flag",true);
			model.addObject("medicine", medicine);
			 if(medicine.getTproDate() != null)
			 {
				 model.addObject("proDate", DateUtil.formatDateShort(medicine.getTproDate()));
			 }else{
			 }
			 if(medicine.getPeriod() != null)
			 {
				 model.addObject("period", DateUtil.formatDateShort(medicine.getPeriod()));
			 }else{
				
			 }
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyMedicine(Medicine medicine,String sdate,String edate) {
		Map<String,Object> map=new HashMap<String,Object>();
		    medicine.setTproDate(DateUtil.parse(sdate, DateUtil.SHORT_FORMAT));
		    medicine.setPeriod(DateUtil.parse(edate, DateUtil.SHORT_FORMAT));
			Medicine oldmedicine = medicineService.queryMedicineByCode(medicine.getMedicineCode());
			oldmedicine.merge(medicine);
			Medicine save = medicineService.modifyMedicine(oldmedicine);
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
	public Map<String,Object> deleteMedicineById(Medicine medicine,int page,int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = medicineService.deleteMedicine(medicine);
		List<Medicine> list = medicineService.queryMedicineList(page, pageSize);
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
	public Map<String,Object> changStatusById(Medicine medicine,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Medicine> list = null;
		List<Medicine> dataNum = null;
		Medicine status = medicineService.queryMedicineByCode(medicine.getMedicineCode());
		if(status == null)
		{
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			Medicine change = medicineService.changStatus(status);
			if(flag == 1)
			{
	             list=medicineService.queryMedicineByName(page,pageSize,medicine.getMedicineName());
			     dataNum=medicineService.queryMedicineByName(medicine.getMedicineName());
			}else{
			     list = medicineService.queryMedicineList(page, pageSize);
			     dataNum = medicineService.queryMedicineList();
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
