package com.ghs.todo.plan.model.vo;

import java.sql.Date;

public class Plan {

	private int pNo;
	private String pName;
	private String pDetail;
	private char pLevel;
	private Date pStartDate;
	private Date pEndDate;
	private char pStatus;
	
	public Plan() {};
	
	public Plan(int pNo, String pName, String pDetail, char pLevel, Date pStartDate, Date pEndDate, char pStatus) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pDetail = pDetail;
		this.pLevel = pLevel;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pStatus = pStatus;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public char getpLevel() {
		return pLevel;
	}

	public void setpLevel(char pLevel) {
		this.pLevel = pLevel;
	}

	public Date getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}

	public Date getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}

	public char getpStatus() {
		return pStatus;
	}

	public void setpStatus(char pStatus) {
		this.pStatus = pStatus;
	}

	@Override
	public String toString() {
		return "Plan [pNo=" + pNo + ", pName=" + pName + ", pDetail=" + pDetail + ", pLevel=" + pLevel + ", pStartDate="
				+ pStartDate + ", pEndDate=" + pEndDate + ", pStatus=" + pStatus + "]";
	}
	
}
