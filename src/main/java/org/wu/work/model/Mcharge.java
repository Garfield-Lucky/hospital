package org.wu.work.model;


public class Mcharge {
	
	private String id;
	private String clerk;  //收费员
	private String vistId;
	private String  userName;
	private String sex;
	private String age;
	private String officeType;
	private String  doctorName;
	private String createTime;
	private String chargeItem;
	private String  medicineSpec;
	private String  count;
	private String  price;     //单价
	private String  itemCount; //单项合计
	private String  fee;       //总费用
	private String balanceMedical;//用户账户余额
	private String status;
	
	
	
	public String getClerk() {
		return clerk;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public String getBalanceMedical() {
		return balanceMedical;
	}
	public void setBalanceMedical(String balanceMedical) {
		this.balanceMedical = balanceMedical;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getItemCount() {
		return itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public String getMedicineSpec() {
		return medicineSpec;
	}
	public void setMedicineSpec(String medicineSpec) {
		this.medicineSpec = medicineSpec;
	}
 
	public String getChargeItem() {
		return chargeItem;
	}
	public void setChargeItem(String chargeItem) {
		this.chargeItem = chargeItem;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
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
 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Mcharge [id=" + id + ", vistId=" + vistId + ", userName=" + userName + ", sex=" + sex + ", age=" + age
				+ ", officeType=" + officeType + ", doctorName=" + doctorName + ", createTime=" + createTime
				+ ", chargeItem=" + chargeItem + ", medicineSpec=" + medicineSpec + ", count=" + count + ", price="
				+ price + ", ItemCount=" + itemCount + ", fee=" + fee + ", status=" + status + "]";
	}
 
	
	
}
