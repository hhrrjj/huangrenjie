package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.project.bean.UserBean;

public interface IUserDao {
	@Select("select * from user")
	public List<UserBean> findAll();
	
	@Select("select * from user where u_name=#{u_name}")
	public UserBean findByName(String name);
	
	@Select("select * from user where u_id=#{u_id}")
	public UserBean findById(int u_id);
	
	@Insert("insert into user(u_name,u_password) values(#{u_name},#{u_password})")
	public void add(UserBean bean);
}
