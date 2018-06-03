package com.umbrella.common.model;

public class UmbrellaUser {
	
	private String user_id;
	private String user_name;
	private String user_phone;
	private String user_photoid;
	private String user_level;
	private String user_sex;
	private String user_birth;
	private String user_address;
	private String user_department;
	private String user_national;
	private String user_password;
	private String user_email;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_photoid() {
		return user_photoid;
	}
	public void setUser_photoid(String user_photoid) {
		this.user_photoid = user_photoid;
	}
	public String getUser_level() {
		return user_level;
	}
	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_department() {
		return user_department;
	}
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}
	public String getUser_national() {
		return user_national;
	}
	public void setUser_national(String user_national) {
		this.user_national = user_national;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public UmbrellaUser(String user_id, String user_name, String user_phone,
			String user_photoid, String user_level, String user_sex,
			String user_birth, String user_address, String user_department,
			String user_national, String user_password, String user_email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_photoid = user_photoid;
		this.user_level = user_level;
		this.user_sex = user_sex;
		this.user_birth = user_birth;
		this.user_address = user_address;
		this.user_department = user_department;
		this.user_national = user_national;
		this.user_password = user_password;
		this.user_email = user_email;
	}
	public UmbrellaUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
