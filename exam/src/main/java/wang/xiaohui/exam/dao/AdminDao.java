package wang.xiaohui.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import wang.xiaohui.exam.pojo.Admin;

public interface AdminDao extends JpaRepository<Admin,Integer>, JpaSpecificationExecutor<Admin> {
}
