package org.wu.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.CheckFee;
import org.wu.work.repository.impl.CheckFeeRepository;
import org.wu.work.service.CheckFeeService;

@SuppressWarnings("restriction")
@Service("checkFeeService")
public class CheckFeeServiceImpl implements CheckFeeService{

	@Resource
	private CheckFeeRepository checkFeeRepository;
	
	public CheckFee queryCheckFeeByCode(String id) {
		return checkFeeRepository.queryCheckFeeByCode(id);
	}

	public CheckFee insertCheckFee(CheckFee check) {
		return checkFeeRepository.saveCheckFee(check);
	}

	public CheckFee modifyCheckFee(CheckFee check) {
		return checkFeeRepository.saveCheckFee(check);
	}

	public CheckFee queryCheckFeeByCode(CheckFee check) {
		return null;
	}

	public boolean deleteCheckFee(CheckFee check) {
		return checkFeeRepository.deleteCheckFee(check);
	}

	public CheckFee changStatus(CheckFee check) {
		return checkFeeRepository.saveCheckFee(check);
	}

	public List<CheckFee> queryCheckFeeList(int page, int pageSize) {
		return checkFeeRepository.queryCheckFeeList(page, pageSize);
	}

	public List<CheckFee> queryCheckFeeByCode(int page, int pageSize, String checkCode) {
		return checkFeeRepository.queryCheckFeeByCode(page, pageSize, checkCode);
	}

	public List<CheckFee> queryCheckFeeByType(int page, int pageSize, String checkItem) {
		return checkFeeRepository.queryCheckFeeByType(page, pageSize, checkItem);
	}

	//分页
	public List<CheckFee> queryDataNum() {
		return checkFeeRepository.queryDataNum();
	}
	public List<CheckFee> queryDataNumByCode(String checkCode) {
		return checkFeeRepository.queryDataNumByCode(checkCode);
	}
	public List<CheckFee> queryDataNumByName(String checkItem) {
		return checkFeeRepository.queryDataNumByName(checkItem);
	}

	public List<CheckFee> findCheckItem(String checkItem) {
		return checkFeeRepository.findCheckItem(checkItem);
	}

	public List<CheckFee> findCheckType(String checkType) {
		return checkFeeRepository.findCheckType(checkType);
	}

	 
}
