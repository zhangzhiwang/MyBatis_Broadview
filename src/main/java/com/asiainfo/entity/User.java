package com.asiainfo.entity;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.asiainfo.enums.LockEnum;

/**
 * 用户实体类
 *
 * @author zhangzhiwang
 * @date Aug 22, 2019 10:25:31 AM
 */
//@Alias("user")
public class User {
	private int userId;
	private String userName;
	private String password;
	private String userType;
	private byte locked;
//	private LockEnum locked;
	private int credit;
	private Timestamp lastVisit;
	private String lastIp;
	private QueryUserParam qup;

	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public User() {
		super();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public byte getLocked() {
		return locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

//	public LockEnum getLocked() {
//		return locked;
//	}
//
//	public void setLocked(LockEnum locked) {
//		this.locked = locked;
//	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Timestamp getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Timestamp lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	
	
	public QueryUserParam getQup() {
		return qup;
	}

	public void setQup(QueryUserParam qup) {
		this.qup = qup;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType + ", locked=" + locked + ", credit=" + credit + ", lastVisit=" + lastVisit + ", lastIp=" + lastIp + ", qup=" + qup + "]";
	}
}
