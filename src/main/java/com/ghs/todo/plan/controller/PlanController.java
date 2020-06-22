package com.ghs.todo.plan.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ghs.todo.plan.model.exception.PlanException;
import com.ghs.todo.plan.model.service.PlanService;
import com.ghs.todo.plan.model.vo.Plan;

@Controller
public class PlanController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private PlanService pService;

	@RequestMapping("home.do")
	public ModelAndView home(ModelAndView mv) {
		Date date = new Date();
		String pDate = sdf.format(date);
		ArrayList<Plan> pList = pService.planSelect(pDate);
		if(pList != null) {
			mv.addObject("date", date);
			mv.addObject("pList", pList);
			mv.setViewName("home");
			return mv;			
		}else {
			throw new PlanException("일정 불러오기에 실패하였습니다.");
		}
	}
	
	
	@RequestMapping("pInsert.do")
	public ModelAndView planInsert(ModelAndView mv, Plan plan) throws ParseException {
		Date sDay = sdf.parse(plan.getpStartDate().toString());
		Date eDay = sdf.parse(plan.getpEndDate().toString());
		Date today = new Date();
		
		/* 
		 * 입력된 날짜 확인
		System.out.println("sDay : " + sdf.format(sDay));
		System.out.println("eDay : " + sdf.format(eDay));
		*/
		
		if(sDay.compareTo(today) < 0 && eDay.compareTo(today) > 0) {
			plan.setpStatus('Y');
		}else {
			plan.setpStatus('N');
		}
		
		int result = pService.insertPlan(plan);
		if(result > 0) {
			mv.setViewName("home");
			return mv;
		}else {
			throw new PlanException("일정등록에 실패하였습니다.");
		}
	}
}
