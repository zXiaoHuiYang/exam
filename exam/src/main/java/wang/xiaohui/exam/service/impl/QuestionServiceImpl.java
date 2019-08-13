package wang.xiaohui.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import wang.xiaohui.exam.dao.QuestionDao;
import wang.xiaohui.exam.pojo.Question;
import wang.xiaohui.exam.service.QuestionService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public Map<String, Object> selQuestionByPid(Integer pid, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Specification<Question> spec = new Specification<Question>() {
            @Override
            public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate pre = criteriaBuilder.equal(root.get("pid"), pid);
                return pre;
            }
        };
        Page<Question> questions = this.questionDao.findAll(spec, pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",questions.getTotalElements());
        map.put("data",questions.getContent());
        return map;
    }

    @Override
    public int saveQuestion(Question question) {
        Question q = questionDao.save(question);
        if (q == null){
            return 0;  //更新失败
        }else {
            return 1;   //更新成功
        }
    }

    @Override
    public int delQuestion(Integer id) {
        questionDao.deleteById(id);
        return 1;
    }

    @Override
    public List<Question> selQuestionByPid(Integer pid) {
        Specification<Question> spec = new Specification<Question>() {
            @Override
            public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate pre = criteriaBuilder.equal(root.get("pid"), pid);
                return pre;
            }
        };
        return questionDao.findAll(spec);
    }
}
