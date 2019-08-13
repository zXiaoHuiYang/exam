package wang.xiaohui.exam.service;

import wang.xiaohui.exam.pojo.User;

import java.util.Map;

public interface UserService {
    /**
     * 查询所有的用户
     * @return
     */
    Map<String,Object> selAllUser(int page,int size);

    /**
     * 通过ID删除用户信息
     * @return
     */
    int delUserById(int id);

    /**
     * 登录
     * @return
     */
    User selUserByEmailPwd(String email,String password);

    /**
     * 注册排重
     * @return
     */
    User selUserByEmail(String email);

    /**
     * 注册
     * @return
     */
    int insUser(User user);

}
