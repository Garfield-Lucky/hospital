package org.wu.work.model;

public class MdoctorWork {
	
	private String     id;
	private String     doctorCode;
	private String     doctorName;
	private String     title;
	private String     officeType;
	private String     officeCode;
	private String     workDate;
	private String     workTime;
	private String     registerCount;
	private String     reaminCount;
	private String     clinicType;
	private String     registerFee;
	private String     trueDate;  //数据库原始的时间，没有经过格式化
	
	

	public String getTrueDate() {
		return trueDate;
	}


	public void setTrueDate(String trueDate) {
		this.trueDate = trueDate;
	}


	public MdoctorWork() {
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(String registerCount) {
		this.registerCount = registerCount;
	}

	public String getReaminCount() {
		return reaminCount;
	}

	public void setReaminCount(String reaminCount) {
		this.reaminCount = reaminCount;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getOfficeType() {
		return officeType;
	}


	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	
	public String getOfficeCode() {
		return officeCode;
	}


	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}


	public String getClinicType() {
		return clinicType;
	}


	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}


	public String getRegisterFee() {
		return registerFee;
	}


	public void setRegisterFee(String registerFee) {
		this.registerFee = registerFee;
	}


	@Override
	public String toString() {
		return "MdoctorWork [id=" + id + ", doctorCode=" + doctorCode + ", doctorName=" + doctorName + ", officeType="
				+ officeType + ", workDate=" + workDate + ", workTime=" + workTime + ", registerCount=" + registerCount
				+ ", reaminCount=" + reaminCount + "]";
	}
	 
	
}
