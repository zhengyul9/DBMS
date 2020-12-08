package com.dbms.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.dbms.web.controller.entity.TerroristTrend;
import com.dbms.web.controller.service.TerroristTrendService;

public class TerroristTrendController implements Controller  {
	// I changed the first letter to the lowercase
		private TerroristTrendService terroristTrendService;
		
	    
		public void setTerroristTrendService(TerroristTrendService terroristTrendService) {
			this.terroristTrendService = terroristTrendService;
		}


		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			//which jsp file you want to send this data
			ModelAndView mv = new ModelAndView("terroristtrend");
			List<TerroristTrend> TerroristTrend = terroristTrendService.getList();
			List<TerroristTrend> TerroristTrend2 = terroristTrendService.getList2();
			mv.addObject("TerroristTrendList", TerroristTrend);
			mv.addObject("TerroristTrendList2", TerroristTrend2);
			return mv;
		}
}
