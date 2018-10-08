package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.DoctorWork;
import org.wu.work.repository.impl.DoctorWorkRepository;
import org.wu.work.service.DoctorWorkService;

@SuppressWarnings("restriction")
@Service("doctorWorkService")
public class DoctorWorkServiceImpl implements DoctorWorkService{

	@Resource
	private DoctorWorkRepository doctorWorkRepository;

	public List<DoctorWork> queryDoctorWorkByCode(String code) {
		return doctorWorkRepository.queryDoctorWorkByCode(code);
	}

	public DoctorWork queryDoctorWorkById(String id) {
		return doctorWorkRepository.queryDoctorWorkById(id);
	}

	public DoctorWork insertDoctorWork(DoctorWork work) {
		return doctorWorkRepository.saveDoctorWork(work);
	}

	public DoctorWork modifyDoctorWork(DoctorWork work) {
		return doctorWorkRepository.saveDoctorWork(work);
	}

	public List<Map<String,String>> queryDoctorWorkCode(int page, int pageSize,String code) {
		return doctorWorkRepository.queryDoctorWorkByCode(page, pageSize, code);
	}

	public boolean deleteDoctorWork(DoctorWork work) {
		return doctorWorkRepository.deleteDoctorWork(work);
	}

	public DoctorWork changStatus(DoctorWork work) {
		return doctorWorkRepository.saveDoctorWork(work);
	}

	public List<Map<String,String>> queryDoctorWorkList(int page, int pageSize) {
		return doctorWorkRepository.queryDoctorWorkList(page, pageSize);
	}

	public List<Map<String,String>> queryDoctorWorkByCodeAndDate(String code, String date) {
		return doctorWorkRepository.queryDoctorWorkByCodeAndDate(code, date);
	}
	
	
    //医生值班列表查询
	public List<Map<String,String>> queryDoctorWorkByD(int page, int pageSize, String code) {
		return doctorWorkRepository.queryDoctorWorkByD(page, pageSize, code);
	}

	public List<Map<String,String>> queryDoctorWorkByR(int page, int pageSize, String count) {
		return doctorWorkRepository.queryDoctorWorkByR(page, pageSize, count);
	}

	public List<Map<String,String>> queryDoctorWorkByW(int page, int pageSize, String date) {
		return doctorWorkRepository.queryDoctorWorkByW(page, pageSize, date);
	}

	public List<Map<String,String>> queryDoctorWorkByT(int page, int pageSize, String time) {
		return doctorWorkRepository.queryDoctorWorkByT(page, pageSize, time);
	}

	public List<Map<String,String>> queryDoctorWorkByRW(int page, int pageSize, String count, String date) {
		return doctorWorkRepository.queryDoctorWorkByRW(page, pageSize, count, date);
	}

	public List<Map<String,String>> queryDoctorWorkByRT(int page, int pageSize, String count, String time) {
		return doctorWorkRepository.queryDoctorWorkByRT(page, pageSize, count, time);
	}

	public List<Map<String,String>> queryDoctorWorkByWT(int page, int pageSize, String date, String time) {
		return doctorWorkRepository.queryDoctorWorkByWT(page, pageSize, date, time);
	}

	public List<Map<String,String>> queryDoctorWorkByDR(int page, int pageSize, String code, String count) {
		return doctorWorkRepository.queryDoctorWorkByDR(page, pageSize, code, count);
	}

	public List<Map<String,String>> queryDoctorWorkByDW(int page, int pageSize, String code, String date) {
		return doctorWorkRepository.queryDoctorWorkByDW(page, pageSize, code, date);
	}

	public List<Map<String,String>> queryDoctorWorkByDT(int page, int pageSize, String code, String time) {
		return doctorWorkRepository.queryDoctorWorkByDT(page, pageSize, code, time);
	}

	public List<Map<String,String>> queryDoctorWorkByDRW(int page, int pageSize, String code, String count, String date) {
		return doctorWorkRepository.queryDoctorWorkByDRW(page, pageSize, code, count, date);
	}

	public List<Map<String,String>> queryDoctorWorkByDRT(int page, int pageSize, String code, String count, String time) {
		return doctorWorkRepository.queryDoctorWorkByDRT(page, pageSize, code, count, time);
	}

	public List<Map<String,String>> queryDoctorWorkByDWT(int page, int pageSize, String code, String date, String time) {
		return doctorWorkRepository.queryDoctorWorkByDWT(page, pageSize, code, date, time);
	}

	public List<Map<String,String>> queryDoctorWorkByRWT(int page, int pageSize, String count, String date, String time) {
		return doctorWorkRepository.queryDoctorWorkByRWT(page, pageSize, count, date, time);
	}

	public List<Map<String,String>> queryDoctorWorkByDRWT(int page, int pageSize, String code, String count, String date,
			String time) {
		return doctorWorkRepository.queryDoctorWorkByDRWT(page, pageSize, code, count, date, time);
	}

	
	//分页
	public List<Map<String,String>> queryDataNum() {
		return doctorWorkRepository.queryDateNum();
	}
	public List<Map<String,String>> queryDataNumByD(String code) {
		return doctorWorkRepository.queryDataNumByD(code);
	}

	public List<Map<String,String>> queryDataNumByR(String count) {
		return doctorWorkRepository.queryDataNumByR(count);
	}

	public List<Map<String,String>> queryDataNumByW( String date) {
		return doctorWorkRepository.queryDataNumByW(date);
	}

	public List<Map<String,String>> queryDataNumByT( String time) {
		return doctorWorkRepository.queryDataNumByT(time);
	}

	public List<Map<String,String>> queryDataNumByRW( String count, String date) {
		return doctorWorkRepository.queryDataNumByRW(count, date);
	}

	public List<Map<String,String>> queryDataNumByRT(String count, String time) {
		return doctorWorkRepository.queryDataNumByRT(count, time);
	}

	public List<Map<String,String>> queryDataNumByWT(String date, String time) {
		return doctorWorkRepository.queryDataNumByWT(date, time);
	}

	public List<Map<String,String>> queryDataNumByDR( String code, String count) {
		return doctorWorkRepository.queryDataNumByDR(code, count);
	}

	public List<Map<String,String>> queryDataNumByDW( String code, String date) {
		return doctorWorkRepository.queryDataNumByDW(code, date);
	}

	public List<Map<String,String>> queryDataNumByDT(String code, String time) {
		return doctorWorkRepository.queryDataNumByDT(code, time);
	}

	public List<Map<String,String>> queryDataNumByDRW(String code, String count, String date) {
		return doctorWorkRepository.queryDataNumByDRW(code, count, date);
	}

	public List<Map<String,String>> queryDataNumByDRT(String code, String count, String time) {
		return doctorWorkRepository.queryDataNumByDRT( code, count, time);
	}

	public List<Map<String,String>> queryDataNumByDWT( String code, String date, String time) {
		return doctorWorkRepository.queryDataNumByDWT(code, date, time);
	}

	public List<Map<String,String>> queryDataNumByRWT(String count, String date, String time) {
		return doctorWorkRepository.queryDataNumByRWT(count, date, time);
	}

	public List<Map<String,String>> queryDataNumByDRWT(String code, String count, String date,
			String time) {
		return doctorWorkRepository.queryDataNumByDRWT(code, count, date, time);
	}

	 
}
