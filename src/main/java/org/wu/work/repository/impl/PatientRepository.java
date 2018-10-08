package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Patient;
import org.wu.work.repository.RepositorySupport;

@Repository("patientRepository")
public class PatientRepository extends RepositorySupport<Patient> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有病人信息
	public List<Patient> queryAllPatient(){
		 
		return this.findAll();
 
	}
	
	//返回符合条件的数据条数，用以分页查询
	public List<Map<String,String>> queryDataNum(){
		String sql = "select p.userId from tb_patient p  where  p.status =0 order by p.createTime" ;
		List<Map<String,String>> list = this.executeSql(sql);
		return list;
 
	}
	public List<Map<String,String>> queryDataNumById(String userId){
		String sql = "select p.userId from tb_patient p  where  p.status =0 and p.userId=:userId order by p.createTime" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"}, userId);
		return list;
 
	}
	public List<Map<String,String>> queryDataNumByName(String userName){
		String sql = "select p.userId from tb_patient p  where  p.status =0 and p.userName =:userName order by p.createTime" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userName"}, userName);
		return list;
 
	}
	
//	查询病人基本信息
	public Patient queryPatientById(String userId){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Patient.class);
		detachedCriteria.add(Restrictions.eq("userId", userId));
		System.out.println("userId="+userId);
		return this.findOne(detachedCriteria);
 
	}
	
	public List<Map<String,String>> queryPatientList(int page,int pageSize){
		String sql = "select p.userId,p.userName,p.sex,p.age,p.medicalNum,p.balanceMedical,p.nation,p.address,p.phone,p.idCard,p.marry,p.createTime,p.remark from tb_patient p  where  p.status =0 order by p.createTime" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page,pageSize);
		return list;
 
	}
	public List<Map<String,String>> queryPatientByUserId(int page,int pageSize,String userId){
		String sql = "select p.userId,p.userName,p.sex,p.age,p.medicalNum,p.balanceMedical,p.nation,p.address,p.phone,p.idCard,p.marry,p.createTime,p.remark from tb_patient p  where p.userId =:userId and p.status =0 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize, new String[]{"userId"}, userId);
		return list;
 
	}
	public List<Map<String,String>> queryPatientByUserName(int page,int pageSize,String userName){
		String sql = "select p.userId,p.userName,p.sex,p.age,p.medicalNum,p.balanceMedical,p.nation,p.address,p.phone,p.idCard,p.marry,p.createTime,p.remark from tb_patient p  where p.userName =:userName and p.status =0 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize, new String[]{"userName"}, userName);
		return list;
 
	}
	//管理员查看指定患者信息
//	public List<Patient> queryPatientByUserId(String userId){
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Patient.class);
//		detachedCriteria.add(Restrictions.eq("userId", userId));
//		return this.findAll(detachedCriteria);
// 
//	}
	
	public List<Map<String,String>> queryPatientByUserId(String userId){
		String sql = "select p.userName,p.sex,p.age,p.medicalNum,p.balanceMedical,p.phone,p.idCard,p.createTime,p.userId from tb_patient p  where p.userId =:userId and p.status =0 " ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId"}, userId);
		return list;
 
	}
	
	//查询该医生所有未就诊完成的患者信息
	public List<Map<String,String>> queryPatientListToDoctor(int page,int pageSize,String code){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.doctorCode = :code AND p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"code"}, code);
		return list;
	}
	
	//医生通过挂号序号查询患者详细信息
	public List<Map<String,String>> queryPatientByVistId(int page,int pageSize,String code,String vistId){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.doctorCode = :code and r.vistId =:vistId and p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"code","vistId"}, code,vistId);
		return list;
	}
	//医生通过用户名查询患者详细信息
	public List<Map<String,String>> queryPatientByUserName(int page,int pageSize,String code,String userName){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.doctorCode = :code and p.userName =:userName and p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"code","userName"}, code,userName);
		return list;
	}
	//医生通过挂号序号和用户名查询患者详细信息
	public List<Map<String,String>> queryPatientByVU(int page,int pageSize,String code,String vistId,String userName){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.doctorCode = :code and r.vistId =:vistId and p.userName =:userName and p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"code","vistId","userName"}, code,vistId,userName);
		return list;
	}
	
	//分页
	//医生工作站，所有未就诊完成的患者列表
	public List<Map<String,String>> queryDataNum(String doctorCode){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.doctorCode = :doctorCode AND p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"doctorCode"}, doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and r.vistId =:vistId and r.doctorCode = :doctorCode AND p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId","doctorCode"},vistId, doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByUserName(String userName,String doctorCode){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and p.userName =:userName and r.doctorCode = :doctorCode  AND p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userName","doctorCode"},userName, doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByUV(String userName,String vistId,String doctorCode){
		String sql = "select r.vistid,p.userName,p.sex,p.age,p.phone,p.marry,p.address from tb_register r,tb_patient p,tb_doctor d  where p.userId =r.userId and d.doctorCode =r.doctorCode and p.userName =:userName and r.vistId =:vistId and r.doctorCode = :doctorCode AND p.status =0 and r.status =0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userName","vistId","doctorCode"},userName,vistId, doctorCode);
		return list;
	}
	
  //	保存病人基本信息
	public Patient savePatient(Patient patient) {
		try {
			return this.save(patient);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除病人信息
	public boolean deletePatient(Patient patient) {
		if (patient == null) {
			return false;
		}
		try {
			this.delete(patient);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
