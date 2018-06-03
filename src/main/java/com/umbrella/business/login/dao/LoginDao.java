package com.umbrella.business.login.dao;

import org.springframework.stereotype.Repository;

import com.umbrella.common.model.UmbrellaUser;

@Repository
public interface LoginDao {
	
	public UmbrellaUser loginUser(UmbrellaUser umbrellaUser);
	
}