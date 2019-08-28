package com.asiainfo.mapper;

import com.asiainfo.entity.StudentCard;

/**
 * 学生证Mapper
 *
 * @author zhangzhiwang
 * @date Aug 26, 2019 9:25:56 PM
 */
public interface StudentCardMapper {
	/**
	 * 通过学生证好查询学生
	 * 
	 * @param stuNum
	 * @return
	 * @author zhangzhiwang
	 * @date Aug 26, 2019 9:26:57 PM
	 */
	StudentCard queryByStuNum(int stuNum);
}
