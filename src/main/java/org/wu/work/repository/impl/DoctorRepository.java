package org.wu.work.repository.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Doctor;
import org.wu.work.repository.RepositorySupport;

@Repository("doctorRepository")
public class DoctorRepository extends RepositorySupport<Doctor> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有医生
	public List<Doctor> queryAllDoctor(){
		 
		return this.findAll();
 
	}
	
//	查询医生
	public Doctor queryDoctorByCode(String code){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("doctorCode", code));
		System.out.println("doctorCode="+code);
		return this.findOne(detachedCriteria);
 
	}
	
	//管理员查看医生信息列表
	public List<Doctor> queryDoctorList(int page,int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		System.out.println("page="+page+"kk"+"pageSize="+pageSize);
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<Doctor> queryDoctorByCode(int page,int pageSize,String doctorCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("doctorCode", doctorCode));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<Doctor> queryDoctorByName(int page,int pageSize,String doctorName){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("doctorName", doctorName));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	
	//分页删除
	public List<Doctor> queryDataNum(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria);
 
	}
	public List<Doctor> queryDataNumByCode(String doctorCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("doctorCode", doctorCode));
		return this.findAll(detachedCriteria);
 
	}
	public List<Doctor> queryDataNumByName(String doctorName){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("doctorName", doctorName));
		return this.findAll(detachedCriteria);
 
	}
	
	public Doctor queryDoctorByUserId(String userId){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Doctor.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("doctorCode", userId));
		return this.findOne(detachedCriteria);
 
	}
	
  //	保存医生
	public Doctor saveDoctor(Doctor doctor) {
		try {
			return this.save(doctor);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除医生
	public boolean deleteDoctor(Doctor doctor) {
		if (doctor == null) {
			return false;
		}
		try {
			this.delete(doctor);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
