package org.wu.work.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_patient")
public class Patient implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 病人基本信息实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String userId;
	private String userName;
	private String  sex;
	private Integer  age;
	private String  medicalNum;
	private double  balanceMedical;
	private String nation;
	private String  address;
	private String  phone;
	private String  idCard;
	private String marry;
	private Timestamp createTime;
	private String  remark;
	private Integer status;
	

	public Patient() {
		
	}


	public Patient(String userId, String userName, String sex, Integer age, String medicalNum, double balanceMedical,
			String nation, String address, String phone, String idCard, String marry, Timestamp createTime,
			String remark, Integer status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.medicalNum = medicalNum;
		this.balanceMedical = balanceMedical;
		this.nation = nation;
		this.address = address;
		this.phone = phone;
		this.idCard = idCard;
		this.marry = marry;
		this.createTime = createTime;
		this.remark = remark;
		this.status = status;
	}

	@Id
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "medicalNum")
	public String getMedicalNum() {
		return medicalNum;
	}


	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}

	@Column(name = "balanceMedical")
	public double getBalanceMedical() {
		return balanceMedical;
	}


	public void setBalanceMedical(double balanceMedical) {
		this.balanceMedical = balanceMedical;
	}

	@Column(name = "nation")
	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "idCard")
	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "marry")
	public String getMarry() {
		return marry;
	}


	public void setMarry(String marry) {
		this.marry = marry;
	}

	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public void merge(Patient patient) {
		
		 this.userId         = patient.getUserId();
		 this.userName       = patient.getUserName();
		 this.sex            = patient.getSex();
		 this.age            = patient.getAge();
		 this.medicalNum     = patient.getMedicalNum();
		 this.balanceMedical = patient.getBalanceMedical();
		 this.nation         = patient.getNation();
		 this.address        = patient.getAddress();
		 this.phone          = patient.getPhone();
		 this.idCard         = patient.getIdCard();
		 this.marry          = patient.getMarry();
		 this.remark         = patient.getRemark();
		 this.status         = patient.getStatus();
	}

	@Override
	public String toString() {
		return "patient [userId=" + userId + ", userName=" + userName + ", sex=" + sex + ", age=" + age
				+ ", medicalNum=" + medicalNum + ", balanceMedical=" + balanceMedical + ", nation=" + nation
				+ ", address=" + address + ", phone=" + phone + ", idCard=" + idCard + ", marry=" + marry
				+ ", createTime=" + createTime + ", remark=" + remark + ", status=" + status + "]";
	}

 
	
	 
}
