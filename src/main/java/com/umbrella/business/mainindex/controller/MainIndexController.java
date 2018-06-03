package com.umbrella.business.mainindex.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainIndexController {

	private static final Logger logger = LoggerFactory.getLogger(MainIndexController.class);
	
	/**
     * 首页
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/MainIndexPage")
    public ModelAndView MainIndexPage(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/mainindex/mainindex");
        return mav;
    }
    
}
