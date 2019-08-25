package com.asiainfo.entity;

/**
 * 查询参数实体
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 2:54:36 PM
 */
public class QueryUserParam {
	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "QueryUserParam [id=" + id + ", name=" + name + "]";
	}

}
