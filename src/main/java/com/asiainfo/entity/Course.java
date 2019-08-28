package com.asiainfo.entity;

/**
 * 课程实体类
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 7:04:16 PM
 */
public class Course {
	private int id;
	private String courseName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
}
