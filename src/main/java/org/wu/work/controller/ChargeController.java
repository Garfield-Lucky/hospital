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
import org.wu.work.entity.Charge;
import org.wu.work.entity.Check;
import org.wu.work.entity.Patient;
import org.wu.work.entity.Prescription;
import org.wu.work.entity.Register;
import org.wu.work.entity.User;
import org.wu.work.model.Mcharge;
import org.wu.work.model.MchargeCount;
import org.wu.work.service.ChargeService;
import org.wu.work.service.CheckService;
import org.wu.work.service.PatientService;
import org.wu.work.service.PrescriptionService;
import org.wu.work.service.RegisterService;
import org.wu.work.util.DateUtil;
import org.wu.work.util.Sequence;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/charge")
public class ChargeController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@Resource
	private ChargeService chargeService;
	@Resource
	private PrescriptionService prescriptionService;
	@Resource
	private CheckService checkService;
	@Resource
	private PatientService patientService;
	@Resource
	private RegisterService registerService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addCharge(String vistId,int payType,double allFee,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		if(payType == 1)
		{
			Register register = registerService.queryRegisterById(vistId);
			Patient patient=patientService.queryPatientById(register.getUserId());
			if(allFee == 0)
			{
				map.put("msg","没有收费项目"); 
			}
			if((patient.getBalanceMedical()-allFee) >= 0)
	    	{
	    		patient.setBalanceMedical(patient.getBalanceMedical()-allFee);
	    		Patient save = patientService.modifyPatient(patient);
	    		if(save != null){
	    			 System.out.println("扣费成功");
	    			 map.put("balance",patient.getBalanceMedical()); 
	    		}else{
	    			System.out.println("扣费失败");
	    			map.put("flag",false); 
					map.put("msg","扣费失败"); 
					map.put("balance",patient.getBalanceMedical()); 
					return map;
	    		}
	    		
	    	}else{
	    		map.put("flag",false); 
				map.put("msg","账户余额不足"); 
				return map;
	    	}
		}else{
			if(allFee == 0)
			{
				map.put("msg","没有收费项目"); 
			}
			System.out.println("现金支付");
		}
		
			List<Map<String,String>> listPres = prescriptionService.queryFeeListByVistId(vistId);
			List<Map<String,String>> listCheck = checkService.queryFeeListByVistId(vistId);
			Charge charge = null;
			if(listPres!=null && listCheck!=null)
			{
				Iterator<Map<String,String>> iterP = listPres.iterator();
				Iterator<Map<String,String>> iterC = listCheck.iterator();
				while(iterP.hasNext()){
					 Map<String,String> obj = iterP.next();
					 charge = new Charge();
					 charge.setChargeId(Sequence.nextId());
					 charge.setUserName(obj.get("userName"));
					 charge.setChargeProject(obj.get("medicinName"));
					 charge.setSpec(obj.get("medicineSpec"));
					 charge.setItemType(0);
					 charge.setNumber(Double.parseDouble(obj.get("count")));
					 charge.setPrice(Double.parseDouble(obj.get("price")));
					 //公共部分
					 charge.setCreateTime(new Timestamp(System.currentTimeMillis()));
				     charge.setCashier(user.getTrueName());
					 charge.setVistId(vistId);
					 charge.setStatus(0);
					 Charge save = chargeService.insertCharge(charge);
						if(save != null)
						{
							Prescription status = prescriptionService.queryPrescriptionById(obj.get("id"));
							status.setStatus(1);
							Prescription flag = prescriptionService.changStatus(status);
							if(flag != null)
							{
							   map.put("flag",true); 
					    	   map.put("status","0000"); 
					    	   map.put("msg","划价成功"); 
							}else{
							   map.put("flag",false); 
							   map.put("status","1111"); 
							   map.put("msg","划价失败"); 
							}
						}else{
							map.put("flag",false); 
							map.put("status","1111"); 
						    map.put("msg","划价失败"); 
							break;
						}
				}
				
				while(iterC.hasNext()){
					Map<String,String> obj = iterC.next();
					 charge = new Charge();
					 charge.setChargeId(Sequence.nextId());
					 charge.setUserName(obj.get("userName"));
					 charge.setChargeProject(obj.get("checkType"));
					 charge.setSpec("");
					 charge.setItemType(1);
					 charge.setNumber(1.0);
					 charge.setPrice(Double.parseDouble(obj.get("expend")));
					 
					//公共部分
					 charge.setCreateTime(new Timestamp(System.currentTimeMillis()));
				     charge.setCashier(user.getTrueName());
					 charge.setVistId(vistId);
					 charge.setStatus(0);
					 //插入数据库
					 Charge save = chargeService.insertCharge(charge);
						if(save != null)
						{
							Check status = checkService.queryCheckById(obj.get("id"));
							status.setStatus(1);
							Check flag = checkService.changStatus(status);
							if(flag != null)
							{
					    	    map.put("flag",true); 
					    	    map.put("status","0000"); 
					    	    map.put("msg","划价成功"); 
							}else{
							    map.put("flag",false); 
							    map.put("status","1111"); 
							    map.put("msg","划价失败"); 
							}
						}else{
							 map.put("flag",false); 
							 map.put("status","1111"); 
							 map.put("msg","划价失败"); 
							break;
						}
				}
			}
		
		
		return map;
	}
	
	//结算
	@RequestMapping(value="/clearing")
	@ResponseBody
	public Map<String,Object> clearingByStimeAndEtime(String stime,String etime,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user = (User)session.getAttribute("userInfo");
		List<MchargeCount> clearing = new ArrayList<MchargeCount>();
		List<Map<String,String>> list=chargeService.queryChargeByTime(stime, etime);
		if(list != null){
			Iterator<Map<String,String>> iter = list.iterator();
			MchargeCount model = new MchargeCount();
			model.setClerk(user.getTrueName());
			double medicineCategory = 0;
			double checkCategory = 0;
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				if((obj.get("itemType")).equals("0"))
				{
					medicineCategory += Double.parseDouble(obj.get("number"))* Double.parseDouble(obj.get("price"));
				}else if((obj.get("itemType")).equals("1")){
					checkCategory += Double.parseDouble(obj.get("number"))* Double.parseDouble(obj.get("price"));
				}
				
			}
			model.setStime(stime);
			model.setEtime(etime);
			model.setTime(DateUtil.formatDate(new Date()));
			model.setMedicineCategory(medicineCategory+"");
			model.setCheckCategory(checkCategory+"");
			model.setTotal((Double.parseDouble(model.getCheckCategory())+Double.parseDouble(model.getMedicineCategory()))+"");
			clearing.add(model);
			map.put("flag",false);
			map.put("status","0000");
			map.put("list",clearing);
		}else{
			map.put("flag",false);
			map.put("status","1111");
		}
		return map;
	}
	
	//账单管理
	@RequestMapping(value="/billManager")
	@ResponseBody
	public Map<String,Object> billManager( int page,int pageSize,int flag,String stime,String etime,String vistId) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> listBill =  null;
		List<Map<String,String>> dataNum =  null;
		if(flag == 1)
		{
			listBill = chargeService.queryBillByTime(page, pageSize, stime, etime);
			dataNum = chargeService.queryDataNumByTime(stime, etime);
		}else if(flag == 2){
			listBill = chargeService.queryBillByVistId(page, pageSize, vistId);
			dataNum = chargeService.queryDataNumByVistId(vistId);
		}else if(flag == 3){
			listBill = chargeService.queryBillByVSE(page, pageSize, vistId, stime, etime);
			dataNum = chargeService.queryDataNumByVSE(vistId, stime, etime);
		}
		
		if(listBill != null)
		{
			List<Mcharge> listCharge = new ArrayList<Mcharge>();
			Iterator<Map<String,String>> iter = listBill.iterator();
			Mcharge model = new Mcharge();
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				 model = new Mcharge();
				 model.setVistId(obj.get("vistId"));
				 model.setClerk(obj.get("cashier"));
				 model.setUserName(obj.get("userName"));
				 model.setChargeItem(obj.get("chargeProject"));
				 model.setMedicineSpec(obj.get("spec"));
				 model.setCount(obj.get("number"));
				 model.setPrice(obj.get("price"));
				 model.setCreateTime(obj.get("createTime"));
			     model.setItemCount((Double.parseDouble(obj.get("NUMBER"))*Double.parseDouble(obj.get("PRICE")))+"");
				 listCharge.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listCharge); 
		}else{
			map.put("flag",false); 
			map.put("status","1111");
		}
	
		return map;
	}
	
	//统计汇总
	@RequestMapping(value="/countManager")
	@ResponseBody
	public Map<String,Object> countManager(int page,int pageSize,int flag,String stime,String etime,String vistId,String clerk) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> listBill =  null;
		if(flag == 1)
		{
			listBill = chargeService.queryCountByTime(page, pageSize, stime, etime);
		}else if(flag == 2){
			listBill = chargeService.queryCountByClerk(clerk);
		}else if(flag == 3){
			listBill = chargeService.queryCountByTimeAndClerk(stime, etime, clerk);
		
		}
		
		if(listBill != null)
		{
			List<MchargeCount> listCount = new ArrayList<MchargeCount>();
			Iterator<Map<String,String>> iter = listBill.iterator();
			MchargeCount model = null;
			while(iter.hasNext()){
				 Map<String,String> obj = iter.next();
				 model = new MchargeCount();
				 model.setClerk(obj.get("cashier"));
				 model.setTotal(obj.get("num"));
				 model.setStime(stime);
				 model.setEtime(etime);
				 listCount.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",listBill.size()%pageSize != 0?(listBill.size()/pageSize+1):listBill.size()/pageSize); 
			map.put("dataNum",listBill.size()); 
			map.put("list",listCount); 
		}else{
			map.put("flag",false); 
			map.put("status","1111");
		}
	
		return map;
	}
	
	//账单明细
	@RequestMapping(value="/detail")
	public ModelAndView showMedicineList(String stime,String etime,String clerk){
		ModelAndView model = new ModelAndView("billList");
		model.addObject("stime",stime);
		model.addObject("etime",etime);
		model.addObject("clerk",clerk);
		return model;
	}
	
	//查看明细账单列表
	@RequestMapping(value="/findBillList")
	@ResponseBody
	public Map<String,Object> findBillList(int page,int pageSize,String stime,String etime,String clerk) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> listBill =  null;
		List<Map<String,String>> dataNum =  null;
		listBill = chargeService.findBillList(page, pageSize, stime, etime, clerk);
		dataNum  = chargeService.queryDataNum(stime, etime, clerk);
		if(listBill != null)
		{
			List<Mcharge> listCharge = new ArrayList<Mcharge>();
			Iterator<Map<String,String>> iter = listBill.iterator();
			Mcharge model = new Mcharge();
			while(iter.hasNext()){
				 Map<String,String> obj = iter.next();
				 model = new Mcharge();
				 model.setVistId(obj.get("vistId"));
				 model.setClerk(obj.get("cashier"));
				 model.setUserName(obj.get("userName"));
				 model.setChargeItem(obj.get("chargeProject"));
				 model.setMedicineSpec(obj.get("spec"));
				 model.setCount(obj.get("number"));
				 model.setPrice(obj.get("price"));
				 model.setCreateTime(obj.get("createTime"));
			     model.setItemCount((Double.parseDouble(obj.get("number"))*Double.parseDouble(obj.get("price")))+"");
				 listCharge.add(model);
			}
			map.put("flag",true); 
			map.put("status","0000"); 
			map.put("currentPage",page/pageSize+1); 
			map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
			map.put("dataNum",dataNum.size()); 
			map.put("list",listCharge); 
		}else{
			map.put("flag",false); 
			map.put("status","1111");
		}
	
		return map;
	}
	
	@RequestMapping(value="/sel")
	@ResponseBody
	public Map<String,Object> queryChargeById(String id) {
		Map<String,Object> map=new HashMap<String,Object>();
		Charge charge=null;
		charge=chargeService.queryChargeById(id);
		if(charge != null){
			System.out.println(charge.toString());
			map.put("flag",true);
			map.put("obj", charge);
		}else{
			map.put("flag",false);
		}
		return map;
	}

	//充值中心
	@RequestMapping(value="/voucherCenter")
	@ResponseBody
	public Map<String,Object> voucherCenter(String userId,double money) {
		Map<String,Object> map=new HashMap<String,Object>();
		Patient patient=null;
		patient=patientService.queryPatientById(userId);
		if(patient != null){
			patient.setBalanceMedical(patient.getBalanceMedical()+money);
			Patient save = patientService.modifyPatient(patient);
			if(save != null)
			{
				map.put("flag",true);
				map.put("status","0000");
			}else{
				map.put("flag",false);
				map.put("status","1111");
			}
		}else{
			map.put("flag",false);
			map.put("status","1111");
		}
		return map;
	}
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyCharge(Charge charge) {
		Map<String,Object> map=new HashMap<String,Object>();
		Charge oldcheck = chargeService.queryChargeById(charge.getChargeId());
		oldcheck.merge(charge);
		chargeService.modifyCharge(oldcheck);
		map.put("flag",true); 
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> changStatusById(Charge charge) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = chargeService.deleteCharge(charge);
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
	public Map<String,Object> deleteChargeById(Charge charge) {
		Map<String,Object> map=new HashMap<String,Object>();
		Charge status = chargeService.queryChargeById(charge.getChargeId());
		if(status == null)
		{
			map.put("flag",false);
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			Charge flag = chargeService.changStatus(charge);
			if(flag ==null){
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
