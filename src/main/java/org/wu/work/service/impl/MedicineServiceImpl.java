package org.wu.work.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Medicine;
import org.wu.work.repository.impl.MedicineRepository;
import org.wu.work.service.MedicineService;

@SuppressWarnings("restriction")
@Service("medicineService")
public class MedicineServiceImpl implements MedicineService{

	@Resource
	private MedicineRepository medicineRepository;
	
	public Medicine queryMedicineByCode(String code) {
		return medicineRepository.queryMedicineByCode(code);
	}

	public Medicine insertMedicine(Medicine medicine) {
		return medicineRepository.saveMedicine(medicine);
	}

	public Medicine modifyMedicine(Medicine medicine) {
		return medicineRepository.saveMedicine(medicine);
	}

	public Medicine queryMedicineById(Medicine medicine) {
		return null;
	}

	public boolean deleteMedicine(Medicine medicine) {
		return medicineRepository.deleteMedicine(medicine);
	}

	public Medicine changStatus(Medicine medicine) {
		return medicineRepository.saveMedicine(medicine);
	}

	public List<Medicine> queryMedicineList(int page, int pageSize) {
		return medicineRepository.queryMedicineList(page, pageSize);
	}
	public List<Medicine> queryMedicineList() {
		return medicineRepository.queryMedicineList();
	}
	
	public List<Medicine> queryMedicineByName(int page, int pageSize, String name) {
		return medicineRepository.queryMedicineByName(page, pageSize, name);
	}
	public List<Medicine> queryMedicineByName(String name) {
		return medicineRepository.queryMedicineByName(name);
	}

	public List<Map<String,String>> querySaleTop(int page, int pageSize, String stime, String etime) {
		return medicineRepository.querySaleTop(page, pageSize, stime, etime);
	}
	public List<Map<String,String>> querySaleTop(String stime, String etime) {
		return medicineRepository.querySaleTop(stime, etime);
	}

	public int updateRepertory(String medicineName, String medicineSpec,String count) {
		return medicineRepository.updateRepertory(medicineName, medicineSpec, count);
	}

	public Medicine queryMedicineByNameAndSpec(String medicineName, String supplier, String spec) {
		return medicineRepository.queryMedicineByNameAndSpec(medicineName, supplier, spec);
	}

	public List<Medicine> findMedicineName(String medicineName) {
		return medicineRepository.findMedicineName(medicineName);
	}
	public List<Medicine> findMedicineSpec(String medicineName) {
		return medicineRepository.findMedicineSpec(medicineName);
	}

	public Medicine queryMedicineByNameAndSpec(String medicineName, String medicineSpec) {
		return medicineRepository.findMedicineByNameAanSpec(medicineName, medicineSpec);
	}

}
