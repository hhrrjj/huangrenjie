package com.project.bean;

import java.util.List;

public class GoodsBean {

	private int g_id;
	private String g_name;
	private double g_price;
	private String g_type;
	private String g_image;
	private UserBean userBean;
	private List<EvaluationBean> evaList;
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public double getG_price() {
		return g_price;
	}
	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public List<EvaluationBean> getEvaList() {
		return evaList;
	}
	public void setEvaList(List<EvaluationBean> evaList) {
		this.evaList = evaList;
	}
	
	public String getG_image() {
		return g_image;
	}
	public void setG_image(String g_image) {
		this.g_image = g_image;
	}
	@Override
	public String toString() {
		return "GoodsBean [g_id=" + g_id + ", g_name=" + g_name + ", g_price=" + g_price + ", g_type=" + g_type
				+ ", g_image=" + g_image + ", userBean=" + userBean + ", evaList=" + evaList + "]";
	}
	
	
}
