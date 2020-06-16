package com.ghs.todo.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ghs.todo.plan.model.exception.PlanException;
import com.ghs.todo.plan.model.service.PlanService;
import com.ghs.todo.plan.model.vo.Plan;

@Controller
public class PlanController {
	@Autowired
	private PlanService pService;

	@RequestMapping("pInsert.do")
	public ModelAndView planInsert(ModelAndView mv, Plan plan) {
		
		int result = pService.insertPlan(plan);
		if(result < 1) {
			throw new PlanException("일정등록에 실패하였습니다.");
		}else {
			return null; 
		}
	}
}
