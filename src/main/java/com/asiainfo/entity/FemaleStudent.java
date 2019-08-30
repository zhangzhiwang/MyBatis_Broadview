package com.asiainfo.entity;

import java.util.List;

/**
 * 女学生实体类
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 10:53:51 PM
 */
public class FemaleStudent extends Student {
	private List<FemaleHealth> femaleHealthList;

	public List<FemaleHealth> getFemaleHealthList() {
		return femaleHealthList;
	}

	public void setFemaleHealthList(List<FemaleHealth> femaleHealthList) {
		this.femaleHealthList = femaleHealthList;
	}

	@Override
	public String toString() {
		return "FemaleStudent [femaleHealthList=" + femaleHealthList + "]" + super.toString();
	}

}
