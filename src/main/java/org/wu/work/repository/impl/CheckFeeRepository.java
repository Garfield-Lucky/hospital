package org.wu.work.repository.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.CheckFee;
import org.wu.work.repository.RepositorySupport;

@Repository("checkFeeRepository")
public class CheckFeeRepository extends RepositorySupport<CheckFee> {

	 
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有检查项目名
	public List<CheckFee> queryAllCheckFee(){
		 
		return this.findAll();
 
	}
	
//	查询检查
	public CheckFee queryCheckFeeByCode(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("checkCode", id));
		System.out.println("checkCode="+id);
		return this.findOne(detachedCriteria);
 
	}
	
	//管理员查看检查费用列表
	public List<CheckFee> queryCheckFeeList(int page,int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<CheckFee> queryCheckFeeByCode(int page,int pageSize,String checkCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("checkCode", checkCode));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<CheckFee> queryCheckFeeByType(int page,int pageSize,String checkItem){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("checkItem", checkItem));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	//模糊查询
	public List<CheckFee> findCheckItem(String checkItem){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.like("checkItem", '%'+checkItem+'%'));
		return this.findAll(detachedCriteria, 0, 1000);
 
	}
	//检查检查单的检查项目是否存在
	public List<CheckFee> findCheckType(String checkType){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.like("checkItem", checkType));
		return this.findAll(detachedCriteria, 0, 1000);
 
	}
	
	//分页
	public List<CheckFee> queryDataNum(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria);
 
	}
	public List<CheckFee> queryDataNumByCode(String checkCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("checkCode", checkCode));
		return this.findAll(detachedCriteria);
 
	}
	public List<CheckFee> queryDataNumByName(String checkItem){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CheckFee.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("checkItem", checkItem));
		return this.findAll(detachedCriteria);
 
	}
	
  //	保存检查
	public CheckFee saveCheckFee(CheckFee check) {
		try {
			return this.save(check);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除检查
	public boolean deleteCheckFee(CheckFee check) {
		if (check == null) {
			return false;
		}
		try {
			this.delete(check);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
