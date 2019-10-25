package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;

/**
 * @author 喜闻乐见i
 */
public interface UserService extends IService<User> {
    /**
     * 登录
     *
     * @param user
     * @return
     */
    ResultVo login(UserDto user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    ResultVo register(User user);

    /**
     * 校验手机号是否已经被注册
     *
     * @param phone
     * @return
     */
    ResultVo verifyPhone(String phone);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    ResultVo updateUserInfo(User user);

    ResultVo selectUser();
}
