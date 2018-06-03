package com.umbrella.common.session.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UmbrellaSessionListener implements HttpSessionListener {

    private UmbrellaSessionContext context = UmbrellaSessionContext.getInstance();


    public void sessionCreated(HttpSessionEvent e) {
        context.addSession(e.getSession());
    }


    public void sessionDestroyed(HttpSessionEvent e) {
//        User user = (User)e.getSession().getAttribute("user");

        //获取service
//        UserServies userServies =(UserServies) getObjectFromApplication(e.getSession().getServletContext(),"userServies");

        //获取用户的sessionId和用户在线状态
//        User tempUser = userServies.selectUserByKey(user.getId());

        //如果用户在线且sessionId和e.getSession().getId()相同说明下线，不是更替。
        //则修改用户的在线状态和session设置null。
//        if(tempUser.getOnlinestatus() == 1 && e.getSession().getId().equals(tempUser.getSessionid())) {
//            tempUser.setOnlinestatus(0);
//            tempUser.setSessionid(null);
//            userServies.updateByPrimaryKey(tempUser);
//        }

        context.delSession(e.getSession());
    }

    private Object getObjectFromApplication(ServletContext servletContext,String beanName){
        //通过WebApplicationContextUtils 得到Spring容器的实例。
        ApplicationContext application=WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //返回Bean的实例。
        return application.getBean(beanName);
    }
}
