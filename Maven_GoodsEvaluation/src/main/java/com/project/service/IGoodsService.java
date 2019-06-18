package com.project.service;

import java.util.List;

import com.project.bean.GoodsBean;
import com.project.bean.UserBean;

public interface IGoodsService {
	public List<GoodsBean> findAll();
	public GoodsBean findByName(String name);
	public GoodsBean findById(int g_id);
	//public void addGoods(GoodsBean bean);

}
