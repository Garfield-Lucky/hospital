package org.wu.work.model;


public class Mpatient {

	private String  vistId;
	private String  userId;
	private String  userName;
	private String  sex;
	private String  age;
	private String  medicalNum;
	private String  balanceMedical;
	private String  nation;
	private String  address;
	private String  phone;
	private String  idCard;
	private String  marry;
	private String  createTime;
	private String  remark;
	private String  status;
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
	
	public String getMedicalNum() {
		return medicalNum;
	}
	
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}
	
	public String getBalanceMedical() {
		return balanceMedical;
	}
	
	public void setBalanceMedical(String balanceMedical) {
		this.balanceMedical = balanceMedical;
	}
	
	public String getNation() {
		return nation;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIdCard() {
		return idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getMarry() {
		return marry;
	}
	
	public void setMarry(String marry) {
		this.marry = marry;
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

	@Override
	public String toString() {
		return "Mpatient [vistId=" + vistId + ", userId=" + userId + ", userName=" + userName + ", sex=" + sex
				+ ", age=" + age + ", medicalNum=" + medicalNum + ", balanceMedical=" + balanceMedical + ", nation="
				+ nation + ", address=" + address + ", phone=" + phone + ", idCard=" + idCard + ", marry=" + marry
				+ ", createTime=" + createTime + ", remark=" + remark + ", status=" + status + "]";
	}
	
}
