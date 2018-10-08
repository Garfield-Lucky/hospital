package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Charge;
import org.wu.work.repository.RepositorySupport;

@Repository("chargeRepository")
public class ChargeRepository extends RepositorySupport<Charge> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有收费单
	public List<Charge> queryAllCharge(){
		 
		return this.findAll();
 
	}
	
//	查询收费单
	public Charge queryChargeById(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Charge.class);
		detachedCriteria.add(Restrictions.eq("id", id));
		System.out.println("id="+id);
		return this.findOne(detachedCriteria);
 
	}
	
	public List<Map<String,String>> queryChargeByTime(String stime,String etime){
		 
		 String sql = "select itemType,number,price from tb_charge where createTime between :stime and :etime and status = 0";
		 return this.executeSql(sql, new String[]{"stime","etime"}, stime,etime);
 
	}
	
	//账单管理
	public List<Map<String,String>> queryBillByTime(int page,int pageSize,String stime,String etime){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where createTime between :stime and :etime and status = 0 order by createTime desc";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"stime","etime"}, stime,etime);

	}
	public List<Map<String,String>> queryBillByVistId(int page,int pageSize,String vistId){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where vistId =:vistId and status = 0 order by createTime desc";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"vistId"},vistId);

	}
	public List<Map<String,String>> queryBillByVSE(int page,int pageSize,String vistId,String stime,String etime){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where vistId =:vistId and createTime between :stime and :etime and status = 0 order by createTime desc";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"vistId","stime","etime"},vistId,stime,etime);

	}
	
	//统计汇总
	public List<Map<String,String>> queryCountByTime(int page,int pageSize,String stime,String etime){
		 
		 String sql = "select cashier,sum(price*number) num from tb_charge where createTime between :stime and :etime and status = 0 group by cashier";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"stime","etime"},stime,etime);

	}
	
	//账单明细
	public List<Map<String,String>> findBillList(int page,int pageSize,String stime,String etime,String clerk){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where createTime between :stime and :etime and cashier =:clerk and status = 0 order by createTime desc";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"stime","etime","clerk"}, stime,etime,clerk);

	}
	
	public List<Map<String,String>> queryCountByTimeAndClerk(String stime,String etime,String clerk){
		 
		 String sql = "select cashier,sum(price*number) num from tb_charge where createTime between :stime and :etime and cashier = :clerk and status = 0";
		 return this.executeSql(sql, new String[]{"stime","etime","clerk"},stime,etime,clerk);

	}
	public List<Map<String,String>> queryCountByClerk(String clerk){
		 
		 String sql = "select cashier,sum(price*number) num from tb_charge where and cashier = :clerk and status = 0";
		 return this.executeSql(sql, new String[]{"clerk"},clerk);

	}
	
	//获取取药列表
	public List<Charge> querySaleMedicineList(String vistId){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Charge.class);
		detachedCriteria.add(Restrictions.eq("vistId", vistId));
		detachedCriteria.add(Restrictions.eq("itemType", 0));
		detachedCriteria.add(Restrictions.eq("status", 0));
		System.out.println("vistId="+vistId);
		return this.findAll(detachedCriteria);
 
	}
	
	//账单管理（分页）
	public List<Map<String,String>> queryDataNumByVistId(String vistId){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where vistId =:vistId and status = 0";
		 return this.executeSql(sql,new String[]{"vistId"}, vistId);

	}
	public List<Map<String,String>> queryDataNumByTime(String stime,String etime){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where createTime between :stime and :etime and status = 0";
		 return this.executeSql(sql,new String[]{"stime","etime"}, stime,etime);

	}
	public List<Map<String,String>> queryDataNumByVSE(String vistId,String stime,String etime){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where vistId =:vistId and createTime between :stime and :etime and status = 0";
		 return this.executeSql(sql,new String[]{"vistId","stime","etime"}, vistId,stime,etime);

	}
	
	//（分页）统计汇总
	public List<Map<String,String>> queryDataNumBySE(String stime,String etime){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where createTime between :stime and :etime and status = 0";
		 return this.executeSql(sql,new String[]{"stime","etime"}, stime,etime);

	}
	
	//分页（账单明细）
	public List<Map<String,String>> queryDataNum(String stime,String etime,String clerk){
		 
		 String sql = "select vistId,cashier,userName,chargeProject,spec,number,price,createTime from tb_charge where createTime between :stime and :etime and cashier =:clerk and status = 0";
		 return this.executeSql(sql,new String[]{"stime","etime","clerk"}, stime,etime,clerk);

	}
  //	保存收费单
	public Charge saveCharge(Charge charge) {
		try {
			return this.save(charge);
		}catch (Exception e) {
			return null;
		}
	}
	
	//删除收费单
	public boolean deleteCharge(Charge charge) {
		if (charge == null) {
			return false;
		}
		try {
			this.delete(charge);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
