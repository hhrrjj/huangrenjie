package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.project.bean.EvaluationBean;

public interface IEvaluationDao {
	@Select("select * from evaluation where e_g_id=#{e_g_id}")
	@Results({
		
		@Result(property="userBean",column="e_u_id",one=@One(select="com.project.dao.IUserDao.findById")),
	})
	public List<EvaluationBean> findAllByGoodsId(int goodsId);
	
	@Select("select count(*) from evaluation where e_g_id=#{e_g_id}")
	public Integer findCountByGoodsId(int goodsId);
	
	
	@Select("select * from evaluation where e_id=#{e_id}")
	public EvaluationBean findById(int u_id);
	
	@Insert("insert into evaluation(e_u_id,e_g_id,e_time,e_message) values(#{e_u_id},#{e_g_id},#{e_time},#{e_message})")
	public void add(EvaluationBean bean);

}
