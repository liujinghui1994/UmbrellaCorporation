package com.umbrella.business.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.umbrella.common.session.helper.UmbrellaSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.umbrella.business.login.service.LoginService;
import com.umbrella.common.model.Result;
import com.umbrella.common.model.UmbrellaUser;
import redis.clients.jedis.Jedis;


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
    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin(HttpServletRequest request, HttpSession session, Model model, UmbrellaUser umbrellaUser) throws Exception {
        Result result = new Result();
    	UmbrellaUser user = loginService.loginUser(umbrellaUser);
    	String url = "";
    	boolean loginResult = false;
    	if(null == user){
            url = "/pages/login/login";
            loginResult = false;
        }
        //删除上一个登录的session
        UmbrellaUser sessionExistUser = new UmbrellaUser();
        sessionExistUser = (UmbrellaUser) session.getAttribute("umbrellaUser");

        if(null != sessionExistUser) {
            HttpSession oldSession = context.getSession(session.getId());
            if(oldSession != null){
                oldSession.invalidate();
//                session.removeAttribute("umbrellaUser");
            }
        }




        //创建redis实例
        Jedis jedis = new Jedis("192.168.3.101",6379,10000);
        System.out.println("测试连接："+jedis.ping());
        String userId = user.getUser_id();
        String sessionId = "";
        sessionId = jedis.exists(userId) ? "" : jedis.get(userId);
        if("".equals(sessionId) || null == sessionId){
            jedis.append(user.getUser_id(),session.getId());
        }



        session.setAttribute("umbrellaUser",user);
        url = "/MainIndexPage";
        loginResult = true;
        result.setFlag(loginResult);
        result.setReturnMsg(url);
        return result;
    }

}
