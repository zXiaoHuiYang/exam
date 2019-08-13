package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.xiaohui.exam.pojo.Question;
import wang.xiaohui.exam.pojo.Squestion;
import wang.xiaohui.exam.service.QuestionService;
import wang.xiaohui.exam.service.SquestionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionServiceImpl;
    @Autowired
    private SquestionService squestionServiceImpl;

    @RequestMapping("index")
    public String index(){
        return "index.html";
    }
    @RequestMapping("exam")
    public String exam(Integer pid, HttpServletRequest req){
        List<Question> questions = questionServiceImpl.selQuestionByPid(pid);
        req.setAttribute("questions",questions);
        req.setAttribute("qcount",questions.size());
//        System.out.println(questions.toString());
        return "exam.html";
    }

    @RequestMapping("historyExam")
    public String historyExam(Integer pid, HttpServletRequest req){
        List<Squestion> squestions = squestionServiceImpl.selSquestionBySpid(pid);
        req.setAttribute("squestions",squestions);
        req.setAttribute("sqcount",squestions.size());
        return "historyExam.html";
    }
}
