package com.yr.service;

import com.yr.pojo.Users;
import com.yr.utils.PagedResult;

/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/16 10:24
 */
public interface UsersService {

    /**
     * 分页展示用户数据
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    PagedResult userList(Users user , Integer page , Integer pageSize);
}
