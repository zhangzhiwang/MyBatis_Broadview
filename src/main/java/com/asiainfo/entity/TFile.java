package com.asiainfo.entity;

import java.util.Arrays;

public class TFile {
	private int id;
	private byte[] fileBytes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	@Override
	public String toString() {
		return "TFile [id=" + id + ", fileBytes=" + Arrays.toString(fileBytes) + "]";
	}

}
