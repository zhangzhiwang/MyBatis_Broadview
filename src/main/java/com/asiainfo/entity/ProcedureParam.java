package com.asiainfo.entity;

import java.sql.Timestamp;

/**
 * 存储过程参数
 *
 * @author zhangzhiwang
 * @date Sep 1, 2019 7:04:58 PM
 */
public class ProcedureParam {
	private String pName;
	private int result;
	private Timestamp now;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Timestamp getNow() {
		return now;
	}

	public void setNow(Timestamp now) {
		this.now = now;
	}

	@Override
	public String toString() {
		return "ProcedureParam [pName=" + pName + ", result=" + result + ", now=" + now + "]";
	}

}
