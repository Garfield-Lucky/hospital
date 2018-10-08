package org.wu.work.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_office")
public class Office implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 科室实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private Integer  id;
	private String   officeCode;
	private String   officeType;
	private String   address;
	private Integer  status;
	

	public Office() {
		
	}


	public Office(String officeCode, String officeType, String address, Integer status) {
		super();
		this.officeCode = officeCode;
		this.officeType = officeType;
		this.address = address;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "OFFICE_SEQ")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "officeCode")
	public String getOfficeCode() {
		return officeCode;
	}


	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	@Column(name = "officeType")
	public String getOfficeType() {
		return officeType;
	}


	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public void merge(Office office) {
		
		 this.officeCode = office.getOfficeCode();
		 this.officeType = office.getOfficeType();
		 this.address    = office.getAddress();
		 this.status     = office.getStatus();
	}

	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", officeType=" + officeType + ", address=" + address + ", status="
				+ status + "]";
	}
 
}
