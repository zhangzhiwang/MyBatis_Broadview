package com.asiainfo.service;

import com.asiainfo.entity.User;

/**
 * 用户服务接口
 *
 * @author zhangzhiwang
 * @date Aug 27, 2019 7:44:09 PM
 */
public interface IUserService {
	User queryUserById(int id);
}
