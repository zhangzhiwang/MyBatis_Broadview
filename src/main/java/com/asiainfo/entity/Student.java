package com.asiainfo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 学生实体类
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 8:51:24 PM
 */
public class Student implements Serializable {
	/***/
	private static final long serialVersionUID = 6368996397280062044L;
	private int id;
	private String name;
	private byte gender;
	private StudentCard studentCard;
	private List<StuCourse> stuCourseList;

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

	public List<StuCourse> getStuCourseList() {
		return stuCourseList;
	}

	public void setStuCourseList(List<StuCourse> stuCourseList) {
		this.stuCourseList = stuCourseList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", studentCard=" + studentCard + ", stuCourseList=" + stuCourseList + "]";
	}
}
