package com.umbrella.business.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.umbrella.common.session.helper.UmbrellaSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    private UmbrellaSessionContext context = UmbrellaSessionContext.getInstance();
	
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
    public Result doLogin(HttpServletRequest request, HttpSession session, Model model, UmbrellaUser umbrellaUser) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	UmbrellaUser user = loginService.loginUser(umbrellaUser);

    	if(null == user){
    		return new Result(false, "Access Denied");
    	}
        session.setAttribute("user",user);

//        User tempuser = new User();
//        tempuser.setOnlinestatus(1);
//        tempuser.setSessionid(session.getId());
//        tempuser.setId(id);
//        userServies.updateByPrimaryKeySelective(tempuser);
//
//        //删除上一个登录的session
//        if(user.getOnlinestatus() == 1 && user.getSessionid() != null) {
//            HttpSession oldSession = context.getSession(user.getSessionid());
//            if(oldSession != null)
//                oldSession.invalidate();
//        }


    	return new Result(true, "Access Successed");
    }

}
