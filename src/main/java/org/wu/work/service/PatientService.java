package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Patient;

public interface PatientService {
	
	public List<Map<String,String>> queryPatientList(int page,int pageSize);
	public List<Map<String,String>> queryPatientByUserId(int page,int pageSize,String userId);
	public List<Map<String,String>> queryPatientByUserName(int page,int pageSize,String userName);
	//统计符合条件的数据条数
	public List<Map<String,String>> queryDataNum();
	public List<Map<String,String>> queryDataNumById(String userId);
	public List<Map<String,String>> queryDataNumByName(String userName);
	
	public List<Map<String,String>> queryPatientByUserId(String userId);
	public List<Map<String,String>> queryPatientListToDoctor(int page,int pageSize,String code);
	//医生模块查看病人信息
	public List<Map<String,String>> queryPatientByVistId(int page,int pageSize,String code,String vistId);
	public List<Map<String,String>> queryPatientByUserName(int page,int pageSize,String code,String userName);
	public List<Map<String,String>> queryPatientByVU(int page,int pageSize,String code,String vistId,String userName);
	
	public Patient queryPatientById(String userId);
	public Patient insertPatient(Patient patient);
	public Patient modifyPatient(Patient patient);
	public Patient queryPatientById(Patient patient);
	public boolean deletePatient(Patient patient);
	public Patient changStatus(Patient patient);
	
	//医生病人列表
	public List<Map<String,String>> queryDataNumByCode(String doctorCode);
	public List<Map<String,String>> queryDataNumByvistId(String vistId,String doctorCode);
	public List<Map<String,String>> queryDataNumByUserName(String userName,String doctorCode);
	public List<Map<String,String>> queryDataNumByUV(String userName,String vistId,String doctorCode);
	
}
