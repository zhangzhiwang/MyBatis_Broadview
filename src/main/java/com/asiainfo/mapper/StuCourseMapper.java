package com.asiainfo.mapper;

import java.util.List;

import com.asiainfo.entity.StuCourse;

/**
 * 学生成绩Mapper
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 7:28:55 PM
 */
public interface StuCourseMapper {
	List<StuCourse> queryByStuId(int stuId);
}
