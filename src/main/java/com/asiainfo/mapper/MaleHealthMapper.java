package com.asiainfo.mapper;

import java.util.List;

import com.asiainfo.entity.MaleHealth;

public interface MaleHealthMapper {
	List<MaleHealth> queryByStuId(int stuId);
}
