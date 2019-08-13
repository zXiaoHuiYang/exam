package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaohui.exam.pojo.Admin;
import wang.xiaohui.exam.service.AdminService;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminServiceImpl;

    @RequestMapping("selAdminByEmailPwd")
    public int selAdminByEmailPwd(String email, String password, HttpSession session){
        Admin admin = adminServiceImpl.selAdminByEmailPwd(email, password);
        if (admin == null){
            return 0;   //登录失败
        }else {
            session.setAttribute("admin",admin);
            return 1;    //登录成功
        }
    }

    @RequestMapping("adminInfo")
    public Object adminInfo(HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin == null){
            return "0";  //无user信息，需重新登录
        }else {
            return admin;  //有user的信息
        }
    }

    @RequestMapping("quit")
    public int quit(HttpSession session){
        session.invalidate();
        return 1;
    }

    @RequestMapping("editPwd")
    public int editPwd(String password,HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin != null){
            admin.setPassword(password);
            return adminServiceImpl.updAdminInfo(admin);
        }
        return 0;
    }
}
