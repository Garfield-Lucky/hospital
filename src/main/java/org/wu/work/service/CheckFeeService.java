package org.wu.work.service;


import java.util.List;

import org.wu.work.entity.CheckFee;

public interface CheckFeeService {
	
	public List<CheckFee> queryCheckFeeList(int page,int pageSize);
	public List<CheckFee> queryCheckFeeByCode(int page,int pageSize,String checkCode);
	public List<CheckFee> queryCheckFeeByType(int page,int pageSize,String checkItem);
	public List<CheckFee> findCheckItem(String checkItem); //模糊查询
	public List<CheckFee> findCheckType(String checkType);
	public CheckFee queryCheckFeeByCode(String id);
	public CheckFee insertCheckFee(CheckFee check);
	public CheckFee modifyCheckFee(CheckFee check);
	public CheckFee queryCheckFeeByCode(CheckFee check);
	public boolean deleteCheckFee(CheckFee check);
	public CheckFee changStatus(CheckFee check);
	
	public List<CheckFee> queryDataNum();
	public List<CheckFee> queryDataNumByCode(String checkCode);
	public List<CheckFee> queryDataNumByName(String checkItem);
	
}
