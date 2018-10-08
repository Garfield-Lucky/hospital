package org.wu.work.service;


import java.util.List;

import org.wu.work.entity.Doctor;

public interface DoctorService {
	
	public List<Doctor> queryDoctorList(int page,int pageSize);
	public List<Doctor> queryDoctorByCode(int page,int pageSize,String doctorCode);
	public List<Doctor> queryDoctorByName(int page,int pageSize,String doctorName);
	public Doctor queryDoctorByCode(String code);
	public Doctor queryDoctorByUserId(String userId);
	public Doctor insertDoctor(Doctor doctor);
	public Doctor modifyDoctor(Doctor doctor);
	public Doctor queryDoctorById(Doctor doctor);
	public boolean deleteDoctor(Doctor doctor);
	public Doctor changStatus(Doctor doctor);
	
	public List<Doctor> queryDataNum();
	public List<Doctor> queryDataNumByCode(String doctorCode);
	public List<Doctor> queryDataNumByName(String doctorName);
}
