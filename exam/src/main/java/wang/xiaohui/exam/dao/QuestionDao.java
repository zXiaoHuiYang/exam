package wang.xiaohui.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import wang.xiaohui.exam.pojo.Question;

public interface QuestionDao extends JpaRepository<Question,Integer>, JpaSpecificationExecutor<Question>,
        CrudRepository<Question,Integer>{
}
