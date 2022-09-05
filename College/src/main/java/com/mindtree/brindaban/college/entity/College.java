package com.mindtree.brindaban.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long col_id;
	private String col_name;
	private int TotalStudents;

	public long getCol_id() {
		return col_id;
	}

	public void setCol_id(long col_id) {
		this.col_id = col_id;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public int getTotalStudents() {
		return TotalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		TotalStudents = totalStudents;
	}

	public College(long col_id, String col_name, int totalStudents) {
		super();
		this.col_id = col_id;
		this.col_name = col_name;
		TotalStudents = totalStudents;
	}

	public College() {
		super();
	}

	@Override
	public String toString() {
		return "College [col_id=" + col_id + ", col_name=" + col_name + ", TotalStudents=" + TotalStudents + "]";
	}
}