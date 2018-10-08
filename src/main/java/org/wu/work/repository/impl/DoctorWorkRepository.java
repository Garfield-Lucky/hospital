package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.DoctorWork;
import org.wu.work.repository.RepositorySupport;

@Repository("doctorWorkRepository")
public class DoctorWorkRepository extends RepositorySupport<DoctorWork> {

	 
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有检查项目名
	public List<DoctorWork> queryAllDoctorWork(){
		 
		return this.findAll();
 
	}
	
//	查询检查
	public DoctorWork queryDoctorWorkById(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DoctorWork.class);
		detachedCriteria.add(Restrictions.eq("id", id));
		System.out.println("id="+id);
		return this.findOne(detachedCriteria);
 
	}
	
//	查询检查
	public List<DoctorWork> queryDoctorWorkByCode(String code){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DoctorWork.class);
		detachedCriteria.add(Restrictions.eq("doctorCode", code));
		System.out.println("doctorCode="+code);
		return this.findAll(detachedCriteria);
 
	}
	
//	预约挂号时检查该医生是否可以挂号
	public List<Map<String,String>> queryDoctorWorkByCodeAndDate(String code,String date){
		String sql = "select dw.id,dw.doctorCode,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw where dw.doctorCode =:code and dw.workDate =:date and dw.status =0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","date"},code,date);
		return list;
	}
	
	public List<Map<String,String>> queryDoctorWorkByCode(int page,int pageSize,String code){
		String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code"},code);
		return list;
 
	}
	
	public List<Map<String,String>> queryDoctorWorkList(int page,int pageSize){
		String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0 and dw.workDate >= date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
		return list;
 
	}
	
  //	保存检查
	public DoctorWork saveDoctorWork(DoctorWork work) {
		try {
			return this.save(work);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除检查
	public boolean deleteDoctorWork(DoctorWork work) {
		if (work == null) {
			return false;
		}
		try {
			this.delete(work);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 

//医生值班列表查询
//1
public List<Map<String,String>> queryDoctorWorkByD(int page,int pageSize,String code){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code"},code);
	return list;

}
//2
public List<Map<String,String>> queryDoctorWorkByR(int page,int pageSize,String count){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"count"},count);
	return list;

}
//3
public List<Map<String,String>> queryDoctorWorkByW(int page,int pageSize,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"date"},date);
	return list;

}
//4
public List<Map<String,String>> queryDoctorWorkByT(int page,int pageSize,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"time"},time);
	return list;

}
//5
public List<Map<String,String>> queryDoctorWorkByRW(int page,int pageSize,String count,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"count","date"},count,date);
	return list;

}
//6
public List<Map<String,String>> queryDoctorWorkByRT(int page,int pageSize,String count,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"count","time"},count,time);
	return list;

}
//7
public List<Map<String,String>> queryDoctorWorkByWT(int page,int pageSize,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"date","time"},date,time);
	return list;

}
//8
public List<Map<String,String>> queryDoctorWorkByDR(int page,int pageSize,String code,String count){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","count"},code,count);
	return list;

}
//9
public List<Map<String,String>> queryDoctorWorkByDW(int page,int pageSize,String code,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","date"},code,date);
	return list;

}
//10
public List<Map<String,String>> queryDoctorWorkByDT(int page,int pageSize,String code,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","time"},code,time);
	return list;

}
//11
public List<Map<String,String>> queryDoctorWorkByDRW(int page,int pageSize,String code,String count,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","count","date"},code,count,date);
	return list;

}
//12
public List<Map<String,String>> queryDoctorWorkByDRT(int page,int pageSize,String code,String count,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","count","time"},code,count,time);
	return list;

}
//13
public List<Map<String,String>> queryDoctorWorkByDWT(int page,int pageSize,String code,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","date","time"},code,date,time);
	return list;

}
//14
public List<Map<String,String>> queryDoctorWorkByRWT(int page,int pageSize,String count,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"count","date","time"},count,date,time);
	return list;

}
//15
public List<Map<String,String>> queryDoctorWorkByDRWT(int page,int pageSize,String code,String count,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"code","count","date","time"},code,count,date,time);
	return list;

}

//分页
public List<Map<String,String>> queryDateNum(){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0 and dw.workDate >= date_format(curdate(),'%Y-%m-%d' )" ;
	List<Map<String,String>> list = this.executeSql(sql);
	return list;

}
//1
public List<Map<String,String>> queryDataNumByD(String code){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql, new String[]{"code"},code);
	return list;

}
//2
public List<Map<String,String>> queryDataNumByR(String count){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"count"},count);
	return list;

}
//3
public List<Map<String,String>> queryDataNumByW(String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"date"},date);
	return list;

}
//4
public List<Map<String,String>> queryDataNumByT(String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"time"},time);
	return list;

}
//5
public List<Map<String,String>> queryDataNumByRW(String count,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"count","date"},count,date);
	return list;

}
//6
public List<Map<String,String>> queryDataNumByRT(String count,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"count","time"},count,time);
	return list;

}
//7
public List<Map<String,String>> queryDataNumByWT(String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"date","time"},date,time);
	return list;

}
//8
public List<Map<String,String>> queryDataNumByDR(String code,String count){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","count"},code,count);
	return list;

}
//9
public List<Map<String,String>> queryDataNumByDW(String code,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","date"},code,date);
	return list;

}
//10
public List<Map<String,String>> queryDataNumByDT(String code,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","time"},code,time);
	return list;

}
//11
public List<Map<String,String>> queryDataNumByDRW(String code,String count,String date){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workDate =:date and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","count","date"},code,count,date);
	return list;

}
//12
public List<Map<String,String>> queryDataNumByDRT(String code,String count,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","count","time"},code,count,time);
	return list;

}
//13
public List<Map<String,String>> queryDataNumByDWT(String code,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","date","time"},code,date,time);
	return list;

}
//14
public List<Map<String,String>> queryDataNumByRWT(String count,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.registerCount =:count and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"count","date","time"},count,date,time);
	return list;

}
//15
public List<Map<String,String>> queryDataNumByDRWT(String code,String count,String date,String time){
	String sql = "select dw.id,dw.doctorCode,d.doctorName,o.officeType,dw.workDate,dw.workTime,dw.registerCount,dw.reaminCount from tb_doctorWork dw,tb_office o,tb_doctor d where dw.doctorCode =:code and dw.registerCount =:count and dw.workDate =:date and dw.workTime =:time and dw.doctorCode =d.doctorCode and d.officeCode = o.officeCode and dw.status =0" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"code","count","date","time"},code,count,date,time);
	return list;

}

}
