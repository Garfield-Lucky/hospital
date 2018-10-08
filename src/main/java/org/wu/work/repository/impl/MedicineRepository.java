package org.wu.work.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.Medicine;
import org.wu.work.repository.RepositorySupport;

@Repository("medicineRepository")
public class MedicineRepository extends RepositorySupport<Medicine> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	
//	查询所有检查
	public List<Medicine> queryAllMedicine(){
		 
		return this.findAll();
 
	}
	
//	查询检查
	public Medicine queryMedicineByCode(String code){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("medicineCode", code));
		System.out.println("medicineCode="+code);
		return this.findOne(detachedCriteria);
 
	}
	//药品入库时检查是否是新药
	public Medicine queryMedicineByNameAndSpec(String medicineName,String supplier,String spec){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("medicineName", medicineName));
		detachedCriteria.add(Restrictions.eq("supplier", supplier));
		detachedCriteria.add(Restrictions.eq("medicineSpec", spec));
		return this.findOne(detachedCriteria);
 
	}
	
	//药品管理
	public List<Medicine> queryMedicineByName(int page,int pageSize,String name){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("medicineName", name));
		return this.findAll(detachedCriteria,page,pageSize);
 
	}
	//药品管理（分页）
	public List<Medicine> queryMedicineByName(String name){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("medicineName", name));
		return this.findAll(detachedCriteria);
 
	}
	
	//药品管理（默认加载）
	public List<Medicine> queryMedicineList(int page,int pageSize){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria, page, pageSize);
 
	}
	public List<Medicine> queryMedicineList(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findAll(detachedCriteria);
	}
	//模糊查询
	public List<Medicine> findMedicineName(String medicineName){
		System.out.println(medicineName);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.like("medicineName", '%'+medicineName+'%'));
		return this.findAll(detachedCriteria,0,10000);
 
	}
	//根据药品名查找药品规格
	public List<Medicine> findMedicineSpec(String medicineName){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("medicineName", medicineName));
		return this.findAll(detachedCriteria,0,10000);
 
	}
	
	//检查处方单的药品是否存在
	public Medicine findMedicineByNameAanSpec(String medicineName,String medicineSpec){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Medicine.class);
		detachedCriteria.add(Restrictions.eq("status", 0));
		detachedCriteria.add(Restrictions.eq("medicineName", medicineName));
		detachedCriteria.add(Restrictions.eq("medicineSpec", medicineSpec));
		return this.findOne(detachedCriteria);
 
	}
	
	//销售排行
	public List<Map<String,String>> querySaleTop(int page,int pageSize,String stime,String etime){
		 
		 String sql = "select m.medicineName,m.supplier,m.medicineSpec,m.price,m.repertory,sum(c.number) sale from tb_charge c,tb_medicine m where createTime between :stime and :etime and c.chargeProject =m.medicineName and c.spec = m.medicineSpec and c.itemType = 0 and c.status = 0 group by m.medicineName,m.medicineSpec,m.supplier,m.price,m.repertory order by sale desc";
		 return this.executeSqlPage(sql,page,pageSize, new String[]{"stime","etime"},stime,etime);

	}
	//销售排行（分页）
	public List<Map<String,String>> querySaleTop(String stime,String etime){
		 
		 String sql = "select m.medicineName,m.supplier,m.medicineSpec,m.price,m.repertory,sum(c.number) sale from tb_charge c,tb_medicine m where createTime between :stime and :etime and c.chargeProject =m.medicineName and c.spec = m.medicineSpec and c.itemType = 0 and c.status = 0 group by m.medicineName,m.medicineSpec,m.supplier,m.price,m.repertory order by sale desc";
		 return this.executeSql(sql,new String[]{"stime","etime"},stime,etime);

	}
	//更改库存
	public int updateRepertory(String medicineName,String medicineSpec,String count){
		 
		 String sql = "update tb_medicine set repertory =repertory - :count where medicineName =:medicineName and medicineSpec =:medicineSpec and status = 0";
		 return this.executeUpdateSql(sql, new String[]{"count","medicineName","medicineSpec"},count,medicineName,medicineSpec);

	}
	
  //	保存检查
	public Medicine saveMedicine(Medicine medicine) {
		try {
			return this.save(medicine);
		} catch (Exception e) {
			return null;
		}
	}
	
	//删除检查
	public boolean deleteMedicine(Medicine medicine) {
		if (medicine == null) {
			return false;
		}
		try {
			this.delete(medicine);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
}
