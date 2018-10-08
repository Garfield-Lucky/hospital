package org.wu.work.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_doctor")
public class Doctor implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 医生信息实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String doctorCode;
	private String doctorName;
	private String  sex;
	private Integer  age;
	private String  title;
	private String  clinicType;
	private double  registerFee;
	private String  officeCode;
	private String phone;
	private Integer  status;
	

	public Doctor() {
		
	}


	public Doctor(String doctorCode, String doctorName, String sex, Integer age, String title, String clinicType,
			double registerFee, String officeCode, String phone, Integer status) {
		super();
		this.doctorCode = doctorCode;
		this.doctorName = doctorName;
		this.sex = sex;
		this.age = age;
		this.title = title;
		this.clinicType = clinicType;
		this.registerFee = registerFee;
		this.officeCode = officeCode;
		this.phone = phone;
		this.status = status;
	}

	@Id
	@Column(name = "doctorCode")
	public String getDoctorCode() {
		return doctorCode;
	}


	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	@Column(name = "doctorName")
	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	@Column(name = "title")
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	@Column(name = "clinicType")
	public String getClinicType() {
		return clinicType;
	}



	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}



	@Column(name = "registerFee")
	public double getRegisterFee() {
		return registerFee;
	}


	public void setRegisterFee(double registerFee) {
		this.registerFee = registerFee;
	}




	@Column(name = "officeCode")
	public String getOfficeCode() {
		return officeCode;
	}


	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	public void merge(Doctor doctor) {
		
		 this.doctorCode  = doctor.getDoctorCode();
		 this.doctorName  = doctor.getDoctorName();
		 this.sex         = doctor.getSex();
		 this.age         = doctor.getAge();
		 this.title       = doctor.getTitle();
		 this.officeCode  = doctor.getOfficeCode();
		 this.phone       = doctor.getPhone();
		 this.status      = doctor.getStatus();
	}


	@Override
	public String toString() {
		return "Doctor [doctorCode=" + doctorCode + ", doctorName=" + doctorName + ", sex=" + sex + ", age=" + age
				+ ", title=" + title + ", clinicType=" + clinicType + ", registerFee=" + registerFee + ", officeCode="
				+ officeCode + ", phone=" + phone + ", status=" + status + "]";
	}
	
 
}
