package com.asiainfo.entity;

/**
 * 学生证实体
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 8:54:46 PM
 */
public class StudentCard {
	private int id;
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "StudentCard [id=" + id + ", number=" + number + "]";
	}
}
