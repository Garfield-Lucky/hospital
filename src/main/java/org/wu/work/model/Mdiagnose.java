package org.wu.work.model;


public class Mdiagnose {

	private String  vistId;
	private String  userId;
	private String  userName;
	private String  sex;
	private String  age;
	private String officeType;
	private String  doctorName;
	private String  createTime;
	private String  remark;
	private String  status;
	private String  flag;
	private String  seeTime;  //就诊时间
	private String  diagnose;  //诊断结果
	
	
	public String getVistId() {
		return vistId;
	}
	public void setVistId(String vistId) {
		this.vistId = vistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeeTime() {
		return seeTime;
	}
	public void setSeeTime(String seeTime) {
		this.seeTime = seeTime;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Mdiagnose [vistId=" + vistId + ", userId=" + userId + ", userName=" + userName + ", sex=" + sex
				+ ", age=" + age + ", officeType=" + officeType + ", doctorName=" + doctorName + ", createTime="
				+ createTime + ", remark=" + remark + ", status=" + status + ", seeTime=" + seeTime + ", diagnose="
				+ diagnose + "]";
	}
	
	 
	
}
