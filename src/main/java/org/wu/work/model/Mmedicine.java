package org.wu.work.model;


public class Mmedicine {
	
	private String  medicineName;
	private String  medicineSpec;
	private String  supplier;
	private String  sales;
	private String  price;     
	private String  repertory;
	
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineSpec() {
		return medicineSpec;
	}
	public void setMedicineSpec(String medicineSpec) {
		this.medicineSpec = medicineSpec;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRepertory() {
		return repertory;
	}
	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}
	@Override
	public String toString() {
		return "Mmedicine [medicineName=" + medicineName + ", medicineSpec=" + medicineSpec + ", supplier=" + supplier
				+ ", sales=" + sales + ", price=" + price + ", repertory=" + repertory + "]";
	} 
	
	 
	
}
