package org.wu.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Doctor;
import org.wu.work.repository.impl.DoctorRepository;
import org.wu.work.service.DoctorService;

@SuppressWarnings("restriction")
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{

	@Resource
	private DoctorRepository doctorRepository;
	
	public Doctor queryDoctorByCode(String code) {
		return doctorRepository.queryDoctorByCode(code);
	}

	public Doctor insertDoctor(Doctor doctor) {
		return doctorRepository.saveDoctor(doctor);
	}

	public Doctor modifyDoctor(Doctor doctor) {
		return doctorRepository.saveDoctor(doctor);
	}

	public Doctor queryDoctorById(Doctor doctor) {
		return null;
	}

	public boolean deleteDoctor(Doctor doctor) {
		return doctorRepository.deleteDoctor(doctor);
	}

	public Doctor changStatus(Doctor doctor) {
		return doctorRepository.saveDoctor(doctor);
	}

	public List<Doctor> queryDoctorList(int page, int pageSize) {
		return doctorRepository.queryDoctorList(page, pageSize);
	}
	public List<Doctor> queryDoctorByCode(int page, int pageSize, String doctorCode) {
		return doctorRepository.queryDoctorByCode(page, pageSize, doctorCode);
	}
	public List<Doctor> queryDoctorByName(int page, int pageSize, String doctorName) {
		return doctorRepository.queryDoctorByName(page, pageSize, doctorName);
	}

	public List<Doctor> queryDataNum() {
		return doctorRepository.queryDataNum();
	}
	public List<Doctor> queryDataNumByCode(String doctorCode) {
		return doctorRepository.queryDataNumByCode(doctorCode);
	}
	public List<Doctor> queryDataNumByName(String doctorName) {
		return doctorRepository.queryDataNumByName(doctorName);
	}

	public Doctor queryDoctorByUserId(String userId) {
		return doctorRepository.queryDoctorByUserId(userId);
	}

}
