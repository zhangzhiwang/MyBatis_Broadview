package com.asiainfo.mapper;

import java.util.List;

import com.asiainfo.entity.FemaleHealth;

public interface FemaleHealthMapper {
	List<FemaleHealth> queryByStuId(int stuId);
}
