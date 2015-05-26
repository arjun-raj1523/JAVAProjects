package com.valueobjects;

public class ComplainVO {
	public String complainText;
	public int complainNum;
	
	public int getComplainNum() {
		return complainNum;
	}
	public String getComplainText() {
		return complainText;
	}
	public void setComplainText(String complainText) {
		this.complainText = complainText;
	}
	
	
	
	public void setComplainNum(int complainNum) {
		this.complainNum = complainNum;
	}
	public ComplainVO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ComplainVO [complainText=" + complainText + ", complainNum="
				+ complainNum + "]";
	}
	

}
