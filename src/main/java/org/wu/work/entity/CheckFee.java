package org.wu.work.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_checkFee")
public class CheckFee implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 检查检验费用实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String  checkCode;
	private String  checkItem;
	private double  expend;
	private int     status;
	 
	

	public CheckFee() {
		
	}


	public CheckFee(String checkCode, String checkItem, double expend, int status) {
		super();
		this.checkCode = checkCode;
		this.checkItem = checkItem;
		this.expend = expend;
		this.status = status;
	}


	@Id
	@Column(name = "checkCode")
	public String getCheckCode() {
		return checkCode;
	}



	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}


	@Column(name = "checkItem")
	public String getCheckItem() {
		return checkItem;
	}



	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}


	@Column(name = "expend")
	public double getExpend() {
		return expend;
	}



	public void setExpend(double expend) {
		this.expend = expend;
	}


	@Column(name = "status")
	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}

	public void merge(CheckFee check) {
		this.checkItem = check.getCheckItem();
		this.expend    = check.getExpend();
		this.status    = check.getStatus();
	}

	@Override
	public String toString() {
		return "checkFee [checkCode=" + checkCode + ", checkItem=" + checkItem + ", expend=" + expend + ", status="
				+ status + "]";
	}

	 
}
