package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Check;
import org.wu.work.repository.RepositorySupport;

@Repository("checkRepository")
public class CheckRepository extends RepositorySupport<Check> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有检查
	public List<Check> queryAllCheck(){
		 
		return this.findAll();
 
	}
	
//	查询检查
	public Check queryCheckById(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Check.class);
		detachedCriteria.add(Restrictions.eq("id", id));
		System.out.println("id="+id);
		return this.findOne(detachedCriteria);
 
	}
	
	//医生查询刚刚添加的检查单
	public List<Map<String,String>> queryAddCheckListV(int page,int pageSize,String vistId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	public List<Map<String,String>> queryAddCheckListU(int page,int pageSize,String userId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userId"}, userId);
		return list;
	}
	public List<Map<String,String>> queryAddCheckListVU(int page,int pageSize,String vistId,String userId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId","userId"}, vistId,userId);
		return list;
	}
	
    //检查室根据输入条件查看检查列表
	public List<Map<String,String>> queryCheckListV(int page,int pageSize,String vistId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,p.userId from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2 " ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	public List<Map<String,String>> queryCheckListU(int page,int pageSize,String userName){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,p.userId from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userName"}, userName);
		return list;
	}
	public List<Map<String,String>> queryCheckListVU(int page,int pageSize,String vistId,String userName){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,p.userId from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId","userName"}, vistId,userName);
		return list;
	}
	//检查单列表
	public List<Map<String,String>> queryCheckList(int page,int pageSize,String code){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.doctorCode =:code and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 order by c.createTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"code"}, code);
		return list;
 
	}
	
	//检查室检查单管理
	public List<Map<String,String>> queryCheckResultListV(int page,int pageSize,String vistId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	public List<Map<String,String>> queryCheckResultListU(int page,int pageSize,String userName){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userName"}, userName);
		return list;
	}
	public List<Map<String,String>> queryCheckResultListVU(int page,int pageSize,String vistId,String userName){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId","userName"}, vistId,userName);
		return list;
	}
	//检查室查询检查单列表(默认)
	public List<Map<String,String>> queryCheckListInCRoom(int page,int pageSize){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,p.userId from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid  and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status =1" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
		return list;
 
	}
	
	
	//检查室通过挂号序号查询检查单
	public List<Map<String,String>> queryCheckListInCRoom(int page,int pageSize,String vistId){
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and c.vistId =:vistId and r.userid = p.userid and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,new String[]{"vistId"}, vistId);
		return list;
 
	}
	
	
	//通过挂号序号查找对应的检查单
	public List<Map<String,String>> queryCheckByVistId(int page, int pageSize, String vistId) {
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	
	//划价
	public List<Map<String,String>> queryFeeListByVistId(int page, int pageSize, String vistId) {
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,c.checkType,cf.expend from tb_Check c,tb_register r,tb_patient p,tb_checkFee cf where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and cf.checkItem = c.checkType and c.status = 0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
		return list;
	}
	public List<Map<String,String>> queryFeeByVistId(String vistId) {
		String sql = "select distinct c.status,sum(cf.expend),p.balanceMedical,count(*) from tb_Check c,tb_register r,tb_patient p,tb_checkFee cf where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and cf.checkItem = c.checkType and c.status = 0 group by p.balanceMedical" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId"}, vistId);
		return list;
	}
	//划价收费
	public List<Map<String,String>> getFeeListByVistId(String vistId) {
		String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,c.checkType item,cf.expend from tb_Check c,tb_register r,tb_patient p,tb_checkFee cf where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and cf.checkItem = c.checkType and c.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
		return list;
	}
	//查询数据保存进划价收费表
	public List<Map<String,String>> queryFeeListByVistId(String vistId) {
		String sql = "select p.userName,c.checkType,cf.expend,c.id from tb_Check c,tb_register r,tb_patient p,tb_checkFee cf where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and cf.checkItem = c.checkType and c.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId"}, vistId);
		return list;
	}
	
	//查看检查结果
	 public List<Map<String,String>> queryCheckResult(String id){
			String sql = "select c.vistId,p.userName,p.sex,p.age,c.checkTime from tb_register r,tb_check c,tb_patient p where c.id =:id and r.vistId =c.vistId and p.userId =r.userid and (c.status = 2)" ; 
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"id"}, id);
			return list;
		}
	 
	 //检查室检查单管理列表(默认查找)
	 public List<Map<String,String>> queryCheckResultList(int page, int pageSize) {
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
			return list;
		}
	 //检查检验室检查结果单管理（分页）
	 public List<Map<String,String>> queryCheckResultDataNum() {
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2" ;
			List<Map<String,String>> list = this.executeSql(sql);
			return list;
		}
	//检查室根据条件查找检查单
		public List<Map<String,String>> queryAddCheckResultListV(int page,int pageSize,String vistId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status =2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId"}, vistId);
			return list;
		}
		public List<Map<String,String>> queryAddCheckResultListU(int page,int pageSize,String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userId"}, userId);
			return list;
		}
		public List<Map<String,String>> queryAddCheckResultListVU(int page,int pageSize,String vistId,String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"vistId","userId"}, vistId,userId);
			return list;
		}
		//检查结果单（分页）
		public List<Map<String,String>> queryAddCheckResultListV(String vistId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId"}, vistId);
			return list;
		}
		public List<Map<String,String>> queryAddCheckResultListU(String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"}, userId);
			return list;
		}
		public List<Map<String,String>> queryAddCheckResultListVU(String vistId,String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkResult,c.checkTime from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 2 order by c.checkTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId","userId"}, vistId,userId);
			return list;
		}
		
		//分页（添加检查单页面）
		public List<Map<String,String>> queryDataNum(String vistId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
			return list;
		}
		
		//分页（检查单管理页面）
		public List<Map<String,String>> queryDataNumByCode(String doctorCode){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"doctorCode"}, doctorCode);
			return list;
		}
		public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.vistId = :vistId and c.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId","doctorCode"},vistId, doctorCode);
			return list;
		}
		public List<Map<String,String>> queryDataNumByUserId(String userId,String doctorCode){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and p.userId =:userId and c.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId","doctorCode"}, userId,doctorCode);
			return list;
		}
		public List<Map<String,String>> queryDataNumByUV(String userId,String vistId,String doctorCode){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and p.userId =:userId and r.vistId = :vistId and c.doctorCode =:doctorCode and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId","vistId","doctorCode"},userId,vistId, doctorCode);
			return list;
		}
		
		//划价收费（分页）
		public List<Map<String,String>> queryDataNumByVistId(String vistId) {
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,c.checkType,cf.expend from tb_Check c,tb_register r,tb_patient p,tb_checkFee cf where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and cf.checkItem = c.checkType and c.status = 0" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
			return list;
		}
		
		//检查检验（分页）
		public List<Map<String,String>> queryCheckListInCRoom(){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status = 1 order by c.createTime" ;
			List<Map<String,String>> list = this.executeSql(sql);
			return list;
	 
		}
		
		//检查检验室查询（分页）
		public List<Map<String,String>> findDataNumByVistId(String vistId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"}, vistId);
			return list;
		}
		public List<Map<String,String>> findDataNumByUserName(String userName){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"userName"}, userName);
			return list;
		}
		public List<Map<String,String>> findDataNumByVU(String vistId,String userName){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and c.vistId =:vistId and p.userName =:userName and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 and c.status <>2" ;
			List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId","userName"}, vistId,userName);
			return list;
		}
		
		//用户查看自己的检查单
		public List<Map<String,String>> queryCheckListByUser(int page,int pageSize,String userId,String stime,String etime){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and c.createTime between :stime and :etime and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 order by c.createTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userId","stime","etime"}, userId,stime,etime);
			return list;
		}
		public List<Map<String,String>> queryCheckListByUser(int page,int pageSize,String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult,p.userId,c.checkPhoto from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <>3 order by c.createTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"userId"}, userId);
			return list;
		}
		public List<Map<String,String>> queryCheckListByUser(String userId,String stime,String etime){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and c.createTime between :stime and :etime and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <> 3 order by c.createTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId","stime","etime"}, userId,stime,etime);
			return list;
		}
		public List<Map<String,String>> queryCheckListByUser(String userId){
			String sql = "select c.id,c.vistid,p.userName,p.sex,p.age,o.officeType,d.doctorName,c.createTime,c.checkType,c.specimenType,c.checkPlace,c.checkMethod,c.checkPerson,c.status,c.checkTime,c.checkResult from tb_Check c,tb_register r,tb_patient p,tb_office o,tb_doctor d where c.vistid =r.vistid and r.userid = p.userid and r.userId =:userId and r.office =o.officeCode and d.doctorCode =c.doctorCode and c.status <>3 order by c.createTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId"}, userId);
			return list;
		}
  //	保存检查
	public Check saveCheck(Check check) {
		try {
			return this.save(check);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除检查
	public boolean deleteCheck(Check check) {
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
