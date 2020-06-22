package com.ghs.todo.plan.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghs.todo.plan.model.dao.PlanDao;
import com.ghs.todo.plan.model.vo.Plan;

@Service("pService")
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanDao pDao;

	@Override
	public int insertPlan(Plan plan) {
		return pDao.insertPlan(plan);
	}

	@Override
	public ArrayList<Plan> planSelect(String pDate) {
		return pDao.planSelect(pDate);
	}
}
