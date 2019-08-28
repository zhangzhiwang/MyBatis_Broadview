package com.asiainfo.entity;

/**
 * 男性体检表实体类
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 8:43:39 PM
 */
public class FemaleHealth {
	private int id;
	private int stuId;
	private String maleHealth;

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

	public String getMaleHealth() {
		return maleHealth;
	}

	public void setMaleHealth(String maleHealth) {
		this.maleHealth = maleHealth;
	}

	@Override
	public String toString() {
		return "MaleHealth [id=" + id + ", stuId=" + stuId + ", maleHealth=" + maleHealth + "]";
	}

}
