package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaohui.exam.pojo.Question;
import wang.xiaohui.exam.service.QuestionService;

import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("selQuestion")
    public Map<String,Object> selQuestionByPid(Integer pid, Integer page, Integer limit){
        return questionService.selQuestionByPid(pid, page, limit);
    }

    @RequestMapping("saveQuestion")
    public int saveQuestion(Question question){
        return questionService.saveQuestion(question);
    }

    @RequestMapping("delQuestion")
    public int delQuestion(int id){
        return questionService.delQuestion(id);
    }
}
