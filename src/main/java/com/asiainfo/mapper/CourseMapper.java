package com.asiainfo.mapper;

import com.asiainfo.entity.Course;

/**
 * 课程Mapper
 *
 * @author zhangzhiwang
 * @date Aug 28, 2019 7:24:29 PM
 */
public interface CourseMapper {
	Course queryByCourseId(int id);
}
