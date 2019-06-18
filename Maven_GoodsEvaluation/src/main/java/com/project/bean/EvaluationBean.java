package com.project.bean;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class EvaluationBean  {

	private int e_id;
	private int e_u_id;
	private int e_g_id;
	private String e_time;
	@NotBlank(message="评论内容不能为空")
	private String e_message;
	private UserBean userBean;
	private GoodsBean goodsBean;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getE_u_id() {
		return e_u_id;
	}
	public void setE_u_id(int e_u_id) {
		this.e_u_id = e_u_id;
	}
	public int getE_g_id() {
		return e_g_id;
	}
	public void setE_g_id(int e_g_id) {
		this.e_g_id = e_g_id;
	}
	public String getE_time() {
		return e_time;
	}
	public void setE_time(String e_time) {
		this.e_time = e_time;
	}
	public String getE_message() {
		return e_message;
	}
	public void setE_message(String e_message) {
		this.e_message = e_message;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public void setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
	}
	@Override
	public String toString() {
		return "EvaluationBean [e_id=" + e_id + ", e_u_id=" + e_u_id + ", e_g_id=" + e_g_id + ", e_time=" + e_time
				+ ", e_message=" + e_message + ", userBean=" + userBean + ", goodsBean=" + goodsBean + "]";
	}
	
	
	
}
