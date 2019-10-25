package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;

/**
 * @author 喜闻乐见i
 */
public interface UserService extends IService<User> {
    ResultVo login(UserDto user);
}
