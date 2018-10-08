package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Register;

public interface RegisterService {
	
	public List<Map<String,String>> queryRegisterByVistId(String vistId);
	public List<Map<String,String>> queryRegisterByUserId(String userId);
	public List<Map<String,String>> queryRegisterByUserId(String userId,String doctorCode,String officeCode,String workDate);
	
	public List<Map<String,String>> queryDiagnoseByVistId(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryDiagnoseByUserId(int page,int pageSize,String userId);
	public List<Map<String,String>> queryDiagnoseByVU(int page,int pageSize,String vistId,String userId);
	
	public List<Map<String,String>> queryRegisterByCode(int page,int pageSize,String code);
	public List<Map<String,String>> queryRegisterByCodeAndVistId(int page,int pageSize,String vistId,String code);
	public List<Map<String,String>> queryRegisterByCodeAndName(int page,int pageSize,String userName,String code);
	
	public List<Map<String,String>> queryDiagnoseByCode(int page,int pageSize,String code);
	public List<Map<String,String>> queryAddDiagnoseList(String vistId,String code);
	public List<Map<String,String>> queryRegisterCount(String stime,String etime);
	public List<Map<String,String>> queryRegisterCount();
	public List<Map<String,String>> queryRegisterBackCount(String stime,String etime);
	public List<Map<String,String>> queryRegisterList(int page,int pageSize);
	public List<Map<String,String>> queryRegisterListByType(String officeType,int page,int pageSize);
	public List<Map<String,String>> queryRegisterListByName(String doctorName,int page,int pageSize);
	public List<Map<String,String>> queryRegisterListByNameAndType(String officeType,String doctorName,int page,int pageSize);
	public Register queryRegisterById(String vistId);
	public Register insertRegister(Register register);
	public Register modifyRegister(Register register);
	public Register queryRegisterById(Register register);
	public boolean deleteRegister(Register register);
	public Register changStatus(Register register);
	
	//退号
	public List<Map<String,String>> queryRegisterByUserId(String userId,int page,int pageSize);
	
	public List<Map<String,String>> queryDataNum();
	public List<Map<String,String>> queryDataNumByName(String officeName);
	public List<Map<String,String>> queryDataNumByType(String officeType);
	public List<Map<String,String>> queryDataNumByNameAndType(String officeName,String officeType);
	
	//医生诊断列表，需要根据医生的编号去查询
	public List<Map<String,String>> queryDataNum(String doctorCode);
	public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode);
	public List<Map<String,String>> queryDataNumByPatientName(String userName,String doctorCode);
	
	//医生诊断单管理列表
	public List<Map<String,String>> queryDataNumResult(String doctorCode);
	public List<Map<String,String>> queryDataNumResultByVistId(String vistId);
	public List<Map<String,String>> queryDataNumResultByPatientId(String userName);
	public List<Map<String,String>> queryDataNumResultByUV(String userId,String vistId);
	
	//患者查看诊断单
	public List<Map<String,String>> queryDiagnoseByUser(int page,int pageSize,String userId,String stime,String etime);
	public List<Map<String,String>> queryDiagnoseByUser(int page,int pageSize,String userId);
	//分页（患者查看诊断单）
	public List<Map<String,String>> queryDiagnoseByUser(String userId,String stime,String etime);
	public List<Map<String,String>> queryDiagnoseByUser(String userId);
	
}
