package org.wu.work.model;


public class Mprescription {
	
	private String id;
	private String vistId;
	private String sex;
	private String age;
	private String userName;
	private String userId;
	private String  medicinName;
	private String  medicineSpec;
	private String  count;
	private String  remark;
	private String  officeType;
	private String  doctorCode;
	private String  doctorName;
	private String createTime;
	private String fufei;
	private String finish;
	private String status;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVistId() {
		return vistId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setVistId(String vistId) {
		this.vistId = vistId;
	}
	
	public String getMedicinName() {
		return medicinName;
	}
	
	public void setMedicinName(String medicinName) {
		this.medicinName = medicinName;
	}
	
	public String getMedicineSpec() {
		return medicineSpec;
	}

	public void setMedicineSpec(String medicineSpec) {
		this.medicineSpec = medicineSpec;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getDoctorCode() {
		return doctorCode;
	}
	
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getFufei() {
		return fufei;
	}
	
	public void setFufei(String fufei) {
		this.fufei = fufei;
	}
	
	public String getFinish() {
		return finish;
	}
	
	public void setFinish(String finish) {
		this.finish = finish;
	}
	
	@Override
	public String toString() {
		return "Mprescription [vistId=" + vistId + ", medicinName=" + medicinName + ", count=" + count + ", remark="
				+ remark + ", doctorCode=" + doctorCode + ", doctorName=" + doctorName + ", createTime=" + createTime
				+ ", fufei=" + fufei + ", finish=" + finish + "]";
	}
	
}
