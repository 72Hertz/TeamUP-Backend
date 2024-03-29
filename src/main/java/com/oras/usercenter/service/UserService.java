package com.oras.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oras.usercenter.common.BaseResponse;
import com.oras.usercenter.model.domain.User;
import com.oras.usercenter.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author endymion
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-01-05 15:39:22
*/
public interface UserService extends IService<User> {



    /**
     *用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String code);

    /**
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param requset
     * @return 返回脱敏后用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest requset);


    /**
     * 用户脱敏
     * @param user
     * @return
     */
    User getSafetyUser(User user);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据用户标签查询用户
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);




    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user, User loginUser);


    /**
     * 获取当前登录用户信息
     * @return
     */
    User getLoginUser(HttpServletRequest request);


    /**
     * 是否为管理员
     * @param request
     * @return true为管理员，false为普通用户
     */
    boolean isAdmin(HttpServletRequest request);
    boolean isAdmin(User loginUser);


    /**
     * 匹配用户
     * @param num
     * @param user
     * @return
     */
    List<User> matchUser(long num, User user);
}
