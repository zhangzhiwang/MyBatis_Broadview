package com.asiainfo.enums;

public enum LockEnum {
	LOCKED("100"), UNLOCKED("200"), UNKNOWN("300");

	private String code;

	private LockEnum(String code) {
		this.code = code;
	}

	private LockEnum() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static LockEnum getByCode(String code) {
		for (LockEnum lockEnum : LockEnum.values()) {
			if (lockEnum.getCode().equals(code)) {
				return lockEnum;
			}
		}

		return null;
	}

}
