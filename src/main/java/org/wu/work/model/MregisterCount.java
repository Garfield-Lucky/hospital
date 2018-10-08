package org.wu.work.model;


public class MregisterCount {

	private String  registerNum;
	private String  tuihaoNum;
	private String  registerFee;
	private String  stime;
	private String  etime;
	
	
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getTuihaoNum() {
		return tuihaoNum;
	}
	public void setTuihaoNum(String tuihaoNum) {
		this.tuihaoNum = tuihaoNum;
	}
	public String getRegisterFee() {
		return registerFee;
	}
	public void setRegisterFee(String registerFee) {
		this.registerFee = registerFee;
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
	@Override
	public String toString() {
		return "MregisterCount [registerNum=" + registerNum + ", tuihaoNum=" + tuihaoNum + ", registerFee="
				+ registerFee + ", stime=" + stime + ", etime=" + etime + "]";
	}
	 
}
