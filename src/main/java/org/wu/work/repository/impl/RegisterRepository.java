package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Register;
import org.wu.work.repository.RepositorySupport;

@Repository("registerRepository")
public class RegisterRepository extends RepositorySupport<Register> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有挂号单
	public List<Register> queryAllRegister(){
		 
		return this.findAll();
 
	}
	
//	查询挂号单
	public Register queryRegisterById(String vistId){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Register.class);
		detachedCriteria.add(Restrictions.eq("vistId", vistId));
		System.out.println("vistId="+vistId);
		return this.findOne(detachedCriteria);
 
	}
	//检查该用户是否已经挂过该医生当天的号
	public List<Map<String,String>> queryRegisterByUserId(String userId,String doctorCode,String officeCode,String workDate){
		 
		String sql = "select * from tb_register where userId =:userId and (doctorCode = :doctorCode or office = :officeCode) and seeTime = :workDate and status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId","doctorCode","officeCode","workDate"}, userId,doctorCode,officeCode,workDate);
		return list;
	}
	
	//预约挂号列表
	public List<Map<String,String>> queryRegisterList(int page,int pageSize){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode,dw.workTime,o.officeCode  from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY order by dw.workDate" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
		return list;
		}
	
	//根据科室类型查询挂号列表
	public List<Map<String,String>> queryRegisterListByType(String officeType,int page,int pageSize){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode,dw.workTime,o.officeCode  from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and o.officeType =:officeType and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY order by dw.workDate" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"officeType"}, officeType);
		return list;
		}

	//根据医生姓名查询挂号列表
	public List<Map<String,String>> queryRegisterListByName(String doctorName,int page,int pageSize){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode,dw.workTime,o.officeCode  from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.doctorName =:doctorName and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY order by dw.workDate" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"doctorName"}, doctorName);
		return list;
		}
	
	//根据医生姓名和科室类型查询挂号列表
	public List<Map<String,String>> queryRegisterListByNameAndType(String officeType,String doctorName,int page,int pageSize){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode,dw.workTime,o.officeCode  from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and o.officeType =:officeType and d.doctorName =:doctorName and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY order by dw.workDate" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"officeType","doctorName"},officeType, doctorName);
		return list;
		}
	 //医生诊断列表
	 public List<Map<String,String>> queryRegisterByCode(int page,int pageSize,String code){
		System.out.println(code);
		String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime,p.userId from tb_register r,tb_patient p where r.doctorCode =:code and p.userId =r.userid and r.status = 0 and p.status = 0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize, new String[]{"code"}, code);
		return list;
	 
		}
	 
	 //医生通过患者挂号序号查找诊断列表
	 public List<Map<String,String>> queryRegisterByCodeAndVistId(int page,int pageSize,String vistId,String code){
		System.out.println(code);
		String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime,p.userId from tb_register r,tb_patient p where r.doctorCode =:code and r.vistId =:vistId and p.userId =r.userid and r.status <>1" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId","code"}, vistId,code);
		return list;
	 
		}
	 
	 //医生通过患者姓名查找诊断列表
	 public List<Map<String,String>> queryRegisterByCodeAndName(int page,int pageSize,String userName,String code){
		System.out.println("oc:"+code);
		String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime,p.userId from tb_register r,tb_patient p where r.doctorCode =:code and p.userName =:userName and p.userId =r.userid and r.status =0 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userName","code"}, userName,code);
		return list;
	 
		}
	 
	 
	 //诊断结果列表
	 public List<Map<String,String>> queryDiagnoseList(String vistId,String code){
			System.out.println(code);
			String sql = "select r.vistId,p.userName,p.sex,p.age,r.seeTime,r.diagnose from tb_register r,tb_patient p where r.doctorCode =:code and r.vistId =:vistId and p.userId =r.userid and r.status = 2" ;
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId","code"}, vistId,code);
			return list;
		}
	 
	//医生诊断单管理列表
	 public List<Map<String,String>> queryDiagnoseByCode(int page,int pageSize,String code){
		System.out.println(code);
		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status,p.userId from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.doctorCode =:code and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2 order by r.seeTime desc" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"code"},code);
		return list;
	 
		}
	 
	//医生通过挂号序号查找诊断单
	 public List<Map<String,String>> queryDiagnoseByVistId(int page,int pageSize,String vistId){
		System.out.println(vistId);
		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.vistId =:vistId and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2 order by r.seeTime desc" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"},vistId);
		return list;
	 
		}
	//医生通过用户id查找诊断单
	 public List<Map<String,String>> queryDiagnoseByUserId(int page,int pageSize,String userId){
			System.out.println(userId);
			String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.userId =:userId and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2 order by r.seeTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId"},userId);
			return list;
		 
			}
	 
	//医生通过挂号序号和用户id查找诊断单
	 public List<Map<String,String>> queryDiagnoseByVU(int page,int pageSize,String vistId,String userId){
			System.out.println(vistId);
			String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.vistId =:vistId and r.userId =:userId and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2 order by r.seeTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"vistId","userId"},vistId,userId);
			return list;
		 
			}
 
	//退号
	 public List<Map<String,String>> queryRegisterByUserId(String userId,int page,int pageSize){
			System.out.println(userId);
			String sql = "select r.vistId,p.userName,r.feetype,d.doctorName,o.officeType,r.createTime,r.status from tb_register r,tb_patient p,tb_doctor d,tb_office o where r.userId =:userId and r.doctorCode =d.doctorCode and p.userId =r.userid and d.officeCode = o.officeCode and r.status <> 1 order by r.createTime desc" ;
			List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize, new String[]{"userId"}, userId);
			return list;
	 
		}
	 
	  public List<Map<String,String>> queryRegisterByUserId(String userId){
			System.out.println(userId);
			String sql = "select r.vistId,p.userName,r.feetype,d.doctorName,o.officeType,r.createTime,r.status from tb_register r,tb_patient p,tb_doctor d,tb_office o where r.userId =:userId and r.doctorCode =d.doctorCode and p.userId =r.userid and d.officeCode = o.officeCode and r.status <> 1 order by r.createTime desc" ;
			List<Map<String,String>> list = this.executeSql(sql, new String[]{"userId"}, userId);
			return list;
	 
		}
	 
    public List<Map<String,String>> queryRegisterByVistId(String vistId){
		System.out.println(vistId);
		String sql = "select r.vistId,p.userName,r.feetype,d.doctorName,o.officeType,r.createTime,r.status from tb_register r,tb_patient p,tb_doctor d,tb_office o where r.vistId =:vistId and r.doctorCode =d.doctorCode and p.userId =r.userid and d.officeCode = o.officeCode and r.status <> 1" ;
		List<Map<String,String>> list = this.executeSql(sql, new String[]{"vistId"}, vistId);
		return list;
 
	}
	
    //统计指定时间段内挂号量和总挂号费
  public List<Map<String,String>> queryRegisterCount(String stime,String etime){
	String sql = "select cast(count(*) as char) num, cast(sum(r.registerFee) as char) registerFee from tb_register r where r.createTime between :stime and :etime and (r.status =0 or r.status =2)" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"stime","etime"},stime,etime);
	return list;
 
	}
    
  //统计指定时间段内退号量
  public List<Map<String,String>> queryRegisterBackCount(String stime,String etime){
	String sql = "select cast(count(*) as char) num, r.vistid from tb_register r where r.createTime between :stime and :etime and r.status =3 group by r.vistid" ;
	List<Map<String,String>> list = this.executeSql(sql,new String[]{"stime","etime"},stime,etime);
	
	return list;
	}
  
  
  //挂号列表分页
  public List<Map<String,String>> queryDataNum(){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY" ;
		List<Map<String,String>> list = this.executeSql(sql);
		return list;
		}
  public List<Map<String,String>> queryDataNumByType(String officeType){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and o.officeType =:officeType and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"officeType"},officeType);
		return list;
		}
  public List<Map<String,String>> queryDataNumByName(String doctorName){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and d.doctorName =:doctorName and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"doctorName"},doctorName);
		return list;
		}
  public List<Map<String,String>> queryDataNumByNameAndType(String doctorName,String officeType){
		String sql = "select d.doctorName,o.officeType,d.title,dw.workDate,d.clinicType,dw.registerCount,dw.reaminCount,d.registerFee,d.doctorCode from tb_doctor d,tb_doctorWork dw,tb_office o where d.doctorCode = dw.doctorCode and d.officeCode = o.officeCode and d.status = 0 and dw.status = 0 and o.status = 0 and d.doctorName =:doctorName and o.officeType =:officeType and date_format(now(),'%Y-%m-%d' ) <= dw.workDate and  dw.workDate  <= curdate() + INTERVAL 7 DAY" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"doctorName","officeType"},doctorName,officeType);
		return list;
		}
  
  //医生诊断列表分页（查询挂该医生号的病人总数）
  public List<Map<String,String>> queryDataNum(String doctorCode){
		String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where r.doctorCode =:doctorCode and p.userId =r.userid and r.status = 0 and p.status = 0 and r.seeTime = date_format(curdate(),'%Y-%m-%d' )" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"doctorCode"}, doctorCode);
		return list;
		}
  public List<Map<String,String>> queryDataNumByVistId(String vistId,String doctorCode){
	  String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where r.vistId =:vistId and r.doctorCode =:doctorCode and p.userId =r.userid and r.status = 0 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId","doctorCode"},vistId, doctorCode);
		return list;
		}
  public List<Map<String,String>> queryDataNumByPatientName(String userName,String doctorCode){
	  String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where p.userName =:userName and r.doctorCode =:doctorCode and p.userId =r.userid and r.status = 0 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userName","doctorCode"}, userName,doctorCode);
		return list;
		}
  
 //诊断单管理列表(已就诊完成)(可以查看其它医生的诊断结果)
    public List<Map<String,String>> queryDataNumResult(String doctorCode){
		String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where r.doctorCode =:doctorCode and p.userId =r.userid and r.status = 2 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"doctorCode"}, doctorCode);
		return list;
		}
   public List<Map<String,String>> queryDataNumResultByVistId(String vistId){
	  String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where r.vistId =:vistId and p.userId =r.userid and r.status = 2 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"vistId"},vistId);
		return list;
		}
   public List<Map<String,String>> queryDataNumByResultPatientId(String userId){
	  String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where p.userId =:userId and p.userId =r.userid and r.status = 2 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"}, userId);
		return list;
		}
   public List<Map<String,String>> queryDataNumByResultUV(String userId,String vistId){
		 String sql = "select r.vistId,p.userName,p.sex,p.age,r.status,r.seeTime from tb_register r,tb_patient p where p.userId =:userId and r.vistId =:vistId and p.userId =r.userid and r.status = 2 and p.status = 0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId","vistId"}, userId,vistId);
		return list;
		}
  
  //用户查看自己的诊断单
   public List<Map<String,String>> queryDiagnoseByUser(int page,int pageSize,String userId,String stime,String etime){
		System.out.println(userId);
		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.userId =:userId and r.seeTime between :stime and :etime and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2" ;
		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId","stime","etime"},userId,stime,etime);
		return list;
	 
		}
   public List<Map<String,String>> queryDiagnoseByUser(int page,int pageSize,String userId){
 		System.out.println(userId);
 		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.userId =:userId and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2" ;
 		List<Map<String,String>> list = this.executeSqlPage(sql,page,pageSize,new String[]{"userId"},userId);
 		return list;
 	 
 		}
   //分页（用户查看自己的诊断单）
   public List<Map<String,String>> queryDiagnoseByUser(String userId,String stime,String etime){
		System.out.println(userId);
		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.userId =:userId and r.seeTime between :stime and :etime and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId","stime","etime"},userId,stime,etime);
		return list;
	 
		}
   public List<Map<String,String>> queryDiagnoseByUser(String userId){
		System.out.println(userId);
		String sql = "select r.vistId,p.userName,p.sex,p.age,o.officeType,d.doctorName,r.diagnose,r.seeTime,r.status from tb_register r,tb_patient p,tb_office o,tb_doctor d where r.userId =:userId and r.doctorCode =d.doctorCode and r.office =o.officeCode and p.userId =r.userid and r.status =2" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userId"},userId);
		return list;
	 
		}
   
//折线图
   public List<Map<String,String>> queryRegisterCount(){
		String sql = "select count(*) count,date_format(createTime,'%Y-%m-%d' ) Ctime from tb_register where status != 3  group by Ctime order by Ctime" ;
		List<Map<String,String>> list = this.executeSql(sql);
		return list;
	 
		}
  
  //保存挂号单
	public Register saveRegister(Register register) {
		try {
			return this.save(register);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除挂号单
	public boolean deleteRegister(Register register) {
		if (register == null) {
			return false;
		}
		try {
			this.delete(register);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
