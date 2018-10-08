package org.wu.work.repository.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Office;
import org.wu.work.repository.RepositorySupport;

@Repository("officeRepository")
public class OfficeRepository extends RepositorySupport<Office> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	public Office queryOfficeByCode(String officeCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("officeCode", officeCode));
		System.out.println("officeCode="+officeCode);
		return this.findOne(detachedCriteria);
 
	}
	
	public Office queryOfficeById(Integer id){
		 
		return this.findOne(id);
 
	}
	public Office saveOfficeType(Office office) {
		try {
			return this.save(office);
		} catch (Exception e) {
			return null;
		}
	}
	
	//管理员查询科室信息
	public List<Office> queryOfficeList(int page,int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<Office> queryOfficeByCode(int page,int pageSize,String officeCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("officeCode", officeCode));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<Office> queryOfficeByType(int page,int pageSize,String officeType){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("officeType", officeType));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	
	//分页
	public List<Office> queryDataNum(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria);
 
	}
	public List<Office> queryDataNumByCode(String officeCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("officeCode", officeCode));
		return this.findAll(detachedCriteria);
 
	}
	public List<Office> queryDataNumByType(String officeType){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Office.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("officeType", officeType));
		return this.findAll(detachedCriteria);
 
	}
	public boolean deleteOffice(Office office) {
		if (office == null) {
			return false;
		}
		try {
			this.delete(office);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
