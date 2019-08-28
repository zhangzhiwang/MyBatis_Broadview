package com.asiainfo.mapper;

import com.asiainfo.entity.Student;
import com.asiainfo.entity.StudentCard;

/**
 * 学生证Mapper
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 9:25:56 PM
 */
public interface StudentMapper {
	/**
	 * 通过id查询学生
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Aug 28, 2019 1:20:26 PM
	 */
	Student queryByStuId(int id);
}
