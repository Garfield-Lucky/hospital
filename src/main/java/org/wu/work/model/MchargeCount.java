package org.wu.work.model;


public class MchargeCount {
	
	private String clerk;
	private String checkCategory;
	private String medicineCategory;
	private String total;
	private String stime;
	private String etime;
	private String time;
	
	
	public String getClerk() {
		return clerk;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public String getCheckCategory() {
		return checkCategory;
	}
	public void setCheckCategory(String checkCategory) {
		this.checkCategory = checkCategory;
	}
	public String getMedicineCategory() {
		return medicineCategory;
	}
	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "MchargeCount [clerk=" + clerk + ", checkCategory=" + checkCategory + ", medicineCategory="
				+ medicineCategory + ", total=" + total + ", stime=" + stime + ", etime=" + etime + ", time=" + time
				+ "]";
	}
	 
	
}
