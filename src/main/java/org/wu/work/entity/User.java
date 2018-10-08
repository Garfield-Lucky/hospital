package org.wu.work.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	/**
	  * 创建时间：2017-2-23 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 用户实体类
	 */
	private static final long serialVersionUID = 6980093847795726310L;
	private String userName;
	private String  trueName;
	private String  passWord;
	private int  userType;
	private int  status;
	private int  roleId;
	

	public User() {
		
	}


	public User(String userId, String userName, String trueName, String passWord, int userType, Integer status) {
		super();
		this.userName = userName;
		this.trueName = trueName;
		this.passWord = passWord;
		this.userType = userType;
		this.status = status;
	}

	@Id
	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "trueName")
	public String getTrueName() {
		return trueName;
	}


	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Column(name = "passWord")
	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "userType")
	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

	@Column(name = "roleId")
	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "User [ userName=" + userName + ", trueName=" + trueName + ", passWord=" + passWord
				+ ", userType=" + userType + ", status=" + status + "]";
	}


	public void merge(User user) {
		
		 this.trueName = user.getTrueName();
		 this.userType = user.getUserType();
	}

 
 
}
