package com.asiainfo.enums;

public enum LockEnum {
	LOCKED(10), UNLOCKED(20), UNKNOWN(30);

	private int code;


	private LockEnum(int code) {
		this.code = code;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public static LockEnum getByCode(int code) {
		for (LockEnum lockEnum : LockEnum.values()) {
			if (lockEnum.getCode() == code) {
				return lockEnum;
			}
		}

		return null;
	}

}
