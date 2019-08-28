package com.asiainfo.entity;

/**
 * 学生实体类
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 8:51:24 PM
 */
public class Student {
	private int id;
	private String name;
	private byte gender;
	private StudentCard studentCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public StudentCard getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(StudentCard studentCard) {
		this.studentCard = studentCard;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", studentCard=" + studentCard + "]";
	}
}
