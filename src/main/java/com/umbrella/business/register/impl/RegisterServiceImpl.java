package com.umbrella.business.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.umbrella.business.register.dao.RegisterDao;
import com.umbrella.business.register.service.RegisterService;
import com.umbrella.common.model.UmbrellaUser;


@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public int registerUser(UmbrellaUser umbrellaUser){
		int result = registerDao.registerUser(umbrellaUser);
		return result;
	}
}
