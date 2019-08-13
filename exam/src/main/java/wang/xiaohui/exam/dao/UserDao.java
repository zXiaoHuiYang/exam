package wang.xiaohui.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import wang.xiaohui.exam.pojo.User;

public interface UserDao extends JpaRepository<User,Integer>,
        CrudRepository<User,Integer>,
        JpaSpecificationExecutor<User> {
}
