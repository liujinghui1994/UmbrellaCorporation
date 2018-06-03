package com.umbrella.business.register.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.umbrella.business.register.service.RegisterService;
import com.umbrella.common.model.Result;
import com.umbrella.common.model.UmbrellaUser;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService registerService;
	/**
     * 注册页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerPage")
    public ModelAndView registerPage(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/register/register");
        return mav;
    }
    
    
	/**
     * 保存注册页面
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/saveRegisterDetail")
    public Result saveRegisterDetail(UmbrellaUser umbrellaUser) throws Exception {
    	int result = registerService.registerUser(umbrellaUser);
        return new Result(true,"注册成功");
    }
    
}
