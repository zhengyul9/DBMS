package com.dbms.web.controller.notice;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.dbms.web.controller.entity.SuccessRate;
import com.dbms.web.controller.service.SuccessRateService;

public class SuccessRateController implements Controller {
	
	// I changed the first letter to the lowercase
	private SuccessRateService successRateService;
	

	public void setSuccessRateService(SuccessRateService successRateService) {
		this.successRateService = successRateService;
	}




	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//which jsp file you want to send this data
		ModelAndView mv = new ModelAndView("successrate");
		
		List<SuccessRate> SuccessRate = successRateService.getList();
		
		// "~~" this name will be used in JSP filt to get the list
		mv.addObject("SuccessRateList", SuccessRate);
		return mv;
	}
}
