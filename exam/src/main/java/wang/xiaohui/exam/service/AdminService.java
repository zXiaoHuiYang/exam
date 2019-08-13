package wang.xiaohui.exam.service;

import wang.xiaohui.exam.pojo.Admin;

public interface AdminService {
    /**
     * 根据邮箱密码登录
     * @param email
     * @param password
     * @return
     */
    Admin selAdminByEmailPwd(String email,String password);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updAdminInfo(Admin admin);

}
