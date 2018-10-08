package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Charge;
import org.wu.work.repository.impl.ChargeRepository;
import org.wu.work.service.ChargeService;

@SuppressWarnings("restriction")
@Service("chargeService")
public class ChargeServiceImpl implements ChargeService{

	@Resource
	private ChargeRepository chargeRepository;
	
	public Charge queryChargeById(String id) {
		return chargeRepository.queryChargeById(id);
	}

	public Charge insertCharge(Charge charge) {
		return chargeRepository.saveCharge(charge);
	}

	public Charge modifyCharge(Charge charge) {
		return chargeRepository.saveCharge(charge);
	}

	public Charge queryChargeById(Charge charge) {
		return chargeRepository.queryChargeById(charge.getChargeId());
	}

	public boolean deleteCharge(Charge charge) {
		return chargeRepository.deleteCharge(charge);
	}

	public Charge changStatus(Charge charge) {
		return chargeRepository.saveCharge(charge);
	}

	public List<Map<String,String>> queryChargeByTime(String stime, String etime) {
		return chargeRepository.queryChargeByTime(stime, etime);
	}
//账单管理
	public List<Map<String,String>> queryBillByTime(int page, int pageSize, String stime, String etime) {
		return chargeRepository.queryBillByTime(page, pageSize, stime, etime);
	}

	public List<Map<String,String>> queryBillByVistId(int page, int pageSize, String vistId) {
		return chargeRepository.queryBillByVistId(page, pageSize, vistId);
	}
	public List<Map<String,String>> queryBillByVSE(int page, int pageSize, String vistId, String stime, String etime) {
		return chargeRepository.queryBillByVSE(page, pageSize, vistId, stime, etime);
	}
	//统计汇总
	public List<Map<String,String>> queryCountByTime(int page, int pageSize, String stime, String etime) {
		return chargeRepository.queryCountByTime(page, pageSize, stime, etime);
	}
	public List<Map<String,String>> queryCountByTimeAndClerk(String stime, String etime, String clerk) {
		return chargeRepository.queryCountByTimeAndClerk(stime, etime, clerk);
	}
	public List<Map<String,String>> queryCountByClerk(String clerk) {
		return chargeRepository.queryCountByClerk(clerk);
	}
    //账单明细
	public List<Map<String,String>> findBillList(int page, int pageSize, String stime, String etime, String clerk) {
		return chargeRepository.findBillList(page, pageSize, stime, etime, clerk);
	}

	public List<Charge> querySaleMedicineList(String vistId) {
		return chargeRepository.querySaleMedicineList(vistId);
	}

//账单管理（分页）
	public List<Map<String,String>> queryDataNumByVistId(String vistId) {
		return chargeRepository.queryDataNumByVistId(vistId);
	}
	public List<Map<String,String>> queryDataNumByTime(String stime,String etime) {
		return chargeRepository.queryDataNumByTime(stime, etime);
	}
	public List<Map<String,String>> queryDataNumByVSE(String vistId,String stime,String etime) {
		return chargeRepository.queryDataNumByVSE(vistId, stime, etime);
	}

	public List<Map<String,String>> queryDataNum(String stime, String etime, String clerk) {
		return chargeRepository.queryDataNum(stime, etime, clerk);
	}

}
