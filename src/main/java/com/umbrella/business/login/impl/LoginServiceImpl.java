package com.umbrella.business.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.business.login.dao.LoginDao;
import com.umbrella.business.login.service.LoginService;
import com.umbrella.common.model.UmbrellaUser;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UmbrellaUser loginUser(UmbrellaUser umbrellaUser){
		UmbrellaUser queryUser = loginDao.loginUser(umbrellaUser);
		return queryUser;
	}
}
