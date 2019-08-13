package wang.xiaohui.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import wang.xiaohui.exam.pojo.Spaper;

public interface SpaperDao extends JpaRepository<Spaper,Integer>, CrudRepository<Spaper,Integer>,
        JpaSpecificationExecutor<Spaper> {
}
