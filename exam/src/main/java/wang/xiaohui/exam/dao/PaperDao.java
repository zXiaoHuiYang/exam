package wang.xiaohui.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import wang.xiaohui.exam.pojo.Paper;

public interface PaperDao extends JpaRepository<Paper,Integer>, CrudRepository<Paper,Integer>,
        JpaSpecificationExecutor<Paper> {
}
