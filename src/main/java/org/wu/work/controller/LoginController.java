package org.wu.work.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wu.work.entity.User;
import org.wu.work.service.UserService;
import org.wu.work.util.RedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@SuppressWarnings("restriction")
@Controller
public class LoginController{
	
	/**
	 * 
	 * @author zhangwei
	 * @time 2017/02/18
	 *
	 */
	
	@Resource
	private UserService userService;
	@Autowired
	private RedisUtil redisUtil;
//	@Autowired
//	private RedisTemplate redisTemplate;
	
//	@Autowired
//	private JedisPool jedisPool;
	
	@RequestMapping(value="/loginPage")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		return new ModelAndView("login");
	}

	//首页
	//首页2
	//首页3
	//首页4
	@RequestMapping(value="/")
	public ModelAndView index() {
		return new ModelAndView("login");
	}

	@RequiresRoles("admin")
	@ResponseBody
	@RequestMapping(value="/login")
	public Map<String,Object> login(String userName,String passWord,String autoLogin,
			HttpServletRequest request,HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException{
		Map<String,Object> map=new HashMap<String,Object>();
		User user=null;		

//	        redisTemplate.delete("myStr");  
//	        redisTemplate.opsForValue().set("myStr", "skyLine");  
//	        System.out.println(redisTemplate.opsForValue().get("myStr"));  
//	        System.out.println("---------------");  
//	        
//	     // List读写  
//	        redisTemplate.delete("myList");  
//	        redisTemplate.opsForList().rightPush("myList", "T");  
//	        redisTemplate.opsForList().rightPush("myList", "L");  
//	        redisTemplate.opsForList().leftPush("myList", "A");  
//	        List<String> listCache = redisTemplate.opsForList().range(  
//	                "myList", 0, -1);  
//	        for (String s : listCache) {  
//	            System.out.println(s);  
//	        }  
//	        System.out.println("---------------");  
//	  
//	        // Set读写  
//	        redisTemplate.delete("mySet");  
//	        redisTemplate.opsForSet().add("mySet", "A");  
//	        redisTemplate.opsForSet().add("mySet", "B");  
//	        redisTemplate.opsForSet().add("mySet", "C");  
//	        Set<String> setCache = redisTemplate.opsForSet().members(  
//	                "mySet");  
//	        for (String s : setCache) {  
//	            System.out.println(s);  
//	        }  
//	        System.out.println("---------------");  
//	  
//	        // Hash读写  
//	        redisTemplate.delete("myHash");  
//	        redisTemplate.opsForHash().put("myHash", "BJ", "北京");  
//	        redisTemplate.opsForHash().put("myHash", "SH", "上海");  
//	        redisTemplate.opsForHash().put("myHash", "HN", "河南");  
//	        Map<String, String> hashCache = redisTemplate.opsForHash()  
//	                .entries("myHash");  
//	        for (Map.Entry entry : hashCache.entrySet()) {  
//	            System.out.println(entry.getKey() + " - " + entry.getValue());  
//	        }  
//	        System.out.println("---------------");  
		
//		Jedis jedis = jedisPool.getResource();
//        //存值
//        jedis.set("user.name", "aaa");
//        jedis.set("user.pass", "123");
//         
//        //取值
//        String name = jedis.get("user.name");
//        String pass = jedis.get("user.pass");
//        System.out.println("name:"+name+" pass:"+pass);


         
//        result = jedis.exists("user.pass");

         
      
		
//		Cookie[] cookies = request.getCookies();
//		if(cookies!=null){
//			for(Cookie c:cookies){
//				System.out.println(URLDecoder.decode(c.getName())+" : "+URLDecoder.decode(c.getValue()));
//			}
//		}
		/**
		 * -Xms40m -Xmx40m
          -XX:+HeapDumpOnOutOfMemoryError -Dcatalina.base="D:\runtime\hostipal" -Dcatalina.home="E:\tomcat\apache-tomcat-7.0.40" -Dwtp.deploy="D:\runtime\hostipal\wtpwebapps" -Djava.endorsed.dirs="E:\tomcat\apache-tomcat-7.0.40\endorsed"
		 */
//		 if((userName!="")&&(passWord!="")){
			map=userService.queryUser(userName, passWord);
//			if(map!=null){
//				user=(User) map.get("userInfo");
//				String sessionId = request.getSession().getId();
//				redisUtil.set(sessionId, user, 1800L);
//				session.setAttribute("userInfo", user);
//				session.setMaxInactiveInterval(30*60);//过期时间为30分钟
//			}
			
	    Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord) ;
        try {
            subject.login(token);
            User userInfo  = user=(User) map.get("userInfo");
            System.out.println(userInfo.getUserName());
            map.put("userInfo", userInfo);
            String sessionId = request.getSession().getId();
			redisUtil.set(sessionId, user, 1800L);
			session.setAttribute("userInfo", user);
			session.setMaxInactiveInterval(30*60);//过期时间为30分钟
            return map ;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//		            e.printStackTrace();
        	map.put("flag",true);
            return map ;
        }
			
//			if(autoLogin.equals("true") && map.get("flag").toString().equals("true"))
//			{
//			//创建cookie对象
//			Cookie c1 = new Cookie(URLEncoder.encode(userName, "UTF-8")+"_name",URLEncoder.encode(userName, "UTF-8"));
//			Cookie c2 = new Cookie(URLEncoder.encode(userName, "UTF-8")+"_pwd",URLEncoder.encode(passWord, "UTF-8"));
//			//设置cookie的有效时间
//			c1.setMaxAge(30*60);
//			c2.setMaxAge(30*60);
//			//把cookie放到response里面
//			resp.addCookie(c1);
//			resp.addCookie(c2);
//			}
	}
	
	@ResponseBody
	@RequestMapping(value="/register")
	public Map<String,Object> register(String userName,String trueName,String passWord,
			HttpServletRequest request,HttpServletResponse resp)
			throws ServletException, IOException{
		Map<String,Object> map=new HashMap<String,Object>();
       System.out.println(userName);
       System.out.println(trueName);
       System.out.println(passWord);

		 if((userName != "")&&(passWord != "")){
			map=userService.insertUser(userName,trueName,passWord);
		 }
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/registerCheck")
	public Map<String,Object> registerCheck(String userName,
			HttpServletRequest request,HttpServletResponse resp)
			throws ServletException, IOException{
		Map<String,Object> map=new HashMap<String,Object>();
       System.out.println(userName);

		 if((userName != "")){
			User user = userService.queryUserByName(userName);
			if(user!=null)
			{
				map.put("flag", true);
			}
		 }
		return map;
	}
	//检查session是否过期
	@ResponseBody
	@RequestMapping(value="/filter/sessionCheck")
	public Map<String,Object>  sessionCheck(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("userInfo")==null){
			map.put("status", "1111");
		}else{
			map.put("status", "0000");
		}
		return map;
	}
	
	@RequestMapping(value="/filter/logout")
	public String logout(HttpSession session){
		session.removeAttribute("userInfo");
		return "login";
	}
}
