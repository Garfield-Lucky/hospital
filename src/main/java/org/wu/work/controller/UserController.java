package org.wu.work.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.User;
import org.wu.work.model.Muser;
import org.wu.work.service.UserService;

import com.alibaba.fastjson.JSONObject;


@SuppressWarnings("restriction")
@Controller
@RequestMapping(value = "/user")
public class UserController{
	
	/**
	 * 
	 * @author zhangwei
	 * @time 2017/02/18
	 *
	 */
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> addUser(User user){
		Map<String,Object> map=new HashMap<String,Object>();
		User flag = userService.queryUserByName(user.getUserName());
		if(flag!=null)
		{
			System.out.println("该用户已存在");
			map.put("flag",false); 
			map.put("msg","该用户已存在"); 
		}else{
		    User savaUser = userService.insertUser(user);
			if(savaUser!=null)
			{
			    System.out.println("插入成功");
			    map.put("flag",true); 
			    map.put("msg","添加成功"); 
			}else{
				map.put("flag",false); 
				map.put("msg","添加失败"); 
			}
		}
		return map;
	}
	
	@RequestMapping(value="/sel")
	@ResponseBody
	public Map<String,Object> queryUserById(String id) {
		Map<String,Object> map=new HashMap<String,Object>();
		 
		return map;
	}
	//管理员查看用户详细信息
	@RequestMapping(value="/detail")
	public ModelAndView queryUserDetailById(String userName) {
		System.out.println(userName);
		ModelAndView model = new ModelAndView("userDetail");
		User user=null;
		user=userService.queryUserByName(userName);
		if(user != null){
			model.addObject("flag",true);
			model.addObject("user", user);
		}else{
			model.addObject("flag",false);
		}
		return model;
	}
	//管理员查看用户列表（默认加载）
	@RequestMapping(value="/getUserList")
	@ResponseBody
	public Map<String,Object> getUserList(int page,int pageSize) {
		List<Map<String,String>> list = null;
		List<Map<String,String>> dataNum = null;
		 
	    list = userService.queryUserList(page, pageSize);
	    dataNum = userService.queryUserList();
		 
		JSONObject json = new JSONObject();
		if(list!=null)
		  {
			System.out.println("page="+page+"list="+list.size());
	    	List<Muser> listUser = new ArrayList<Muser>();
			Iterator<Map<String,String>> iter = list.iterator();
			Muser model;
			while(iter.hasNext()){
				Map<String,String> obj = iter.next();
				 model = new Muser();
				 model.setWorkNum(obj.get("userName"));
				 model.setUserName(obj.get("trueName"));
				 model.setUserType(obj.get("userType"));
				 
				 listUser.add(model);
			    }
				json.put("flag",true); 
				json.put("status","0000"); 
				json.put("currentPage",page/pageSize+1); 
				json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				json.put("dataNum",dataNum.size()); 
				json.put("list",listUser); 
		 }else{
			json.put("flag",false); 
			json.put("status","1111"); 
		  }
			return json;
	}
	
	//管理员查看指定用户信息
		@RequestMapping(value="/findByAdmin")
		@ResponseBody
		public Map<String,Object> queryUserByAdmin(int page,int pageSize,int flag,String workNum,String userName) {
			List<Map<String,String>> list = null;
			List<Map<String,String>> dataNum = null;
			System.out.println("workNum"+workNum+" "+"userName "+userName);
			if(flag==1)
			{
				   list = userService.queryUserByWorkNum(page, pageSize, workNum);
				   dataNum = userService.queryUserByWorkNum(workNum);
			}else if(flag==2){
				   list = userService.queryUserByUserName(page, pageSize, userName);
				   dataNum = userService.queryUserByUserName(userName);
			}else if(flag==3){
				   list = userService.queryUserByWorkNum(page, pageSize, workNum);
				   dataNum = userService.queryUserByWorkNum(workNum);
			}else{
				   list = userService.queryUserList(page, pageSize);
				   dataNum = userService.queryUserList();
			}
			 
			JSONObject json = new JSONObject();
			if(list!=null)
			  {
				System.out.println("page="+page+"list="+list.size());
		    	List<Muser> listUser = new ArrayList<Muser>();
				Iterator<Map<String,String>> iter = list.iterator();
				Muser model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new Muser();
					 model.setWorkNum(obj.get("userName"));
					 model.setUserName(obj.get("trueName"));
					 model.setUserType(obj.get("userType"));
					 
					 listUser.add(model);
				    }
					json.put("flag",true); 
					json.put("status","0000"); 
					json.put("currentPage",page/pageSize+1); 
					json.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
					json.put("dataNum",dataNum.size()); 
					json.put("list",listUser); 
			 }else{
				json.put("flag",false); 
				json.put("status","1111"); 
			  }
				return json;
		}
	
	@RequestMapping(value="/mod")
	@ResponseBody
	public Map<String,Object> modifyPassowrd(String password,String passwordOld,HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		User olduser = (User) session.getAttribute("userInfo");
		if(olduser.getPassWord().equals(passwordOld))
		{
			olduser.setPassWord(password);
			User save = userService.modifyUser(olduser);
			if(save != null)
			{
			    map.put("flag",true); 
			    map.put("status","0000"); 
			    map.put("msg","修改成功"); 
			}else{
				map.put("flag",false); 
			    map.put("status","1111"); 
			    map.put("msg","修改失败"); 
			}
		}else{
			map.put("flag",false); 
		    map.put("status","1111"); 
		    map.put("msg","原密码不正确"); 
		}
		return map;
	}
	@RequestMapping(value="/modUser")
	@ResponseBody
	public Map<String,Object> modifyUser(User user) {
		Map<String,Object> map=new HashMap<String,Object>();
		User olduser = userService.queryUserByName(user.getUserName());
		olduser.merge(user);
		 
		User save = userService.modifyUser(olduser);
			if(save != null)
			{
			    map.put("flag",true); 
			    map.put("status","0000"); 
			    map.put("msg","修改成功"); 
			}else{
				map.put("flag",false); 
			    map.put("status","1111"); 
			    map.put("msg","修改失败"); 
			}
		 
		return map;
	}
	
	@RequestMapping(value="/drop")
	@ResponseBody
	public Map<String,Object> deleteUserById(User user) {
		Map<String,Object> map=new HashMap<String,Object>();
		 
		return map;
	}
	
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String,Object> changStatusById(String userName) {
		Map<String,Object> map=new HashMap<String,Object>();
		int save = userService.deleteUser(userName);
		if(save != 0)
		{
			map.put("flag",true); 
		    map.put("status","0000"); 
		}else{
			map.put("flag",false); 
		    map.put("status","1111"); 
		}
		return map;
	}
	@RequestMapping(value="/delUser")
	@ResponseBody
	public Map<String,Object> deletUser(String workNum,int page,int pageSize,int flag) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,String>> dataNum = null;
		List<Map<String,String>> list = null;
		
		User status = userService.queryUserByName(workNum);
		if(status == null)
		{
			map.put("flag",false);
			map.put("status","1111");
			map.put("mes", "删除失败");
			return map;
		}else{
			status.setStatus(1);
			System.out.println("page"+page+" "+pageSize);
			@SuppressWarnings("unused")
			User change = userService.changStatus(status);
			//int user = userService.deleteUser(workNum);
			if(flag==1)
			{
				   list = userService.queryUserByWorkNum(page, pageSize, workNum);
				   dataNum = userService.queryUserByWorkNum(workNum);
			}else if(flag==2){
				   list = userService.queryUserByUserName(page, pageSize, workNum);
				   dataNum = userService.queryUserByUserName(workNum);
			}else if(flag==3){
				   list = userService.queryUserByWorkNum(page, pageSize, workNum);
				   dataNum = userService.queryUserByWorkNum(workNum);
			}else{
				   list = userService.queryUserList(page, pageSize);
				   dataNum = userService.queryUserList();
			}
			 
			if(list!=null)
			  {
				System.out.println("page="+page+"list="+list.size());
		    	List<Muser> listUser = new ArrayList<Muser>();
				Iterator<Map<String,String>> iter = list.iterator();
				Muser model;
				while(iter.hasNext()){
					 Map<String,String> obj = (Map<String,String>)iter.next();
					 model = new Muser();
					 model.setWorkNum(obj.get("USERNAME"));
					 model.setUserName(obj.get("TRUENAME"));
					 model.setUserType(obj.get("USERTYPE"));
					 
					 listUser.add(model);
				    }
				map.put("flag",true); 
				map.put("status","0000"); 
				map.put("currentPage",page/pageSize+1); 
				map.put("countPage",dataNum.size()%pageSize != 0?(dataNum.size()/pageSize+1):dataNum.size()/pageSize); 
				map.put("dataNum",dataNum.size()); 
				map.put("list",listUser); 
			 }else{
				 map.put("flag",false); 
				 map.put("status","1111"); 
			  }
		return map;
		}
	}
	
}
