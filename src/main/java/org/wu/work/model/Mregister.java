package org.wu.work.model;


public class Mregister {

	private String     vistId;
	private String     userName;
	private String     sex;
	private String     age;
	private String     feetype;
	private String     doctorName;
	private String     officeType;
	private String     createTime;
	private String     flag;
	private String     status;
	
	
	public String getVistId() {
		return vistId;
	}
	public void setVistId(String vistId) {
		this.vistId = vistId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Mregister [vistId=" + vistId + ", userName=" + userName + ", feetype=" + feetype + ", doctorName="
				+ doctorName + ", officeType=" + officeType + ", createTime=" + createTime + ", status=" + status + "]";
	}
	
	
}
