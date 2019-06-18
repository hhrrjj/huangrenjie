package com.project.service;

import java.util.List;

import com.project.bean.EvaluationBean;

public interface IEvaluationService {
	public List<EvaluationBean> findAllByGoodsId(int goodsId);
	public Integer findCountByGoodsId(int goodsId);
	public EvaluationBean findById(int u_id);
	public void addEva(EvaluationBean bean);

}
