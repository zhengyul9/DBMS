package com.dbms.web.controller.notice;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dbms.web.controller.entity.WeaponTrend;
import com.dbms.web.controller.service.WeaponService;

public class WeaponController implements Controller {
private WeaponService weaponService;
	

	public void setWeaponService(WeaponService weaponService) {
		this.weaponService = weaponService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//which jsp file you want to send this data
		ModelAndView mv = new ModelAndView("weapontrend");
		
		List<WeaponTrend> wplist = weaponService.getList();
		List<WeaponTrend> wplist2 = weaponService.getList2();
		mv.addObject("wplist", wplist);
		mv.addObject("wplist2", wplist2);
		return mv;
	}

}
