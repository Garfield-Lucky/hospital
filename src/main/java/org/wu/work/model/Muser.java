package org.wu.work.model;


public class Muser {

	private String  workNum;
	private String  userName;
	private String  userType;
	
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "Muser [workNum=" + workNum + ", userName=" + userName + ", userType=" + userType + "]";
	}
	
	 
	
}
