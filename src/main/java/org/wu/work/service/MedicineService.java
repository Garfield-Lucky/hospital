package org.wu.work.service;


import java.util.List;
import java.util.Map;

import org.wu.work.entity.Medicine;

public interface MedicineService {
	
	public List<Medicine> queryMedicineList(int page,int pageSize);
	public List<Medicine> queryMedicineList();//分页（药品管理）
	
	public List<Map<String,String>> querySaleTop(int page,int pageSize,String stime,String etime);
	public List<Map<String,String>> querySaleTop(String stime,String etime);
	
	public List<Medicine> queryMedicineByName(int page,int pageSize,String name);
	public List<Medicine> queryMedicineByName(String name);
	//更改库存
	public int updateRepertory(String medicineName,String medicineSpec,String count);
	public Medicine queryMedicineByCode(String code);
	public Medicine queryMedicineByNameAndSpec(String medicineName,String supplier,String spec);
	public Medicine insertMedicine(Medicine medicine);
	public Medicine modifyMedicine(Medicine medicine);
	public Medicine queryMedicineById(Medicine medicine);
	public boolean deleteMedicine(Medicine medicine);
	public Medicine changStatus(Medicine medicine);
	
	public Medicine queryMedicineByNameAndSpec(String medicineName,String medicineSpec);
	//模糊查询
	public List<Medicine> findMedicineName(String medicineName);
	public List<Medicine> findMedicineSpec(String medicineName);
}
