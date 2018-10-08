package org.wu.work.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class role implements Serializable{

	/**
	  * 创建时间：2018-7-1 下午17:25:00  
      * @author 没有尾巴的章鱼  
      * @version 1.0  
      * 描述： 角色表
	 */
	private static final long serialVersionUID = 6980093847854726310L;

	private int id;
	private String roleName;
	
	

	public role() {
		
	}


	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "roleName")
	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


 
 
}
