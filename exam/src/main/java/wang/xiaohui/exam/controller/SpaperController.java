package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaohui.exam.pojo.Paper;
import wang.xiaohui.exam.pojo.Spaper;
import wang.xiaohui.exam.pojo.User;
import wang.xiaohui.exam.service.SpaperService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class SpaperController {
    @Autowired
    private SpaperService spaperServiceImpl;

    @RequestMapping("selSpaper")
    public Map<String,Object> selAllSpaper(int page, int limit){
        return spaperServiceImpl.selAllSpaper(page, limit);
    }

    @RequestMapping("selSpaperByUserid")
    public Map<String,Object> selSpaperByUserid(int page, int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        return spaperServiceImpl.selSpaperByUserid(page, limit,user.getId());
    }

    @RequestMapping("delSpaper")
    public int delSpaper(int id){
        spaperServiceImpl.delSpaper(id);
        return 1;
    }

    @RequestMapping("insSpaper")
    public int saveSpaper(Spaper spaper, int pid, HttpSession session){
        Paper paper = spaperServiceImpl.selSpaperByPid(pid);
        User user = (User)session.getAttribute("user");
        spaper.setPapername(paper.getPname());
        spaper.setUserid(user.getId());
        spaper.setUsername(user.getName());
        return spaperServiceImpl.saveSpaper(spaper);
    }

}
