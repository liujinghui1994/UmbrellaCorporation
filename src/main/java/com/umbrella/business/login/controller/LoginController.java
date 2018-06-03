package com.umbrella.business.login.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.umbrella.business.login.service.LoginService;
import com.umbrella.common.model.Result;
import com.umbrella.common.model.UmbrellaUser;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

    /**
     * 登陆页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginPage")
    public ModelAndView loginPage(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/login/login");
        return mav;
    }
    
    
	/**
     * 执行登陆
     * @param //request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/doLogin")
    public Result doLogin(UmbrellaUser umbrellaUser) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	UmbrellaUser result = loginService.loginUser(umbrellaUser);

    	if(null == result){
    		return new Result(false, "Access Denied");
    	}
    	return new Result(true, "Access Successed");
    }
    
}
