package com.ghs.todo.plan.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ghs.todo.plan.model.vo.Plan;

@Repository("pDao")
public class PlanDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertPlan(Plan plan) {
		return sqlSession.insert("planMapper.insertPlan", plan);
	}

	public ArrayList<Plan> planSelect(String pDate) {
		return (ArrayList)sqlSession.selectList("planMapper.selectPlan", pDate);
	}
}
