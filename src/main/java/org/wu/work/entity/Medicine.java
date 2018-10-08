package org.wu.work.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicine")
public class Medicine implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 药品入库实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String medicineCode;
	private String billCode;
	private String  purchaser;
	private Date  makeDate;
	private String  medicineName;
	private String medicineSpec;
	private String  probatchCode;
	private Date  tproDate;
	private Date  period;
	private String approveCode;
	private String certiCode;
	private String  ckConclusion;
	private String faceQuality;
	private String  place;
	private String  supplier;
	private double  inbatchPrice;
	private double amount;
	private double price;
	private String  unit;
	private double  repertory;
	private String remark;
	private Integer status;
	

	public Medicine() {
		
	}


	 
	public Medicine(String medicineCode, String billCode, String purchaser, Date makeDate, String medicineName,
			String medicineSpec, String probatchCode, Date tproDate, Date period, String approveCode, String certiCode,
			String ckConclusion, String faceQuality, String place, String supplier, double inbatchPrice, double amount,
			double price, String unit, double repertory, String remark, Integer status) {
		super();
		this.medicineCode = medicineCode;
		this.billCode = billCode;
		this.purchaser = purchaser;
		this.makeDate = makeDate;
		this.medicineName = medicineName;
		this.medicineSpec = medicineSpec;
		this.probatchCode = probatchCode;
		this.tproDate = tproDate;
		this.period = period;
		this.approveCode = approveCode;
		this.certiCode = certiCode;
		this.ckConclusion = ckConclusion;
		this.faceQuality = faceQuality;
		this.place = place;
		this.supplier = supplier;
		this.inbatchPrice = inbatchPrice;
		this.amount = amount;
		this.price = price;
		this.unit = unit;
		this.repertory = repertory;
		this.remark = remark;
		this.status = status;
	}



	@Id
	@Column(name = "medicineCode")
	public String getMedicineCode() {
		return medicineCode;
	}


	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	@Column(name = "billCode")
	public String getBillCode() {
		return billCode;
	}


	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}


	@Column(name = "purchaser")
	public String getPurchaser() {
		return purchaser;
	}


	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	@Column(name = "makeDate")
	public Date getMakeDate() {
		return makeDate;
	}


	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	@Column(name = "medicineName")
	public String getMedicineName() {
		return medicineName;
	}


	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	@Column(name = "medicineSpec")
	public String getMedicineSpec() {
		return medicineSpec;
	}


	public void setMedicineSpec(String medicineSpec) {
		this.medicineSpec = medicineSpec;
	}

	@Column(name = "probatchCode")
	public String getProbatchCode() {
		return probatchCode;
	}


	public void setProbatchCode(String probatchCode) {
		this.probatchCode = probatchCode;
	}

	@Column(name = "tproDate")
	public Date getTproDate() {
		return tproDate;
	}


	public void setTproDate(Date tproDate) {
		this.tproDate = tproDate;
	}

	@Column(name = "period")
	public Date getPeriod() {
		return period;
	}


	public void setPeriod(Date period) {
		this.period = period;
	}

	@Column(name = "approveCode")
	public String getApproveCode() {
		return approveCode;
	}


	public void setApproveCode(String approveCode) {
		this.approveCode = approveCode;
	}

	@Column(name = "certiCode")
	public String getCertiCode() {
		return certiCode;
	}


	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}

	@Column(name = "ckConclusion")
	public String getCkConclusion() {
		return ckConclusion;
	}


	public void setCkConclusion(String ckConclusion) {
		this.ckConclusion = ckConclusion;
	}

	@Column(name = "faceQuality")
	public String getFaceQuality() {
		return faceQuality;
	}


	public void setFaceQuality(String faceQuality) {
		this.faceQuality = faceQuality;
	}

	@Column(name = "place")
	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "supplier")
	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Column(name = "inbatchPrice")
	public double getInbatchPrice() {
		return inbatchPrice;
	}


	public void setInbatchPrice(double inbatchPrice) {
		this.inbatchPrice = inbatchPrice;
	}

	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	@Column(name = "repertory")
	public double getRepertory() {
		return repertory;
	}


	public void setRepertory(double repertory) {
		this.repertory = repertory;
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

	public void merge(Medicine medicine) {
		
		 this.medicineCode   = medicine.getMedicineCode();
		 this.billCode       = medicine.getBillCode();
		 this.purchaser      = medicine.getPurchaser();
		 this.makeDate       = medicine.getMakeDate();
		 this.medicineName   = medicine.getMedicineName();
		 this.medicineSpec   = medicine.getMedicineSpec();
		 this.probatchCode   = medicine.getProbatchCode();
		 this.tproDate       = medicine.getTproDate();
		 this.period         = medicine.getPeriod();
		 this.approveCode    = medicine.getApproveCode();
		 this.certiCode      = medicine.getCertiCode();
		 this.ckConclusion   = medicine.getCkConclusion();
		 this.faceQuality    = medicine.getFaceQuality();
		 this.place          = medicine.getPlace();
		 this.supplier       = medicine.getSupplier();
		 this.inbatchPrice   = medicine.getInbatchPrice();
		 this.amount         = medicine.getAmount();
		 this.price          = medicine.getPrice();
		 this.unit           = medicine.getUnit();
		 this.repertory      = medicine.getRepertory();
		 this.remark         = medicine.getRemark();
		 this.status         = medicine.getStatus();
	}

	@Override
	public String toString() {
		return "Medicine [medicineCode=" + medicineCode + ", billCode=" + billCode 
				+ ", purchaser=" + purchaser + ", makeDate=" + makeDate + ", medicineName=" + medicineName
				+ ", medicineSpec=" + medicineSpec + ", probatchCode=" + probatchCode + ", tproDate=" + tproDate
				+ ", period=" + period + ", approveCode=" + approveCode + ", certiCode=" + certiCode + ", ckConclusion="
				+ ckConclusion + ", faceQuality=" + faceQuality + ", place=" + place + ", supplier=" + supplier
				+ ", inbatchPrice=" + inbatchPrice + ", amount=" + amount + ", price=" + price + ", unit=" + unit
				+ ", remark=" + remark + ", status=" + status + "]";
	}

 
}
