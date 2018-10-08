package org.wu.work.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_permission")
public class permission implements Serializable{

	/**
	  * 创建时间：2018-7-1 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 权限表
	 */
	private static final long serialVersionUID = 6980093857854726310L;

	private int id;
	private String permissionName;
	private int roleId;
	
	

	public permission() {
		
	}


	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "permissionName")
	public String getPermissionName() {
		return permissionName;
	}


	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "roleId")
	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	
 
}
