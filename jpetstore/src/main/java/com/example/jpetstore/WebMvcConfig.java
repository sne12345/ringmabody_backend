package com.example.jpetstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier(value = "signonInterceptor")
	private HandlerInterceptor interceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/shop/index.do").setViewName("index");
		registry.addViewController("/user/loginForm.do").setViewName("thyme/login");
		registry.addViewController("/user/joinUserAgreeForm.do").setViewName("thyme/join_user_agree");
		registry.addViewController("/user/joinForm.do").setViewName("thyme/join_user_form");
		registry.addViewController("/teacher/loginForm.do").setViewName("thyme/login_teacher");
		registry.addViewController("/teacher/joinUserAgreeForm.do").setViewName("thyme/join_teacher_agree");
		registry.addViewController("/teacher/joinForm.do").setViewName("thyme/join_teacher_form");
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/shop/editAccount.do", "/shop/listOrders.do",
					"/shop/viewOrder.do", "/shop/newOrder.do");		
	}
}
