package com.ghs.todo.plan.model.dao;

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
}
