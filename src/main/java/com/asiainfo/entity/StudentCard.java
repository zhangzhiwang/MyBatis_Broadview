package com.asiainfo.entity;

/**
 * 学生证实体
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 8:54:46 PM
 */
public class StudentCard {
	private int id;
	private String number;
	private int stuId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "StudentCard [id=" + id + ", number=" + number + ", stuId=" + stuId + "]";
	}
}
