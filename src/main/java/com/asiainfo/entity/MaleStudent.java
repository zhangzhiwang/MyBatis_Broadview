package com.asiainfo.entity;

import java.util.List;

/**
 * 男学生实体类
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 8:42:23 PM
 */
public class MaleStudent extends Student {
	private List<MaleHealth> maleHealthList;

	public List<MaleHealth> getMaleHealthList() {
		return maleHealthList;
	}

	public void setMaleHealthList(List<MaleHealth> maleHealthList) {
		this.maleHealthList = maleHealthList;
	}

	@Override
	public String toString() {
		return "MaleStudent [maleHealthList=" + maleHealthList + "]" + super.toString();
	}

}
