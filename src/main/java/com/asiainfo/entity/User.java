package com.asiainfo.entity;

/**
 * 用户实体类
 *
 * @author zhangzhiwang
 * @date Aug 22, 2019 10:25:31 AM
 */
public class User {
	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}

}
