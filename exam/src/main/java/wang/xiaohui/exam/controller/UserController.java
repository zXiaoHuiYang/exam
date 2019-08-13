package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaohui.exam.pojo.User;
import wang.xiaohui.exam.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("selUser")
    public Map<String,Object> selAllUser(int page,int limit){
        return userServiceImpl.selAllUser(page,limit);
    }

    @RequestMapping("delUser")
    public int delUser(int id){
        return userServiceImpl.delUserById(id);
    }

    @RequestMapping("login")
    public int login(String email,String password,HttpSession session){
        User user = userServiceImpl.selUserByEmailPwd(email, password);
        if (user == null){
            return 0;   //登录失败
        }else {
            session.setAttribute("user",user);
            return 1;    //登录成功
        }
    }

    @RequestMapping("register")
    public int register(User user){
        User u = userServiceImpl.selUserByEmail(user.getEmail());
        if (u != null){
            return 2; // 表示已注册
        }else {
            int i = userServiceImpl.insUser(user);
            if (i > 0){
                return 1;   //注册成功
            }else {
                return 0;   //注册失败
            }
        }
    }

    @RequestMapping("info")
    public Object userInfo(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "0";  //无user信息，需重新登录
        }else {
            return user;  //有user的信息
        }
    }
}
