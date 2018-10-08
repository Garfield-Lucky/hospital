package org.wu.work.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wu.work.entity.User;
import org.wu.work.service.UserService;
import org.wu.work.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Component
public class LoginFilter implements Filter{

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private UserService userService;
	
	
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init.....................................................");
		System.out.println(userService);
		//		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
//		jedisPool = (JedisPool)context.getBean("jedisPool");
//	    System.out.println(jedisPool);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		String sessionId=req.getRequestedSessionId();
//		if(session==null||session.getAttribute("userInfo")==null){
		if(sessionId==null||redisUtil.get(sessionId)==null){
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		}else{
//			User user = (User) session.getAttribute("userInfo");
			User user = (User) redisUtil.get(sessionId);
			System.out.println(sessionId);
			redisUtil.set(sessionId, user, 1800L);
			chain.doFilter(request, response);
		}
		 
	}

	public void destroy() {
		
		
	}

//	public JedisPool getJedisPool() {
//		return jedisPool;
//	}
//
//	public void setJedisPool(JedisPool jedisPool) {
//		this.jedisPool = jedisPool;
//		System.out.println(jedisPool);
//	}

	
}
