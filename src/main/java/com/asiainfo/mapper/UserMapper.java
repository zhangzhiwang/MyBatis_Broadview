package com.asiainfo.mapper;

import org.apache.ibatis.annotations.Select;

import com.asiainfo.entity.User;

/**
 * 用户Mapper
 *
 * @author zhangzhiwang
 * @date Aug 24, 2019 4:11:24 PM
 */
public interface UserMapper {
//	@Select("select user_id userId,user_name userName from t_user where user_id=#{id}")
	User queryUserById(int id);
	
	void saveUser(User user);
}
