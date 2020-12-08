package com.dbms.web.controller.notice;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.dbms.web.controller.entity.Table;

import com.dbms.web.controller.service.Tuples;

public class TupleController implements Controller {
private Tuples tuples;

public void setTuples(Tuples tuples) {
	this.tuples = tuples;
}




public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("tuples");
		// set view page to forward the data and shows the result 
		List<Table> listOfLists = tuples.getList();
		

//		List<TestEntity> list = listOfLists.get(1);
//		List<TestEntity> list2 = listOfLists.get(2);
		// send the model to view page
		mv.addObject("table", listOfLists);
	
//		mv.addObject("list2", list2);
	
		return mv;
	}

}
