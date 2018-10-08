package org.wu.work.entity;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_check")
public class Check implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 检查单实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String    id;
	private String     vistId;
	private String     checkResult;
	private String     checkPhoto;
	private String     remark;
	private String     doctorCode;
	private String     checkPerson;
	private Timestamp  createTime;
	private Timestamp  checkTime;
	private String     checkType;
	private String     checkPlace;
	private String     specimenType;
	private String     checkMethod;
	private Integer    status;
	
	
	public Check() {
		
	}


	public Check(String id, String vistId, String checkResult, String checkPhoto, String remark, String doctorCode,
			String checkPerson, Timestamp createTime, Timestamp checkTime, String checkType, String checkPlace,
			String specimenType, String checkMethod, Integer status) {
		super();
		this.id = id;
		this.vistId = vistId;
		this.checkResult = checkResult;
		this.checkPhoto = checkPhoto;
		this.remark = remark;
		this.doctorCode = doctorCode;
		this.checkPerson = checkPerson;
		this.createTime = createTime;
		this.checkTime = checkTime;
		this.checkType = checkType;
		this.checkPlace = checkPlace;
		this.specimenType = specimenType;
		this.checkMethod = checkMethod;
		this.status = status;
	}



	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "vistId")
	public String getVistId() {
		return vistId;
	}



	public void setVistId(String vistId) {
		this.vistId = vistId;
	}


	@Column(name = "checkResult")
	public String getCheckResult() {
		return checkResult;
	}



	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	@Column(name = "checkPhoto")
	public String getCheckPhoto() {
		return checkPhoto;
	}


	public void setCheckPhoto(String checkPhoto) {
		this.checkPhoto = checkPhoto;
	}


	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "doctorCode")
	public String getDoctorCode() {
		return doctorCode;
	}


	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	
	@Column(name = "checkPerson")
	public String getCheckPerson() {
		return checkPerson;
	}



	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}


	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	@Column(name = "checkTime")
	public Timestamp getCheckTime() {
		return checkTime;
	}



	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}


	@Column(name = "checkType")
	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@Column(name = "checkPlace")
	public String getCheckPlace() {
		return checkPlace;
	}

	public void setCheckPlace(String checkPlace) {
		this.checkPlace = checkPlace;
	}

	@Column(name = "specimenType")
	public String getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}

	@Column(name = "checkMethod")
	public String getCheckMethod() {
		return checkMethod;
	}

	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void merge(Check check) {
		
		 this.vistId       = check.getVistId();
		 this.checkResult  = check.getCheckResult();
		 this.checkPhoto   = check.getCheckPhoto();
		 this.remark       = check.getRemark();
		 this.checkPerson  = check.getCheckPerson();
		 this.doctorCode   = check.getDoctorCode();
		 this.createTime   = check.getCreateTime();
		 this.checkTime    = check.getCheckTime();
		 this.checkType    = check.getCheckType();
		 this.status       = check.getStatus();
	}


	@Override
	public String toString() {
		return "Check [id=" + id + ", vistId=" + vistId + ", checkResult=" + checkResult + ", remark=" + remark
				+ ", checkPerson=" + checkPerson + ", createTime=" + createTime + ", checkTime=" + checkTime
				+ ", checkType=" + checkType + ", status=" + status + "]";
	}
 
 
 
}
