package org.wu.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver{
    /**
     * 处理上传文件大小超过限制抛出的异常
     */
    public ModelAndView resolveException(HttpServletRequest req,
            HttpServletResponse res, Object ob,Exception ex) {
        ModelAndView mv=new ModelAndView();
        //判断异常类型，来跳转不同页面
        if (ex instanceof MaxUploadSizeExceededException){ 
            //指定错误信息
            mv.addObject("errormessage", "上传文件过大");
            //设置跳转视图
            mv.setViewName("uploadFail");
            return mv;
        }  
        //其他异常
        return null;
    }
}