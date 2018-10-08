package org.wu.work.service;


import java.util.List;

import org.wu.work.entity.Office;

public interface OfficeService {
	public List<Office> queryOfficeList(int page,int pageSize);
	public List<Office> queryOfficeByCode(int page,int pageSize,String officeCode);
	public List<Office> queryOfficeByType(int page,int pageSize,String officeType);
	public Office queryOfficeByCode(String officeCode);
	public Office insertOffice(String officeCode,String officeType,String address);
	public Office insertOffice(Office office);
	public Office modifyoffice(Office office);
	public Office queryOfficeById(int id);
	public boolean deleteOffice(Office office);
	public Office changStatus(Office office);
	
	public List<Office> queryDataNum();
	public List<Office> queryDataNumByCode(String officeCode);
	public List<Office> queryDataNumByType(String officeType);
	
}
