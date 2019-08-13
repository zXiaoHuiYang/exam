package wang.xiaohui.exam.service;
import wang.xiaohui.exam.pojo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    /**
     * 根据试卷ID查询试题(分页)
     * @return
     */
    Map<String,Object> selQuestionByPid(Integer pid,Integer page, Integer size);

    /**
     * 更新新增试题
     * @param question
     * @return
     */
    int saveQuestion(Question question);

    /**
     * 删除试题
     * @param id
     * @return
     */
    int delQuestion(Integer id);

    /**
     * 根据试卷ID查询试题
     * @return
     */
    List<Question> selQuestionByPid(Integer pid);

}
