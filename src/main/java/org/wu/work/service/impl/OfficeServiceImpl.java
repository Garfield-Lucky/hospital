package org.wu.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.Office;
import org.wu.work.repository.impl.OfficeRepository;
import org.wu.work.service.OfficeService;


@SuppressWarnings("restriction")
@Service("officeService")
public class OfficeServiceImpl implements OfficeService{

	
	@Resource
	private OfficeRepository officeRepository;
	 
	 
	public Office queryOfficeByCode(String officeCode) {
		
		return officeRepository.queryOfficeByCode(officeCode);
	}

	public Office insertOffice(String officeCode, String officeType, String address) {
		
		return null;
	}

	public Office insertOffice(Office office) {

		 return officeRepository.saveOfficeType(office);
	}

	public Office modifyoffice(Office office) {
		
		 return officeRepository.saveOfficeType(office);
	}
	public Office queryOfficeById(int id) {
		
		 return officeRepository.findOne(id);
	}

	public boolean deleteOffice(Office office) {
		
		return officeRepository.deleteOffice(office);
	}

	public Office changStatus(Office office) {
		return officeRepository.saveOfficeType(office);
	}

	public List<Office> queryOfficeList(int page, int pageSize) {
		return officeRepository.queryOfficeList(page, pageSize);
	}

	public List<Office> queryOfficeByCode(int page, int pageSize, String officeCode) {
		return officeRepository.queryOfficeByCode(page, pageSize, officeCode);
	}

	public List<Office> queryOfficeByType(int page, int pageSize, String officeType) {
		return officeRepository.queryOfficeByType(page, pageSize, officeType);
	}

	//分页
	public List<Office> queryDataNum() {
		return officeRepository.queryDataNum();
	}
	public List<Office> queryDataNumByCode(String officeCode) {
		return officeRepository.queryDataNumByCode(officeCode);
	}
	public List<Office> queryDataNumByType(String officeType) {
		return officeRepository.queryDataNumByType(officeType);
	}

	 
}
