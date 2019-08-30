package com.asiainfo.entity;

/**
 * 女性体检表实体类
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 8:43:39 PM
 */
public class FemaleHealth {
	private int id;
	private int stuId;
	private String femaleHealth;

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

	public String getFemaleHealth() {
		return femaleHealth;
	}

	public void setFemaleHealth(String femaleHealth) {
		this.femaleHealth = femaleHealth;
	}

	@Override
	public String toString() {
		return "FemaleHealth [id=" + id + ", stuId=" + stuId + ", femaleHealth=" + femaleHealth + "]";
	}

}
