package org.wu.work.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_register")
public class Register implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 挂号实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String    vistId;
	private String     userId;
	private String     feetype;
	private double     registerFee;
	private String     doctorCode;
	private String     office;
	private String     diagnose;
	private Timestamp  createTime;
	private Date  seeTime;
	private int    status;
	

	public Register() {
		
	}

 

	public Register(String vistId, String userId, String feetype, double registerFee, String doctorCode, String office,
			String diagnose, Timestamp createTime, Timestamp seeTime, int status) {
		super();
		this.vistId = vistId;
		this.userId = userId;
		this.feetype = feetype;
		this.registerFee = registerFee;
		this.doctorCode = doctorCode;
		this.office = office;
		this.diagnose = diagnose;
		this.createTime = createTime;
		this.seeTime = seeTime;
		this.status = status;
	}





	@Id
	@Column(name = "vistId")
	public String getVistId() {
		return vistId;
	}


	public void setVistId(String vistId) {
		this.vistId = vistId;
	}

	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "feetype")
	public String getFeetype() {
		return feetype;
	}


	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	@Column(name = "registerFee")
	public double getRegisterFee() {
		return registerFee;
	}

	public void setRegisterFee(double registerFee) {
		this.registerFee = registerFee;
	}


	@Column(name = "doctorCode")
	public String getDoctorCode() {
		return doctorCode;
	}

 


	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	@Column(name = "office")
	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}

	@Column(name = "diagnose")
	public String getDiagnose() {
		return diagnose;
	}


	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "seeTime")
	public Date getSeeTime() {
		return seeTime;
	}


	public void setSeeTime(Date seeTime) {
		this.seeTime = seeTime;
	}


	@Column(name = "status")
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public void merge(Register register) {
		
		 this.vistId      = register.getVistId();
		 this.userId      = register.getUserId();
		 this.feetype     = register.getFeetype();
		 this.registerFee     = register.getRegisterFee();
		 this.doctorCode  = register.getDoctorCode();
		 this.office      = register.getOffice();
		 this.diagnose    = register.getDiagnose();
		 this.createTime  = register.getCreateTime();
		 this.status      = register.getStatus();
	}

	@Override
	public String toString() {
		return "Register [vistId=" + vistId + ", userId=" + userId + ", feetype=" + feetype + ", doctor=" + doctorCode
				+ ", office=" + office + ", diagnose=" + diagnose + ", createTime=" + createTime + ", status=" + status
				+ "]";
	}

 
 
}
