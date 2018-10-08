package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.DoctorWork;

public interface DoctorWorkService {
	
	public List<Map<String,String>> queryDoctorWorkList(int page,int pageSize);
	public List<DoctorWork> queryDoctorWorkByCode(String code);
	public List<Map<String,String>> queryDoctorWorkByCodeAndDate(String code,String date);
	public DoctorWork queryDoctorWorkById(String id);
	public DoctorWork insertDoctorWork(DoctorWork work);
	public DoctorWork modifyDoctorWork(DoctorWork work);
	public List<Map<String,String>> queryDoctorWorkCode(int page,int pageSize,String code);
	public boolean deleteDoctorWork(DoctorWork work);
	public DoctorWork changStatus(DoctorWork work);
	
	//医生值班安排查询
	public List<Map<String,String>> queryDoctorWorkByD(int page,int pageSize,String code);
	public List<Map<String,String>> queryDoctorWorkByR(int page,int pageSize,String count);
	public List<Map<String,String>> queryDoctorWorkByW(int page,int pageSize,String date);
	public List<Map<String,String>> queryDoctorWorkByT(int page,int pageSize,String time);
	public List<Map<String,String>> queryDoctorWorkByRW(int page,int pageSize,String count,String date);
	public List<Map<String,String>> queryDoctorWorkByRT(int page,int pageSize,String count,String time);
	public List<Map<String,String>> queryDoctorWorkByWT(int page,int pageSize,String date,String time);
	public List<Map<String,String>> queryDoctorWorkByDR(int page,int pageSize,String code,String count);
	public List<Map<String,String>> queryDoctorWorkByDW(int page,int pageSize,String code,String date);
	public List<Map<String,String>> queryDoctorWorkByDT(int page,int pageSize,String code,String time);
	public List<Map<String,String>> queryDoctorWorkByDRW(int page,int pageSize,String code,String count,String date);
	public List<Map<String,String>> queryDoctorWorkByDRT(int page,int pageSize,String code,String count,String time);
	public List<Map<String,String>> queryDoctorWorkByDWT(int page,int pageSize,String code,String date,String time);
	public List<Map<String,String>> queryDoctorWorkByRWT(int page,int pageSize,String count,String date,String time);
	public List<Map<String,String>> queryDoctorWorkByDRWT(int page,int pageSize,String code,String count,String date,String time);

	//分页
	public List<Map<String,String>> queryDataNum();
	public List<Map<String,String>> queryDataNumByD(String code);
	public List<Map<String,String>> queryDataNumByR(String count);
	public List<Map<String,String>> queryDataNumByW(String date);
	public List<Map<String,String>> queryDataNumByT(String time);
	public List<Map<String,String>> queryDataNumByRW(String count,String date);
	public List<Map<String,String>> queryDataNumByRT(String count,String time);
	public List<Map<String,String>> queryDataNumByWT(String date,String time);
	public List<Map<String,String>> queryDataNumByDR(String code,String count);
	public List<Map<String,String>> queryDataNumByDW(String code,String date);
	public List<Map<String,String>> queryDataNumByDT(String code,String time);
	public List<Map<String,String>> queryDataNumByDRW(String code,String count,String date);
	public List<Map<String,String>> queryDataNumByDRT(String code,String count,String time);
	public List<Map<String,String>> queryDataNumByDWT(String code,String date,String time);
	public List<Map<String,String>> queryDataNumByRWT(String count,String date,String time);
	public List<Map<String,String>> queryDataNumByDRWT(String code,String count,String date,String time);

}
