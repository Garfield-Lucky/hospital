package org.wu.work.model;


public class MCheck {
	
	private String id;
	private String vistId;
	private String  userName;
	private String  userId;
	private String sex;
	private String age;
	private String officeType;
	private String  doctorName;
	private String createTime;
	private String checkTime;
	private String  checkPerson;
	private String checkType;
	private String checkPlace;
	private String specimenType;
	private String checkMethod;
	private String checkResult;
	private String remark;
	private String flag;
	private String status;
	private String style;
	private String checkPhoto;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckPerson() {
		return checkPerson;
	}
	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getCheckPlace() {
		return checkPlace;
	}
	public void setCheckPlace(String checkPlace) {
		this.checkPlace = checkPlace;
	}
	public String getSpecimenType() {
		return specimenType;
	}
	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}
	public String getCheckMethod() {
		return checkMethod;
	}
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
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
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getCheckPhoto() {
		return checkPhoto;
	}
	public void setCheckPhoto(String checkPhoto) {
		this.checkPhoto = checkPhoto;
	}
	@Override
	public String toString() {
		return "MCheck [id=" + id + ", vistId=" + vistId + ", sex=" + sex + ", age=" + age + ", officeType="
				+ officeType + ", doctorName=" + doctorName + ", createTime=" + createTime + ", checkTime=" + checkTime
				+ ", checkPerson=" + checkPerson + ", checkType=" + checkType + ", checkPlace=" + checkPlace
				+ ", specimenType=" + specimenType + ", checkMethod=" + checkMethod + ", checkResult=" + checkResult
				+ ", remark=" + remark + ", status=" + status + "]";
	}
	
	 
}
