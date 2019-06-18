package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.ReportAsSingleViolation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.UserBean;
import com.project.service.IUserService;

@Controller
public class UserHandler {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@GetMapping("/user")
	@ResponseBody
	public List<UserBean> findAllUser(){
		List<UserBean> list = userService.findAll();
		return list;
	}
	
	@GetMapping("/user/{name}")
	public UserBean findByName(@PathVariable("name")String name){
		UserBean user = userService.findByName(name);
		return user;
	}
	
	@GetMapping("/user/version/{id}")
	public UserBean findById(@PathVariable("id")int id){
		UserBean user = userService.findById(id);
		return user;
	}
	
	@RequestMapping("/login")
	public String login(UserBean userBean,HttpSession session,Integer remember){
		System.out.println("re"+remember);
		
		String name = userBean.getU_name();
		String pwd = userBean.getU_password(); 
		
		//产生一个用户（门面对象）
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
	        UsernamePasswordToken token = new UsernamePasswordToken(name,pwd);
	        //记住我
        	if (remember==1) {
				token.setRememberMe(true);
			}/*else if (remember==2 || remember==null){
				token.setRememberMe(false);
			}*/
	        try {
	        	
	        	//调用login进行认证
	            currentUser.login(token);
	            System.out.println("认证成功");
	            UserBean user = userService.findByName(name);
	            session.setAttribute("user", user);
	            System.out.println(user);
	            return "redirect:/goods";
	            //return "redirect:/evaluation/pages/index2.html";
	        } 
	        // 父异常。认证失败异常
	        catch (AuthenticationException ae) {
	            //unexpected condition?  error?
	        	System.out.println("异常不详：自己解决");
	        	//return "/goods";
	        	return "redirect:/evaluation/pages/login.html";
	        }
	     }
		 //return "/goods";	
		 return "redirect:/evaluation/pages/login.html";
	}
	
	@PostMapping("/user")
	public String register(Model model,ModelMap map,@Validated UserBean userBean,BindingResult result){
		
		model.addAttribute("userBean", userBean);
		System.out.println(userBean);
		if (result.hasErrors()) {
			System.out.println("有错！！！");
			//获取到所有的校验错误信息
			List<FieldError> errorList = result.getFieldErrors();
			for (FieldError fieldError : errorList) {
				map.put("error_"+fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "forward:/evaluation/pages/register.html";
		}
		String name = userBean.getU_name();
		String pwd = userBean.getU_password(); 

		Object obj = new SimpleHash("MD5", pwd, name, 1024);
		userBean.setU_password(obj.toString());
		userService.register(userBean);
		return "redirect:/evaluation/pages/login.html";
	}
	
	
}
