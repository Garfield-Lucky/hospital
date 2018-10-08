package org.wu.work.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_doctorWork")
public class DoctorWork implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 医生值班安排实体类
	 */
	private static final long serialVersionUID = 6980093847795727810L;
	private String     id;
	private String     doctorCode;
	private Date       workDate;
	private String     workTime;
	private int        registerCount;
	private int        reaminCount;
	private int        status;
	 
	
	public DoctorWork() {
		
	}
	
	public DoctorWork(String id, String doctorCode, Timestamp workDate, String workTime, int registerCount,
			int reaminCount, int status) {
		super();
		this.id = id;
		this.doctorCode = doctorCode;
		this.workDate = workDate;
		this.workTime = workTime;
		this.registerCount = registerCount;
		this.reaminCount = reaminCount;
		this.status = status;
	}


	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "doctorCode")
	public String getDoctorCode() {
		return doctorCode;
	}


	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	@Column(name = "workDate")
	public Date getWorkDate() {
		return workDate;
	}


	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	@Column(name = "workTime")
	public String getWorkTime() {
		return workTime;
	}


	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	@Column(name = "registerCount")
	public int getRegisterCount() {
		return registerCount;
	}


	public void setRegisterCount(int registerCount) {
		this.registerCount = registerCount;
	}

	@Column(name = "reaminCount")
	public int getReaminCount() {
		return reaminCount;
	}


	public void setReaminCount(int reaminCount) {
		this.reaminCount = reaminCount;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	public void merge(DoctorWork work) {
		this.doctorCode    = work.getDoctorCode();
		this.workDate      = work.getWorkDate();
		this.workTime      = work.getWorkTime();
		this.registerCount = work.getRegisterCount();
		this.reaminCount   = work.getReaminCount();
		this.status        = work.getStatus();
	}

	@Override
	public String toString() {
		return "DoctorWork [doctorCode=" + doctorCode + ", workDate=" + workDate + ", workTime=" + workTime
				+ ", registerCount=" + registerCount + ", reaminCount=" + reaminCount + ", status=" + status + "]";
	}

	 
}
