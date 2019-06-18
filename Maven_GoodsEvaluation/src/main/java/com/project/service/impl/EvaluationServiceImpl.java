package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.EvaluationBean;
import com.project.dao.IEvaluationDao;
import com.project.dao.IGoodsDao;
import com.project.service.IEvaluationService;

@Service(value="evaService")
public class EvaluationServiceImpl implements IEvaluationService {
	
	@Autowired
	private IEvaluationDao evaDao;

	@Override
	public List<EvaluationBean> findAllByGoodsId(int goodsId) {
		
		return evaDao.findAllByGoodsId(goodsId);
	}

	@Override
	public Integer findCountByGoodsId(int goodsId) {
		
		return evaDao.findCountByGoodsId(goodsId);
	}

	@Override
	public EvaluationBean findById(int u_id) {
		
		return evaDao.findById(u_id);
	}

	@Override
	public void addEva(EvaluationBean bean) {
		evaDao.add(bean);

	}

}
