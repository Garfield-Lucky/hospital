package org.wu.work.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prescription")
public class Prescription implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 处方实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String id;
	private String vistId;
	private String  medicinName;
	private double  count;
	private String  remark;
	private String  doctorCode;
	private Timestamp createTime;
	private String  medicineSpec;
	private Integer status;
	

	public Prescription() {
		
	}

	public Prescription(String id, String vistId, String medicinName, double count, String remark, String doctorCode,
			 Timestamp createTime, String medicineSpec, Integer status) {
		super();
		this.id = id;
		this.vistId = vistId;
		this.medicinName = medicinName;
		this.count = count;
		this.remark = remark;
		this.doctorCode = doctorCode;
		this.createTime = createTime;
		this.medicineSpec = medicineSpec;
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

	@Column(name = "medicinName")
	public String getMedicinName() {
		return medicinName;
	}


	public void setMedicinName(String medicinName) {
		this.medicinName = medicinName;
	}

	@Column(name = "count")
	public double getCount() {
		return count;
	}


	public void setCount(double count) {
		this.count = count;
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
 

	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	@Column(name = "medicineSpec")
	public String getMedicineSpec() {
		return medicineSpec;
	}


	public void setMedicineSpec(String medicineSpec) {
		this.medicineSpec = medicineSpec;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public void merge(Prescription pres) {
		
		 this.vistId        = pres.getVistId();
		 this.medicinName   = pres.getMedicinName();
		 this.count         = pres.getCount();
		 this.remark        = pres.getRemark();
		 this.doctorCode    = pres.getDoctorCode();
		 this.createTime    = pres.getCreateTime();
		 this.medicineSpec  = pres.getMedicineSpec();
		 this.status        = pres.getStatus();
	}
	@Override
	public String toString() {
		return "Prescription [ vistid=" + vistId + ", medicinName=" + medicinName + ", count=" + count
				+ ", remark=" + remark + ", doctor=" + doctorCode + ", createTime=" + createTime + ", status=" + status
				+ "]";
	}
	
	
	 
}
