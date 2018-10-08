package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Prescription;

public interface PrescriptionService {
	
	public List<Map<String,String>> queryPrescriptionList(int page,int pageSize,String code);
	public List<Map<String,String>> queryAddPresList(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryMedicineList(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryMedicineList(String vistId); //分页（处方单药品列表）
	public List<Map<String,String>> queryPresList(int page,int pageSize);
	//医生处方单管理
	public List<Map<String,String>> queryPresByVistId(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryPresByVistIdForPresManagerV(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryPresByVistIdForPresManagerU(int page,int pageSize,String userId);
	public List<Map<String,String>> queryPresByVistIdForPresManagerVU(int page,int pageSize,String vistId,String userName);
	//用户处方单管理
	public List<Map<String,String>> queryPresByUser(int page,int pageSize,String userId,String stime,String etime);
	public List<Map<String,String>> queryPresByUser(int page,int pageSize,String userId);
	//分页（用户处方单管理）
	public List<Map<String,String>> queryPresByUser(String userId,String stime,String etime);
	public List<Map<String,String>> queryPresByUser(String userId);
	
	//划价
	public List<Map<String,String>> queryFeeByVistId(String vistId);
	public List<Map<String,String>> queryFeeListByVistId(String vistId);
	public List<Map<String,String>> queryFeeListByVistId(int page,int pageSize,String vistId);
	//划价收费
	public List<Map<String,String>> getFeeListByVistId(String vistId);
	//摆药员查看摆药列表
	public List<Map<String,String>> queryPresByVistIdBaiYao(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryPresByUserIdBaiYao(int page,int pageSize,String userId);
	public List<Map<String,String>> queryPresByVUBaiYao(int page,int pageSize,String vistId,String userId);
	//摆药员查看摆药列表（分页）
	public List<Map<String,String>> queryPresByVistIdBaiYao(String vistId);
	public List<Map<String,String>> queryPresByUserIdBaiYao(String userId);
	public List<Map<String,String>> queryPresByVUBaiYao(String vistId,String userId);
	
	public List<Prescription> queryPresByVistId(String vistId);
	public Prescription queryPrescriptionById(String id);
	public Prescription insertPrescription(Prescription pres);
	public Prescription modifyPrescription(Prescription pres);
	public Prescription queryPrescriptionById(Prescription pres);
	public boolean deletePrescription(Prescription pres);
	public Prescription changStatus(Prescription pres);
	
	//分页（医生添加处方单）
	public List<Map<String,String>> queryDataNum(String vistId);
	//分页（医生管理自己的处方单）
	public List<Map<String,String>> queryDataNumByCode(String doctorCode);
	public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode);
	public List<Map<String,String>> queryDataNumByUserId(String userId,String doctorCode);
	public List<Map<String,String>> queryDataNumByUV(String userId,String vistId,String doctorCode);
	
	//划价收费（分页）
    public List<Map<String,String>> queryDataNumByVistId(String vistId);
    //初始化摆药列表（分页）
    public List<Map<String,String>> queryPresList();
}
