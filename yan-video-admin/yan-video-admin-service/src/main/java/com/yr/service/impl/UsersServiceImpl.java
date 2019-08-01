package com.yr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yr.mapper.UsersMapper;
import com.yr.pojo.Users;
import com.yr.pojo.UsersExample;
import com.yr.service.UsersService;
import com.yr.utils.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/16 10:24
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public PagedResult userList(Users user, Integer page, Integer pageSize) {
        String username = "";
        String nickname = "";

        if(user != null){
            username = user.getUsername();
            nickname = user.getNickname();
        }

        PageHelper.startPage(page,pageSize);

        UsersExample userExample = new UsersExample();
        UsersExample.Criteria userCriteria = userExample.createCriteria();
        if (StringUtils.isNotBlank(username)) {
            userCriteria.andUsernameLike("%" + username + "%");
        }
        if (StringUtils.isNotBlank(nickname)) {
            userCriteria.andNicknameLike("%" + nickname + "%");
        }

        List<Users> userList = usersMapper.selectByExample(userExample);

        PageInfo<Users> pageList = new PageInfo<Users>(userList);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(userList);
        grid.setPage(page);
        grid.setRecords(pageList.getTotal());

        return grid;
    }
}
