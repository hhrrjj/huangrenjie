package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.GoodsBean;
import com.project.dao.IGoodsDao;
import com.project.dao.IUserDao;
import com.project.service.IGoodsService;

@Service(value="goodsService")
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	private IGoodsDao goodsDao;

	@Override
	public List<GoodsBean> findAll() {
		
		return goodsDao.findAll();
	}

	@Override
	public GoodsBean findByName(String name) {
		GoodsBean goodsBean = goodsDao.findByName(name);
		return goodsBean;
	}

	@Override
	public GoodsBean findById(int g_id) {
		GoodsBean goodsBean = goodsDao.findById(g_id);
		return goodsBean;
	}

}
