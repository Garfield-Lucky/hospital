package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Charge;

public interface ChargeService {
	 
	public Charge queryChargeById(String id);
	public Charge insertCharge(Charge check);
	public Charge modifyCharge(Charge check);
	public Charge queryChargeById(Charge check);
	//账单管理
	public List<Map<String,String>> queryChargeByTime(String stime,String etime);
	public List<Map<String,String>> queryBillByTime(int page,int pageSize,String stime,String etime);
	public List<Map<String,String>> queryBillByVistId(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryBillByVSE(int page,int pageSize,String vistId,String stime,String etime);
	
	//统计汇总
	public List<Map<String,String>> queryCountByTime(int page,int pageSize,String stime,String etime);
	public List<Map<String,String>> queryCountByClerk(String clerk);
	public List<Map<String,String>> queryCountByTimeAndClerk(String stime,String etime,String clerk);
	
	//账单明细
	public List<Map<String,String>> findBillList(int page,int pageSize,String stime,String etime,String clerk);
	
    //获取摆药列表的药品名、规格、数量 用来对库存进行更改
	public List<Charge> querySaleMedicineList(String vistId);
	public boolean deleteCharge(Charge check);
	public Charge changStatus(Charge check);
	
	//分页
	public List<Map<String,String>> queryDataNumByVistId(String vistId);
	public List<Map<String,String>> queryDataNumByTime(String stime,String etime);
	public List<Map<String,String>> queryDataNumByVSE(String vistId,String stime,String etime);

	//分页 账单明细列表
	public List<Map<String,String>> queryDataNum(String stime,String etime,String clerk);
}
