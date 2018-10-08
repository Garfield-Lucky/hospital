package org.wu.work.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wu.work.entity.User;
import org.wu.work.repository.impl.UserRepository;
import org.wu.work.service.UserService;


@SuppressWarnings("restriction")
@Service("UserService")
public class UserServiceImpl implements UserService{

	
	@Resource
	private UserRepository userRepository;
	 

	public Map<String,Object> queryUser(String userName, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user=null;
		user=userRepository.queryUserByName(userName);
		if(user==null){
			System.out.println("null");
			map.put("flag",false);
			map.put("num","1");
			map.put("msg", "此用户不存在！");
		}else{
			map.put("flag",true);
		}
		map.put("userInfo", user);
		return map;
	}

	
	public User queryUserByName(String userName) {
		User user=null;
		user=userRepository.queryUserByName(userName);
		return user;
	}
	public Map<String, Object> insertUser(String userName, String trueName, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		User user=null;
		user=userRepository.queryUserByName(userName);
		if(user != null){
			System.out.println("此用户名已存在！");
			map.put("flag",false);
			map.put("num","1");
			map.put("msg", "此用户名已存在！");
		}else{
			user=new User();
			user.setUserName(userName);
			user.setTrueName(trueName);
			user.setPassWord(password);
			user.setUserType(0);
			user.setStatus(0);
			User save = userRepository.save(user);
			if(save != null)
			{
		    	map.put("flag",true); 
			}
		}
		return map;
	}

	public User insertUser(User user) {
		return userRepository.saveUser(user);
	}

	public Map<String, Object> modifyUser(User user,String name) {
		Map<String,Object> map=new HashMap<String,Object>();
		User flag = userRepository.queryUserByName(user.getUserName());
		if(flag != null && !name.equals(flag.getUserName())){
			System.out.println("此用户名已存在！" +name + "  "+flag.getUserName());
			map.put("flag",false);
			map.put("num","1");
			map.put("msg", "此用户名已存在！");
		}else{
			User olduser = userRepository.queryUserById(user.getUserName());
			olduser.merge(user);
			userRepository.save(olduser);
			map.put("flag",true); 
		}
		return map;
	}

	public User modifyUser(User user) {
		return userRepository.save(user);
	}


	public User changStatus(User user) {
		return userRepository.saveUser(user);
	}


	public int deleteUser(String userName) {
		return userRepository.deleteUser(userName);
	}

	public List<Map<String,String>> queryUserList(int page, int pageSize) {
		return userRepository.queryUserList(page, pageSize);
	}
	public List<Map<String,String>> queryUserByWorkNum(int page, int pageSize, String workNum) {
		return userRepository.queryUserByWorkNum(page, pageSize, workNum);
	}
	public List<Map<String,String>> queryUserByUserName(int page, int pageSize, String userName) {
		return userRepository.queryUserByUserName(page, pageSize, userName);
	}


	public List<Map<String,String>> queryUserByWorkNum(String workNum) {
		return userRepository.queryUserByWorkNum(workNum);
	}

	public List<Map<String,String>> queryUserByUserName(String userName) {
		return userRepository.queryUserByUserName(userName);
	}


	public List<Map<String,String>> queryUserList() {
		return userRepository.queryUserList();
	}

     //获取用户的角色
	public List<Map<String, String>> findRoles(String userName) {

        StringBuffer querySql = new StringBuffer();
        querySql.append("select distinct r.roleName from tb_user u,tb_role r where u.roleId=r.id and u.userName= :userName ");
		
        return userRepository.executeSql(querySql.toString(), new String[]{"userName"},userName);
	}

    //获取用户所拥有的权限
	public List<Map<String, String>> findPermissions(String userName) {
		 StringBuffer querySql = new StringBuffer();
	     querySql.append("select distinct p.permissionName from tb_user u,tb_role r,tb_permission p where u.roleId=r.id and p.roleId=r.id and u.userName= :userName ");
	
	     return userRepository.executeSql(querySql.toString(), new String[]{"userName"},userName);
	}

	 
}
