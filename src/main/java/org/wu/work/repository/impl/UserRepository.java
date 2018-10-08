package org.wu.work.repository.impl;


import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.wu.work.entity.User;
import org.wu.work.repository.RepositorySupport;

@Repository("userRepository")
public class UserRepository extends RepositorySupport<User> {

	//根据用户名在数据库中查询用户
	/**
	 * @param userName
	 * @return
	 */
	public User queryUserByName(String userName){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("userName", userName));
		detachedCriteria.add(Restrictions.eq("status", 0));
		return this.findOne(detachedCriteria);
		
//		String sql = "select * from tb_user";
//		List<Object> list = this.executeSql(sql);
//		System.out.println(list.size());
//		System.out.println("kkk0000");
//		return null;
	}
	
	public User queryUserById(String id){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("id", id));
		System.out.println("id="+id);
		return this.findOne(detachedCriteria);
		
//		String sql = "select * from tb_user";
//		List<Object> list = this.executeSql(sql);
//		System.out.println(list.size());
//		System.out.println("kkk0000");
//		return null;
	}
	public int deleteUser(String userName){
		String sql = "update tb_user set status = 1 where userName = :userName";
		return  this.executeUpdateSql(sql, new String[]{"userName"}, userName);
	}
	//管理员管理系统用户
	public List<Map<String,String>> queryUserList(){
		String sql = "select userName,trueName,userType from tb_user where status =0 and userType <>0" ;
		List<Map<String,String>> list = this.executeSql(sql);
		return list;
	}
	public List<Map<String,String>> queryUserList(int page,int pageSize){
		String sql = "select userName,trueName,userType from tb_user where status =0 and userType <>0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize);
		return list;
	}
	public List<Map<String,String>> queryUserByWorkNum(int page,int pageSize,String workNum){
		String sql = "select userName,trueName,userType from tb_user where userName =:workNum and status =0 and userType <>0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"workNum"},workNum);
		return list;
	}
	public List<Map<String,String>> queryUserByUserName(int page,int pageSize,String userName){
		String sql = "select userName,trueName,userType from tb_user where trueName =:userName and status =0 and userType <>0" ;
		List<Map<String,String>> list = this.executeSqlPage(sql, page, pageSize,  new String[]{"userName"},userName);
		return list;
	}
	//分页
	public List<Map<String,String>> queryUserByWorkNum(String workNum){
		String sql = "select userName,trueName,userType from tb_user where userName =:workNum and status =0 and userType <>0" ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"workNum"},workNum);
		return list;
	}
	public List<Map<String,String>> queryUserByUserName(String userName){
		String sql = "select userName,trueName,userType from tb_user where trueName =:userName and status =0 " ;
		List<Map<String,String>> list = this.executeSql(sql,new String[]{"userName"},userName);
		return list;
	}
	
//	保存用户账号信息
	public User saveUser(User user) {
		try {
			return this.save(user);
		} catch (Exception e) {
			return null;
		}
	}
	 
}
