package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.EvaluationBean;
import com.project.bean.GoodsBean;
import com.project.service.IEvaluationService;
import com.project.service.IGoodsService;
import com.project.service.IUserService;

@Controller
public class GoodsHandler {
	
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;
	
	@Autowired
	@Qualifier("evaService")
	private IEvaluationService evaService;
	
	
	@RequestMapping("/goods")
	public String findAll(ModelMap map,Model model,HttpSession session){
		List<GoodsBean> list = goodsService.findAll();
		map.put("list", list);
		for (GoodsBean goodsBean : list) {
			System.out.println(goodsBean);
		}
		//evaService.findCountByGoodsId(goodsId);
		return "/evaluation/pages/index.html";
	}
	
	@GetMapping("/goods/{id}")
	public String findById(@PathVariable("id")int g_id,ModelMap map,Model model,HttpSession session){
		GoodsBean goodsBean = goodsService.findById(g_id);
		goodsBean.setG_image("/evaluation/image/"+goodsBean.getG_image());
		
		map.put("goodsBean", goodsBean);
		List<EvaluationBean> evaList = evaService.findAllByGoodsId(g_id);
		map.put("evaList", evaList);		
				
		return "/evaluation/pages/replyPost.html";
	}
	

}
