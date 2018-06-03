package com.umbrella.business.register.dao;

import org.springframework.stereotype.Repository;

import com.umbrella.common.model.UmbrellaUser;

@Repository
public interface RegisterDao {
	
	public int registerUser(UmbrellaUser umbrellaUser);
	
}