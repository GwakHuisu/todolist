package com.ghs.todo.plan.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public ModelAndView planInsert(ModelAndView mv, Plan plan) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sDay = sdf.parse(plan.getpStartDate().toString());
		Date eDay = sdf.parse(plan.getpEndDate().toString());

		System.out.println("sDay : " + sdf.format(sDay));
		System.out.println("eDay : " + sdf.format(eDay));
		
		
		
		int result = pService.insertPlan(plan);
		if(result < 1) {
			throw new PlanException("일정등록에 실패하였습니다.");
		}else {
			return null; 
		}
	}
}
