package com.ghs.todo.plan.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ghs.todo.plan.model.vo.Plan;

@Service("pService")
public interface PlanService {

	int insertPlan(Plan plan);

	ArrayList<Plan> planSelect(String pDate);


}
