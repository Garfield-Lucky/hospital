package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Check;

public interface CheckService {
	
	public List<Map<String,String>> queryCheckList(int page,int pageSize,String code);
	public List<Map<String,String>> queryCheckListInCRoom(int page,int pageSize);
	//医生查看检查单
	public List<Map<String,String>> queryAddCheckListV(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryAddCheckListU(int page,int pageSize,String userId);
	public List<Map<String,String>> queryAddCheckListVU(int page,int pageSize,String vistId,String userId);
	//用户查看检查单
	public List<Map<String,String>> queryCheckListByUser(int page,int pageSize,String userId,String stime,String etime);
	public List<Map<String,String>> queryCheckListByUser(int page,int pageSize,String userId);
	//分页（用户查看检查单）
	public List<Map<String,String>> queryCheckListByUser(String userId,String stime,String etime);
	public List<Map<String,String>> queryCheckListByUser(String userId);
	
    //检查室查看检查单
	public List<Map<String,String>> queryCheckListV(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryCheckListU(int page,int pageSize,String userName);
	public List<Map<String,String>> queryCheckListVU(int page,int pageSize,String vistId,String userName);
	
	public List<Map<String,String>> queryCheckResult(String vistId);
	//检查室简单单管理（默认加载已检查的检查单）
	public List<Map<String,String>> queryCheckResultList(int page,int pageSize);
	public List<Map<String,String>> queryCheckResultListV(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryCheckResultListU(int page,int pageSize,String userName);
	public List<Map<String,String>> queryCheckResultListVU(int page,int pageSize,String vistId,String userName);
	
	//检查室输入条件查询检查单
	public List<Map<String,String>> queryAddCheckResultListV(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryAddCheckResultListU(int page,int pageSize,String userId);
	public List<Map<String,String>> queryAddCheckResultListVU(int page,int pageSize,String vistId,String userId);
	//检查结果单管理（分页）
	public List<Map<String,String>> queryAddCheckResultListV(String vistId);
	public List<Map<String,String>> queryAddCheckResultListU(String userId);
	public List<Map<String,String>> queryAddCheckResultListVU(String vistId,String userId);
	
	//划价
	public List<Map<String,String>> queryFeeByVistId(String vistId);
	public List<Map<String,String>> queryFeeListByVistId(String vistId);
	public List<Map<String,String>> queryFeeListByVistId(int page,int pageSize,String vistId);
	
	//划价收费（分页）
	public List<Map<String,String>> getFeeListByVistId(String vistId);
	
	public List<Map<String,String>> queryCheckByVistId(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryCheckListInCRoom(int page,int pageSize,String vistId);
	public List<Map<String,String>> queryCheckList(int page,int pageSize);
	public Check queryCheckById(String id);
	public Check insertCheck(Check check);
	public Check modifyCheck(Check check);
	public Check queryCheckById(Check check);
	public boolean deleteCheck(Check check);
	public Check changStatus(Check check);
	
	//分页（医生添加检查单单）
	public List<Map<String,String>> queryDataNum(String vistId);
	
	//分页（医生管理自己的检查单）
	public List<Map<String,String>> queryDataNumByCode(String doctorCode);
	public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode);
	public List<Map<String,String>> queryDataNumByUserId(String userId,String doctorCode);
	public List<Map<String,String>> queryDataNumByUV(String userId,String vistId,String doctorCode);
	
	//划价收费(分页)
    public List<Map<String,String>> queryDataNumByVistId(String vistId);
    
    //检查检验（分页）
    public List<Map<String,String>> queryCheckListInCRoom();
    
    //分页（检查检验室查询患者列表）
  	public List<Map<String,String>> findDataNumByVistId(String vistId);
  	public List<Map<String,String>> findDataNumByUserName(String userName);
  	public List<Map<String,String>> findDataNumByVU(String vistId,String userName);
  	
  	//检查检验室检查单管理
    public List<Map<String,String>> queryCheckResultDataNum();
}
