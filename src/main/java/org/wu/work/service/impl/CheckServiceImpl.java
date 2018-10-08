package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Check;
import org.wu.work.repository.impl.CheckRepository;
import org.wu.work.service.CheckService;

@SuppressWarnings("restriction")
@Service("checkService")
public class CheckServiceImpl implements CheckService{

	@Resource
	private CheckRepository checkRepository;
	
	public Check queryCheckById(String id) {
		return checkRepository.queryCheckById(id);
	}

	public Check insertCheck(Check check) {
		return checkRepository.saveCheck(check);
	}

	public Check modifyCheck(Check check) {
		return checkRepository.saveCheck(check);
	}

	public Check queryCheckById(Check check) {
		return null;
	}

	public boolean deleteCheck(Check check) {
		return checkRepository.deleteCheck(check);
	}

	public Check changStatus(Check check) {
		return checkRepository.saveCheck(check);
	}

	public List<Map<String,String>> queryCheckList(int page, int pageSize, String code) {
		return checkRepository.queryCheckList(page, pageSize, code);
	}
   //医生查看检查单
	public List<Map<String,String>> queryAddCheckListV(int page, int pageSize, String vistId) {
		return checkRepository.queryAddCheckListV(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryAddCheckListU(int page, int pageSize, String userId) {
		return checkRepository.queryAddCheckListU(page, pageSize, userId);
	}
	public List<Map<String,String>> queryAddCheckListVU(int page, int pageSize, String vistId, String userId) {
		return checkRepository.queryAddCheckListVU(page, pageSize, vistId, userId);
	}
   //检查室查看检查单
	public List<Map<String,String>> queryCheckListV(int page, int pageSize, String vistId) {
		return checkRepository.queryCheckListV(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryCheckListU(int page, int pageSize, String userName) {
		return checkRepository.queryCheckListU(page, pageSize, userName);
	}
	public List<Map<String,String>> queryCheckListVU(int page, int pageSize, String vistId, String userName) {
		return checkRepository.queryCheckListVU(page, pageSize, vistId, userName);
	}
	
	public List<Map<String,String>> queryCheckList(int page, int pageSize) {
		return null;
	}

	public List<Map<String,String>> queryCheckByVistId(int page, int pageSize, String vistId) {
		return checkRepository.queryCheckByVistId(page, pageSize, vistId);
	}

	public List<Map<String,String>> queryCheckListInCRoom(int page, int pageSize) {
		return checkRepository.queryCheckListInCRoom(page, pageSize);
	}

	public List<Map<String,String>> queryCheckListInCRoom(int page, int pageSize, String vistId) {
		return checkRepository.queryCheckListInCRoom(page, pageSize, vistId);
	}

	//划价
	public List<Map<String,String>> queryFeeByVistId(String vistId) {
		return checkRepository.queryFeeByVistId(vistId);
	}

	public List<Map<String,String>> queryFeeListByVistId(int page, int pageSize, String vistId) {
		return checkRepository.queryFeeListByVistId(page, pageSize, vistId);
	}

	public List<Map<String,String>> queryFeeListByVistId(String vistId) {
		return checkRepository.queryFeeListByVistId(vistId);
	}

	//查看检查结果
	public List<Map<String,String>> queryCheckResult(String id) {
		return checkRepository.queryCheckResult(id);
	}

	public List<Map<String,String>> queryCheckResultList(int page, int pageSize) {
		return checkRepository.queryCheckResultList(page, pageSize);
	}
	
//检查室检查单管理
	public List<Map<String,String>> queryCheckResultListV(int page, int pageSize, String vistId) {
		return checkRepository.queryCheckResultListV(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryCheckResultListU(int page, int pageSize, String userName) {
		return checkRepository.queryCheckResultListU(page, pageSize, userName);
	}
	public List<Map<String,String>> queryCheckResultListVU(int page, int pageSize, String vistId, String userName) {
		return checkRepository.queryCheckResultListVU(page, pageSize, vistId, userName);
	}
     //检查室根据条件查找检查单
	public List<Map<String,String>> queryAddCheckResultListV(int page, int pageSize, String vistId) {
		return checkRepository.queryAddCheckResultListV(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryAddCheckResultListU(int page, int pageSize, String userId) {
		return checkRepository.queryAddCheckResultListU(page, pageSize, userId);
	}
	public List<Map<String,String>> queryAddCheckResultListVU(int page, int pageSize, String vistId, String userId) {
		return checkRepository.queryAddCheckResultListVU(page, pageSize, vistId, userId);
	}

	public List<Map<String,String>> queryDataNum(String vistId) {
		return checkRepository.queryDataNum(vistId);
	}

	//分页
	public List<Map<String,String>> queryDataNumByCode(String doctorCode) {
		return checkRepository.queryDataNumByCode(doctorCode);
	}
	public List<Map<String,String>> queryDataNumByVistId(String vistId, String doctorCode) {
		return checkRepository.queryDataNumByVistId(vistId, doctorCode);
	}
	public List<Map<String,String>> queryDataNumByUserId(String userId, String doctorCode) {
		return checkRepository.queryDataNumByUserId(userId, doctorCode);
	}
	public List<Map<String,String>> queryDataNumByUV(String userId, String vistId, String doctorCode) {
		return checkRepository.queryDataNumByUV(userId, vistId, doctorCode);
	}

	//划价收费（分页）
	public List<Map<String,String>> queryDataNumByVistId(String vistId) {
		return checkRepository.queryDataNumByVistId(vistId);
	}

	public List<Map<String,String>> queryCheckListInCRoom() {
		return checkRepository.queryCheckListInCRoom();
	}

	
	//检查化验室查询（分页）
	public List<Map<String,String>> findDataNumByVistId(String vistId) {
		return checkRepository.findDataNumByVistId(vistId);
	}
	public List<Map<String,String>> findDataNumByUserName(String userName) {
		return checkRepository.findDataNumByUserName(userName);
	}
	public List<Map<String,String>> findDataNumByVU(String vistId, String userName) {
		return checkRepository.findDataNumByVU(vistId, userName);
	}

	public List<Map<String,String>> queryCheckResultDataNum() {
		return checkRepository.queryCheckResultDataNum();
	}

	//检查结果单（分页）
	public List<Map<String,String>> queryAddCheckResultListV(String vistId) {
		return checkRepository.queryAddCheckResultListV(vistId);
	}
	public List<Map<String,String>> queryAddCheckResultListU(String userId) {
		return checkRepository.queryAddCheckResultListU(userId);
	}
	public List<Map<String,String>> queryAddCheckResultListVU(String vistId, String userId) {
		return checkRepository.queryAddCheckResultListVU(vistId, userId);
	}

	public List<Map<String,String>> getFeeListByVistId(String vistId) {
		return checkRepository.getFeeListByVistId(vistId);
	}

	
	public List<Map<String,String>> queryCheckListByUser(int page, int pageSize, String userId, String stime, String etime) {
		return checkRepository.queryCheckListByUser(page, pageSize, userId, stime, etime);
	}
	public List<Map<String,String>> queryCheckListByUser(int page, int pageSize, String userId) {
		return checkRepository.queryCheckListByUser(page, pageSize, userId);
	}
	public List<Map<String,String>> queryCheckListByUser(String userId, String stime, String etime) {
		return checkRepository.queryCheckListByUser(userId, stime, etime);
	}
	public List<Map<String,String>> queryCheckListByUser(String userId) {
		return checkRepository.queryCheckListByUser(userId);
	}
	 
}
