package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.project.bean.GoodsBean;

public interface IGoodsDao {
	
	@Select("select * from goods")
	@Results({
		@Result(property="g_id",column="g_id"),
		@Result(property="evaList",column="g_id",many=@Many(select="com.project.dao.IEvaluationDao.findAllByGoodsId")),
	})
	public List<GoodsBean> findAll();
	
	@Select("select * from goods where g_name=#{g_name}")
	public GoodsBean findByName(String name);
	
	@Select("select * from goods where g_id=#{g_id}")
	public GoodsBean findById(int g_id);
	
	@Insert("insert into goods(g_name,g_price,g_type) values(#{g_name},#{g_price},#{g_type})")
	public void add(GoodsBean bean);
	
	

}
