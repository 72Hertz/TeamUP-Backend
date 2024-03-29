package com.oras.usercenter.service;

import com.oras.usercenter.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户服务测试
 * @author oras
 */
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testuser2");
        user.setUserAccount("123");
        user.setAvatarUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdID5oiBcQb6vyPCTi53zY49h7mUva2NV4Tk8fVVdC-0UYH-TtkuhX&usqp=CAE&s");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }

    @Test
    void userRegister() {
        String userAccount = "oras";
        String userPassword = "";
        String checkPassword = "123456";
        String code = "20202005010";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);
        userAccount = "or";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);
        userAccount = "oras";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);
        userAccount = "or as";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);


        checkPassword = "11111111";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);

        userAccount = "123";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);
        userAccount = "oras";
        result = userService.userRegister(userAccount, userPassword, checkPassword, code);
        Assertions.assertEquals(-1,result);



    }

    @Test
    void userLogin() {
    }

    @Test
    void getSafetyUser() {
    }

    @Test
    void userLogout() {
    }

    @Test
    void searchUsersByTags() {
        List<String> tagNameList = Arrays.asList("Java","Python");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        Assert.assertNotNull(userList);
    }
}