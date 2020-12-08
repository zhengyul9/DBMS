package com.dbms.web.controller.notice;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.dbms.web.controller.entity.WeapondamageLocationTrend;
import com.dbms.web.controller.service.WeapondamageLocationTrendService;

public class WeapondamageLocationContoller implements Controller {
	
	// I changed the first letter to the lowercase
	private WeapondamageLocationTrendService weapondamageLocationTrendService;
	
  	public void setWeapondamageLocationTrendService(WeapondamageLocationTrendService weapondamageLocationTrendService) {
		this.weapondamageLocationTrendService = weapondamageLocationTrendService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//which jsp file you want to send this data
		ModelAndView mv = new ModelAndView("weapondamagelocationtrend");
		
		List<WeapondamageLocationTrend> WeapondamageLocationTrend = weapondamageLocationTrendService.getList();
		
		// "~~" this name will be used in JSP filt to get the list
		mv.addObject("anything", WeapondamageLocationTrend);
		return mv;
	}
}
