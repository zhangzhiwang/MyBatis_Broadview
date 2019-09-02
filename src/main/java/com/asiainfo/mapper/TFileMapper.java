package com.asiainfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.asiainfo.entity.TFile;

public interface TFileMapper {
	int save(TFile tFile);
	
	TFile queryById(int id);
	
	TFile queryByYear(@Param("year") String year, @Param("id") int id);
	
	List<TFile> queryByYearWithPage(@Param("year") String year, RowBounds rowBounds);
}
