package org.wu.work.entity;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_charge")
public class Charge implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 收费单实体类
	 */
	private static final long serialVersionUID = 6980093847795726610L;
	private String     chargeId;
	private String     cashier;
	private String     vistId;
	private String     userName;
	private String     chargeProject;
	private Integer    itemType;
	private String     spec;
	private double     number;
	private double     price;
	private Timestamp  createTime;
	private Integer    status;
	
	public Charge() {
		
	}


	 


	public Charge(String chargeId, String cashier, String vistId, String userName, String chargeProject,
			Integer itemType, String spec, double number, double price, Timestamp createTime, Integer status) {
		super();
		this.chargeId = chargeId;
		this.cashier = cashier;
		this.vistId = vistId;
		this.userName = userName;
		this.chargeProject = chargeProject;
		this.itemType = itemType;
		this.spec = spec;
		this.number = number;
		this.price = price;
		this.createTime = createTime;
		this.status = status;
	}




	@Id
	@Column(name = "chargeId")
	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	@Column(name = "cashier")
	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	@Column(name = "vistId")
	public String getVistId() {
		return vistId;
	}

	public void setVistId(String vistId) {
		this.vistId = vistId;
	}

	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "chargeProject")
	public String getChargeProject() {
		return chargeProject;
	}

	public void setChargeProject(String chargeProject) {
		this.chargeProject = chargeProject;
	}

	@Column(name = "itemType")
	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	@Column(name = "spec")
	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	@Column(name = "number")
	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	//不允许修改账单信息，只可以更改状态
	public void merge(Charge charge) {
		this.status = charge.getStatus();
	}
	@Override
	public String toString() {
		return "charge [chargeId=" + chargeId + ", cashier=" + cashier + ", vistid=" + vistId + ", userName=" + userName
				+ ", chargeProject=" + chargeProject + ", number=" + number + ", price=" + price
                + ", createTime=" + createTime + ", status=" + status + "]";
	}


}
