package org.wu.work.controller;

 
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author zhangwei
 * @time 2017/02/18
 *
 */
@Controller
public class HomeController{

	/**
	 * 创建时间：2016-12-9 下午17:25:00  
     * @author 没有尾巴的章鱼  
     * @version 1.0  
     * 描述： 文章实体类
	 */
	@RequestMapping(value="/filter/home")
	public ModelAndView homepage(ModelMap model,HttpSession session){
		model.put("userInfo", session.getAttribute("userInfo"));
		return new ModelAndView("home");
	}

	
}
