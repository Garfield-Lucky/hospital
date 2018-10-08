package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Register;
import org.wu.work.repository.impl.RegisterRepository;
import org.wu.work.service.RegisterService;

@SuppressWarnings("restriction")
@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Resource
	private RegisterRepository registerRepository;
	
	public Register queryRegisterById(String vistId) {
		return registerRepository.queryRegisterById(vistId);
	}

	public Register insertRegister(Register register) {
		return registerRepository.saveRegister(register);
	}

	public Register modifyRegister(Register register) {
		return registerRepository.saveRegister(register);
	}

	public Register queryRegisterById(Register register) {
		return registerRepository.queryRegisterById(register.getVistId());
	}

	public boolean deleteRegister(Register register) {
		return registerRepository.deleteRegister(register);
	}

	public Register changStatus(Register register) {
		return registerRepository.saveRegister(register);
	}

	public List<Map<String,String>> queryRegisterByVistId(String vistId) {
		return registerRepository.queryRegisterByVistId(vistId);
	}

	public List<Map<String,String>> queryRegisterByCode(int page, int pageSize, String code) {
		return registerRepository.queryRegisterByCode(page,pageSize,code);
	}

	public List<Map<String,String>> queryAddDiagnoseList(String vistId, String code) {
		return registerRepository.queryDiagnoseList(vistId, code);
	}
 

	public List<Map<String,String>> queryDiagnoseByCode(int page,int pageSize,String code) {
		return registerRepository.queryDiagnoseByCode(page, pageSize, code);
	}

	//医生查看病人的诊断单列表
	public List<Map<String,String>> queryDiagnoseByVistId(int page,int pageSize,String vistId) {
		return registerRepository.queryDiagnoseByVistId(page,pageSize,vistId);
	}
	public List<Map<String,String>> queryDiagnoseByUserId(int page, int pageSize, String userId) {
		return registerRepository.queryDiagnoseByUserId(page, pageSize, userId);
	}

	public List<Map<String,String>> queryDiagnoseByVU(int page, int pageSize, String vistId, String userId) {
		return registerRepository.queryDiagnoseByVU(page, pageSize, vistId, userId);
	}
	public List<Map<String,String>> queryRegisterCount(String stime, String etime) {
		return registerRepository.queryRegisterCount(stime, etime);
	}

	public List<Map<String,String>> queryRegisterBackCount(String stime, String etime) {
		return registerRepository.queryRegisterBackCount(stime, etime);
	}

	public List<Map<String,String>> queryRegisterList(int page, int pageSize) {
		return registerRepository.queryRegisterList(page, pageSize);
	}

	public List<Map<String,String>> queryRegisterByUserId(String userId) {
		return registerRepository.queryRegisterByUserId(userId);
	}

	public List<Map<String,String>> queryRegisterListByType(String officeType, int page, int pageSize) {
		return registerRepository.queryRegisterListByType(officeType, page, pageSize);
	}

	public List<Map<String,String>> queryRegisterListByName(String doctorName, int page, int pageSize) {
		return registerRepository.queryRegisterListByName(doctorName, page, pageSize);
	}

	public List<Map<String,String>> queryRegisterListByNameAndType(String officeType, String doctorName, int page, int pageSize) {
		return registerRepository.queryRegisterListByNameAndType(officeType, doctorName, page, pageSize);
	}

	public List<Map<String,String>> queryRegisterByCodeAndVistId(int page, int pageSize, String vistId, String code) {
		return registerRepository.queryRegisterByCodeAndVistId(page, pageSize, vistId, code);
	}

	public List<Map<String,String>> queryRegisterByCodeAndName(int page, int pageSize, String userName, String code) {
		return registerRepository.queryRegisterByCodeAndName(page, pageSize, userName, code);
	}

	//分页
	public List<Map<String,String>> queryDataNum() {
		return registerRepository.queryDataNum();
	}
	public List<Map<String,String>> queryDataNumByName(String officeName) {
		return registerRepository.queryDataNumByName(officeName);
	}
	public List<Map<String,String>> queryDataNumByType(String officeType) {
		return registerRepository.queryDataNumByType(officeType);
	}
	public List<Map<String,String>> queryDataNumByNameAndType(String officeName,String officeType) {
		return registerRepository.queryDataNumByNameAndType(officeName,officeType);
	}

	public List<Map<String,String>> queryRegisterByUserId(String userId, int page, int pageSize) {
		return registerRepository.queryRegisterByUserId(userId,page,pageSize);
	}

	public List<Map<String,String>> queryDataNum(String doctorCode) {
		return registerRepository.queryDataNum(doctorCode);
	}
	public List<Map<String,String>> queryDataNumByVistId(String vistId, String doctorCode) {
		return registerRepository.queryDataNumByVistId(vistId, doctorCode);
	}
	public List<Map<String,String>> queryDataNumByPatientName(String userName, String doctorCode) {
		return registerRepository.queryDataNumByPatientName(userName, doctorCode);
	}

	
	//医生诊断单管理
	public List<Map<String,String>> queryDataNumResult(String doctorCode) {
		return registerRepository.queryDataNumResult(doctorCode);
	}
	public List<Map<String,String>> queryDataNumResultByVistId(String vistId) {
		return registerRepository.queryDataNumResultByVistId(vistId);
	}
	public List<Map<String,String>> queryDataNumResultByPatientId(String userId) {
		return registerRepository.queryDataNumByResultPatientId(userId);
	}
	public List<Map<String,String>> queryDataNumResultByUV(String userId,String vistId) {
		return registerRepository.queryDataNumByResultUV(userId, vistId);
	}

	//用户查看自己的诊断单
	public List<Map<String,String>> queryDiagnoseByUser(int page, int pageSize, String userId, String stime, String etime) {
		return registerRepository.queryDiagnoseByUser(page, pageSize, userId,stime,etime);
	}
	public List<Map<String,String>> queryDiagnoseByUser(int page, int pageSize, String userId) {
		return registerRepository.queryDiagnoseByUser(page,pageSize,userId);
	}
	public List<Map<String,String>> queryDiagnoseByUser(String userId, String stime, String etime) {
		return registerRepository.queryDiagnoseByUser(userId, stime, etime);
	}
	public List<Map<String,String>> queryDiagnoseByUser(String userId) {
		return registerRepository.queryDiagnoseByUser(userId);
	}

	public List<Map<String,String>> queryRegisterByUserId(String userId, String doctorCode,String officeCode, String workDate) {
		return registerRepository.queryRegisterByUserId(userId, doctorCode,officeCode, workDate);
	}

	public List<Map<String,String>> queryRegisterCount() {
		return registerRepository.queryRegisterCount();
	}
	 
}
