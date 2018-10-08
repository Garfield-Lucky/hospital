package org.wu.work.service;

import java.util.List;
import java.util.Map;

import org.wu.work.entity.User;

public interface UserService {
	
	public User queryUserByName(String userName);
	public Map<String,Object> queryUser(String userName,String password);
	public Map<String,Object> insertUser(String userName,String trueName,String password);
	public User insertUser(User user);
	public User modifyUser(User user);
	public User changStatus(User user);
	public int deleteUser(String userName);
	
	public List<Map<String,String>> queryUserList();
	public List<Map<String,String>> queryUserList(int page,int pageSize);
	public List<Map<String,String>> queryUserByWorkNum(int page,int pageSize,String workNum);
	public List<Map<String,String>> queryUserByUserName(int page,int pageSize,String userName);
	
	//分页
	public List<Map<String,String>> queryUserByWorkNum(String workNum);
	public List<Map<String,String>> queryUserByUserName(String userName);
	
	//通过用户名查找所拥有的角色
	public List<Map<String,String>> findRoles(String userName);
	
	//通过用户名查找所拥有的权限
	public List<Map<String,String>> findPermissions(String userName);
	
	
}
