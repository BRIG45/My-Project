package com.mindtree.brindaban.college.valueandobject;

public class Student {
	private long id;
	private String name;
	private String gender;
	private int age;
	private long col_id;
	private String stream;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getCol_id() {
		return col_id;
	}

	public void setCol_id(long col_id) {
		this.col_id = col_id;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Student(long id, String name, String gender, int age, long col_id, String stream) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.col_id = col_id;
		this.stream = stream;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", col_id=" + col_id
				+ ", stream=" + stream + "]";
	}
}