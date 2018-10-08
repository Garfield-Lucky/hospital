package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Prescription;
import org.wu.work.repository.RepositorySupport;

@Repository("prescriptionRepository")
public class PrescriptionRepository extends RepositorySupport<Prescription> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有处方单
	public List<Prescription> queryAllRegister(){
		 
		return this.findAll();
 
	}
	
//	查询处方单
	public Prescription queryPrescriptionById(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Prescription.class);
		detachedCriteria.add(Restrictions.eq("id", id));
		System.out.println("id="+id);
		return this.findOne(detachedCriteria);
 
	}
	//查询刚刚添加的处方单
	public List<Map<String,String>> queryAddPresList(int page,int pageSize,String vistId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	
	//分页（vistId）(添加处方单页面)
	public List<Map<String,String>> queryDataNum(String vistId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	
	//摆药员查看处方单药品列表
	public List<Map<String,String>> queryMedicineList(int page,int pageSize,String vistId){
		String sql = "select p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,p.createTime,p.remark from tb_prescription p,tb_register r,tb_patient pa where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.status = 1" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	//摆药员查看处方单药品列表（分页）
	public List<Map<String,String>> queryMedicineList(String vistId){
		String sql = "select p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,p.createTime,p.remark from tb_prescription p,tb_register r,tb_patient pa where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.status = 1" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	
	//处方单列表
	public List<Map<String,String>> queryPrescriptionList(int page,int pageSize,String code){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and p.doctorCode =:code and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3 order by p.createTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"code"}, code);
		return list;
	}
	
	//初始化摆药列表
	public List<Map<String,String>> queryPresList(int page,int pageSize){
		String sql = "select distinct p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status,pa.userId from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status  =1 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
		return list;
 
	}
	//初始化摆药列表（分页）
	public List<Map<String,String>> queryPresList(){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status  =1 " ;
		List<Map<String,String>> list = this.executeSql(sql);
		return list;
	}
	//处方单管理
	//通过挂号序号查找摆药单
	public List<Map<String,String>> queryPresListV(int page,int pageSize,String vistId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.vistId =:vistId and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3 order by p.createTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId"}, vistId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListU(int page,int pageSize,String userId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.userId =:userId and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3 order by p.createTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId"}, userId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListVU(int page,int pageSize,String vistId,String userId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.vistId =:vistId and r.userId =:userId and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3 order by p.createTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId","userId"}, vistId,userId);
		return list;
 
	}
	public List<Prescription> queryPrescriptionByVistId(String vistId){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Prescription.class);
		detachedCriteria.add(Restrictions.eq("vistId", vistId));
		detachedCriteria.add(Restrictions.eq("status", 1));
		System.out.println("vistId="+vistId);
		return this.findAll(detachedCriteria);
 
	}
	//药房管理
	//通过挂号序号查找摆药单
	public List<Map<String,String>> queryPresListBaiYaoByVistId(int page, int pageSize,String vistId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status,pa.userId from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and p.vistid =:vistId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId"}, vistId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListBaiYaoByUserId(int page, int pageSize,String userId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status,pa.userId  from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and pa.userId =:userId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId"}, userId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListBaiYaoByVU(int page, int pageSize,String vistId,String userId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status,pa.userId  from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and p.vistid =:vistId and pa.userId =:userId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId","userId"}, vistId,userId);
		return list;
 
	}
	//通过挂号序号查找摆药单（分页）
	public List<Map<String,String>> queryPresListBaiYaoByVistId(String vistId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and p.vistid =:vistId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListBaiYaoByUserId(String userId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and pa.userId =:userId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"}, userId);
		return list;
 
	}
	public List<Map<String,String>> queryPresListBaiYaoByVU(String vistId,String userId){
		String sql = "select distinct  p.vistid,pa.userName,pa.sex,pa.age,o.officeType,d.doctorName,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and p.vistid =:vistId and pa.userId =:userId and  r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <>3 " ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId","userId"}, vistId,userId);
		return list;
 
	}
	
	//通过挂号序号查找对应的处方单
	public List<Map<String,String>> queryPresByVistId(int page, int pageSize, String vistId) {
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	
	//划价
	public List<Map<String,String>> queryFeeListByVistId(int page, int pageSize, String vistId) {
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,m.price from tb_prescription p,tb_register r,tb_patient pa,tb_medicine m where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.medicinName = m.medicineName and p.medicineSpec =m.medicineSpec and p.status = 0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	public List<Map<String,String>> queryFeeByVistId(String vistId) {
		String sql = "select distinct p.status,sum(m.price*p.count),pa.balanceMedical,count(*) from tb_prescription p,tb_register r,tb_patient pa,tb_medicine m where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.medicinName = m.medicineName and p.medicineSpec =m.medicineSpec and p.status = 0 group by p.medicinName" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	
	//划价收费（分页）
	public List<Map<String,String>> getFeeListByVistId(String vistId) {
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName item,p.medicineSpec,p.count,m.price from tb_prescription p,tb_register r,tb_patient pa,tb_medicine m where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.medicinName = m.medicineName and p.medicineSpec =m.medicineSpec and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId"}, vistId);
		return list;
	}
	//查询数据保存进划价收费表
	public List<Map<String,String>> queryFeeListByVistId(String vistId) {
		String sql = "select pa.userName,p.medicinName,p.medicineSpec,p.count,m.price,p.id from tb_prescription p,tb_register r,tb_patient pa,tb_medicine m where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.medicinName = m.medicineName and p.medicineSpec =m.medicineSpec and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	
	//分页（处方单管理列表）
	public List<Map<String,String>> queryDataNumByCode(String doctorCode){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and p.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"doctorCode"}, doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and r.vistId=:vistId and p.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId","doctorCode"},vistId,doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByUserId(String userId,String doctorCode){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and pa.userId=:userId and p.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId","doctorCode"}, userId,doctorCode);
		return list;
	}
	public List<Map<String,String>> queryDataNumByUV(String userId,String vistId,String doctorCode){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where p.vistid =r.vistid and r.userid = pa.userid and pa.userId=:userId and r.vistId=:vistId and p.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status <> 3" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId","vistId","doctorCode"}, userId,vistId,doctorCode);
		return list;
	}
	
	//划价收费（分页）
	public List<Map<String,String>> queryDataNumByVistId(String vistId) {
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,m.price from tb_prescription p,tb_register r,tb_patient pa,tb_medicine m where p.vistid =r.vistid and r.userid = pa.userid and p.vistid =:vistId and p.medicinName = m.medicineName and p.medicineSpec =m.medicineSpec and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	
	//用户处方单
	public List<Map<String,String>> queryPresListByUser(int page,int pageSize,String userId,String stime,String etime){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.userId =:userId and p.createTime between :stime and :etime and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status =1" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId","stime","etime"}, userId,stime,etime);
		return list;
	}
	public List<Map<String,String>> queryPresListByUser(int page,int pageSize,String userId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.userId =:userId and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status =1" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId"}, userId);
		return list;
	}
	//分页（用户处方单）
	public List<Map<String,String>> queryPresListByUser(String userId,String stime,String etime){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.userId =:userId and p.createTime between :stime and :etime and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status =1" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId","stime","etime"}, userId,stime,etime);
		return list;
	}
	public List<Map<String,String>> queryPresListByUser(String userId){
		String sql = "select p.id,p.vistid,pa.userName,pa.sex,pa.age,p.medicinName,p.medicineSpec,p.count,o.officeType,d.doctorName,p.createTime,p.remark,p.status from tb_prescription p,tb_register r,tb_patient pa,tb_office o,tb_doctor d where r.userId =:userId and p.vistid =r.vistid and r.userid = pa.userid and r.office =o.officeCode and d.doctorCode =p.doctorCode and p.status =1" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"}, userId);
		return list;
	}
  //	保存处方单
	public Prescription savePrescription(Prescription pres) {
		try {
			return this.save(pres);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除处方单
	public boolean deletePrescription(Prescription pres) {
		if (pres == null) {
			return false;
		}
		try {
			this.delete(pres);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
