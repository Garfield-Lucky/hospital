package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Prescription;
import org.wu.work.repository.impl.PrescriptionRepository;
import org.wu.work.service.PrescriptionService;

@SuppressWarnings("restriction")
@Service("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService{

	@Resource
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription queryPrescriptionById(String id) {
		return prescriptionRepository.queryPrescriptionById(id);
	}

	public Prescription insertPrescription(Prescription pres) {
		return prescriptionRepository.savePrescription(pres);
	}

	public Prescription modifyPrescription(Prescription pres) {
		return prescriptionRepository.savePrescription(pres);
	}

	public Prescription queryPrescriptionById(Prescription pres) {
		return prescriptionRepository.queryPrescriptionById(pres.getVistId());
	}

	public boolean deletePrescription(Prescription pres) {
		return prescriptionRepository.deletePrescription(pres);
	}

	public Prescription changStatus(Prescription pres) {
		return prescriptionRepository.savePrescription(pres);
	}

	public List<Map<String,String>> queryPrescriptionList(int page, int pageSize,String code) {
		return prescriptionRepository.queryPrescriptionList(page, pageSize,code);
	}

	public List<Map<String,String>> queryPresList(int page, int pageSize) {
		return prescriptionRepository.queryPresList(page, pageSize);
	}

	public List<Map<String,String>> queryAddPresList(int page, int pageSize, String vistId) {
		return prescriptionRepository.queryAddPresList(page, pageSize, vistId);
	}

	public List<Map<String,String>> queryPresByVistId(int page, int pageSize, String vistId) {
		return prescriptionRepository.queryPresByVistId(page, pageSize, vistId);
	}
	
//处方单管理列表
	public List<Map<String,String>> queryPresByVistIdForPresManagerV(int page,int pageSize,String vistId) {
		return prescriptionRepository.queryPresListV(page,pageSize,vistId);
	}
	public List<Map<String,String>> queryPresByVistIdForPresManagerU(int page, int pageSize, String userId) {
		return prescriptionRepository.queryPresListU(page, pageSize, userId);
	}

	public List<Map<String,String>> queryPresByVistIdForPresManagerVU(int page, int pageSize, String vistId, String userId) {
		return prescriptionRepository.queryPresListVU(page, pageSize, vistId, userId);
	}
	
	//药房摆药
	public List<Map<String,String>> queryPresByVistIdBaiYao(int page, int pageSize,String vistId) {
		return prescriptionRepository.queryPresListBaiYaoByVistId(page,pageSize,vistId);
	}
	public List<Map<String,String>> queryPresByUserIdBaiYao(int page, int pageSize, String userId) {
		return prescriptionRepository.queryPresListBaiYaoByUserId(page,pageSize,userId);
	}
	public List<Map<String,String>> queryPresByVUBaiYao(int page, int pageSize, String vistId, String userId) {
		return prescriptionRepository.queryPresListBaiYaoByVU(page,pageSize,vistId,userId);
	}
	public List<Map<String,String>> queryPresByVistIdBaiYao(String vistId) {
		return prescriptionRepository.queryPresListBaiYaoByVistId(vistId);
	}
	public List<Map<String,String>> queryPresByUserIdBaiYao(String userId) {
		return prescriptionRepository.queryPresListBaiYaoByUserId(userId);
	}
	public List<Map<String,String>> queryPresByVUBaiYao(String vistId, String userId) {
		return prescriptionRepository.queryPresListBaiYaoByVU(vistId, userId);
	}
    //划价
	public List<Map<String,String>> queryFeeByVistId(String vistId) {
		return prescriptionRepository.queryFeeByVistId(vistId);
	}

	public List<Map<String,String>> queryFeeListByVistId(int page, int pageSize, String vistId) {
		return prescriptionRepository.queryFeeListByVistId(page, pageSize, vistId);
	}

	public List<Map<String,String>> queryFeeListByVistId(String vistId) {
		return prescriptionRepository.queryFeeListByVistId(vistId);
	}

	public List<Map<String,String>> queryMedicineList(int page, int pageSize, String vistId) {
		return prescriptionRepository.queryMedicineList(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryMedicineList(String vistId) {
		return prescriptionRepository.queryMedicineList(vistId);
	}

	public List<Prescription> queryPresByVistId(String vistId) {
		return prescriptionRepository.queryPrescriptionByVistId(vistId);
	}

	public List<Map<String,String>> queryDataNum(String vistId) {
		return prescriptionRepository.queryDataNum(vistId);
	}

	//分页（医生管理自己的处方单）
	public List<Map<String,String>> queryDataNumByCode(String doctorCode) {
		return prescriptionRepository.queryDataNumByCode(doctorCode);
	}
	public List<Map<String,String>> queryDataNumByVistId(String vistId, String doctorCode) {
		return prescriptionRepository.queryDataNumByVistId(vistId,doctorCode);
	}
	public List<Map<String,String>> queryDataNumByUserId(String userId, String doctorCode) {
		return prescriptionRepository.queryDataNumByUserId(userId,doctorCode);
	}


	public List<Map<String,String>> queryDataNumByUV(String userId, String vistId, String doctorCode) {
		return prescriptionRepository.queryDataNumByUV(userId, vistId,doctorCode);
	}

	//划价收费
	public List<Map<String,String>> queryDataNumByVistId(String vistId) {
		return prescriptionRepository.queryDataNumByVistId(vistId);
	}

	public List<Map<String,String>> queryPresList() {
		return prescriptionRepository.queryPresList();
	}

	public List<Map<String,String>> getFeeListByVistId(String vistId) {
		return prescriptionRepository.getFeeListByVistId(vistId);
	}

	
	//用户处方单
	public List<Map<String,String>> queryPresByUser(int page, int pageSize, String userId, String stime, String etime) {
		return prescriptionRepository.queryPresListByUser(page, pageSize, userId, stime, etime);
	}
	public List<Map<String,String>> queryPresByUser(int page, int pageSize, String userId) {
		return prescriptionRepository.queryPresListByUser(page, pageSize, userId);
	}
	public List<Map<String,String>> queryPresByUser(String userId, String stime, String etime) {
		return prescriptionRepository.queryPresListByUser(userId, stime, etime);
	}
	public List<Map<String,String>> queryPresByUser(String userId) {
		return prescriptionRepository.queryPresListByUser(userId);
	}
	 
}
