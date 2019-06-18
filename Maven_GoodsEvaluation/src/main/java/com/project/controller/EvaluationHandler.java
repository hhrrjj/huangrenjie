package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.EvaluationBean;
import com.project.bean.UserBean;
import com.project.service.IEvaluationService;
import com.project.service.IGoodsService;

@Controller
public class EvaluationHandler {
	
	@Autowired
	@Qualifier("evaService")
	private IEvaluationService evaService;
	
	/*@GetMapping("/evaluation")
	public List<EvaluationBean> findAllByGoodsId(int goodsId) {
		List<EvaluationBean> list = evaService.findAllByGoodsId(goodsId);
		return list;
	}*/
	
	/*@GetMapping("/evaluation/{id}")
	public EvaluationBean findById(@PathVariable("id")int u_id) {
		EvaluationBean evaBean = evaService.findById(u_id);
		return evaBean;
	}*/
	
	@PostMapping("/evaluation")
	public String addEva(Model model,ModelMap map,@Validated EvaluationBean bean,HttpSession session,BindingResult result) {
		System.out.println(bean.getE_g_id());
		int g_id = bean.getE_g_id();
		
		model.addAttribute("bean", bean);
		System.out.println(bean);
		if (result.hasErrors()) {
			System.out.println("有错！！！");
			//获取到所有的校验错误信息
			List<FieldError> errorList = result.getFieldErrors();
			for (FieldError fieldError : errorList) {
				map.put("error_"+fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "redirect:/goods/"+g_id;
		}
		
		Date da = new Date();//得到当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//"yyyyMMddHHmmssSSS"
		String time = dateFormat.format(da);
		bean.setE_time(time);
		UserBean user = (UserBean)session.getAttribute("user");
		bean.setE_u_id(user.getU_id());
		
		System.out.println(user.getU_id());
		
		evaService.addEva(bean);
		return "redirect:/goods/"+g_id;
	}
	

}
 