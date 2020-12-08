package com.dbms.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dbms.web.controller.entity.TestEntity;
import com.dbms.web.controller.service.ListService;


public class ListController implements Controller{

	private ListService listService;
	
	public void setListService(ListService listService) {
		this.listService = listService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("list");
		// set view page to forward the data and shows the result 
		List<TestEntity> listOfLists = listService.getList();
		List<TestEntity> listOfRankLists = listService.getRankList();
		List<TestEntity> listOfTopLists = listService.getTopList();

//		List<TestEntity> list = listOfLists.get(1);
//		List<TestEntity> list2 = listOfLists.get(2);
		// send the model to view page
		mv.addObject("list", listOfLists);
		mv.addObject("list2", listOfRankLists);
		mv.addObject("list3", listOfTopLists);
//		mv.addObject("list2", list2);
	
		return mv;
	}

}
