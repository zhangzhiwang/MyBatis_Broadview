package com.asiainfo.entity;

/**
 * 学生成绩实体
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 7:06:15 PM
 */
public class StuCourse {
	private int id;
	private int stuId;
	private Course course;
	private double score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StuCourse [id=" + id + ", stuId=" + stuId + ", Course=" + course + ", score=" + score + "]";
	}
}
