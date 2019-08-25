package com.asiainfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.asiainfo.entity.QueryUserParam;
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
	
	int saveUser(User user);
	
	List<User> queryUserByName(String userName);
	
	User queryByCond(Map map);
	
	User queryByIdAndName(@Param("id") int id, @Param("name") String userName);
	
	User queryByCondObjParam(QueryUserParam queryUserParam);
	
	int updateById(User user);
	
	int deleteById(int id);
}
