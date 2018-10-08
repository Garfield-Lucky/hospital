package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Patient;
import org.wu.work.repository.impl.PatientRepository;
import org.wu.work.service.PatientService;

@SuppressWarnings("restriction")
@Service("patientService")
public class PatientServiceImpl implements PatientService{

	@Resource
	private PatientRepository patientRepository;
	
	public Patient queryPatientById(String userId) {
		return patientRepository.queryPatientById(userId);
	}

	public Patient insertPatient(Patient patient) {
		return patientRepository.savePatient(patient);
	}

	public Patient modifyPatient(Patient patient) {
		return patientRepository.savePatient(patient);
	}

	public Patient queryPatientById(Patient patient) {
		return patientRepository.queryPatientById(patient.getUserId());
	}

	public boolean deletePatient(Patient patient) {
		return patientRepository.deletePatient(patient);
	}

	public Patient changStatus(Patient patient) {
		return patientRepository.savePatient(patient);
	}

	public List<Map<String,String>> queryPatientList(int page, int pageSize) {
		return patientRepository.queryPatientList(page, pageSize);
	}
	public List<Map<String,String>> queryPatientByUserId(int page, int pageSize, String userId) {
		return patientRepository.queryPatientByUserId(page, pageSize, userId);
	}
	public List<Map<String,String>> queryPatientByUserName(int page, int pageSize, String userName) {
		return patientRepository.queryPatientByUserName(page, pageSize, userName);
	}
	
	
	public List<Map<String,String>> queryPatientListToDoctor(int page, int pageSize, String code) {
		return patientRepository.queryPatientListToDoctor(page, pageSize, code);
	}

	public List<Map<String,String>> queryPatientByVistId(int page, int pageSize, String code, String vistId) {
		return patientRepository.queryPatientByVistId(page, pageSize, code, vistId);
	}
	public List<Map<String,String>> queryPatientByUserName(int page, int pageSize, String code, String userName) {
		return patientRepository.queryPatientByUserName(page, pageSize, code, userName);
	}
	public List<Map<String,String>> queryPatientByVU(int page, int pageSize, String code, String vistId, String userName) {
		return patientRepository.queryPatientByVU(page, pageSize, code, vistId, userName);
	}
	
	public List<Map<String,String>> queryPatientByUserId(String userId) {
		return patientRepository.queryPatientByUserId(userId);
	}

	//查询符合条件的数据条数，用以分页查询
	public List<Map<String,String>> queryDataNum() {
		return  patientRepository.queryDataNum();
	}
	public List<Map<String,String>> queryDataNumById(String userId) {
		return  patientRepository.queryDataNumById(userId);
	}
	public List<Map<String,String>> queryDataNumByName(String userName) {
		return  patientRepository.queryDataNumByName(userName);
	}

	//医生在医生工作站查看自己的患者列表(未就诊完成的患者)
	public List<Map<String,String>> queryDataNumByCode(String doctorCode) {
		return patientRepository.queryDataNum(doctorCode);
	}
	public List<Map<String,String>> queryDataNumByvistId(String vistId,String doctorCode) {
		return patientRepository.queryDataNumByVistId(vistId, doctorCode);
	}
	public List<Map<String,String>> queryDataNumByUserName(String userName,String doctorCode) {
		return patientRepository.queryDataNumByUserName(userName, doctorCode);
	}
	public List<Map<String,String>> queryDataNumByUV(String userName, String vistId,String doctorCode) {
		return patientRepository.queryDataNumByUV(userName, vistId, doctorCode);
	}


	

	 
}
