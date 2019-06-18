package com.project.bean;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class UserBean {
	private int u_id;
	@NotBlank(message="用户名不能为空")
	private String u_name;
	@NotBlank(message="密码不能为空")
	private String u_password;
	private List<EvaluationBean> evalist;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	public List<EvaluationBean> getEvalist() {
		return evalist;
	}
	public void setEvalist(List<EvaluationBean> evalist) {
		this.evalist = evalist;
	}
	@Override
	public String toString() {
		return "UserBean [u_id=" + u_id + ", u_name=" + u_name + ", u_password=" + u_password + ", evalist=" + evalist
				+ "]";
	}
	
	
	
}
