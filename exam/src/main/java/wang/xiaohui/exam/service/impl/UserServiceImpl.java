package wang.xiaohui.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import wang.xiaohui.exam.dao.UserDao;
import wang.xiaohui.exam.pojo.User;
import wang.xiaohui.exam.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Map<String, Object> selAllUser(int page,int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<User> users = userDao.findAll(pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",users.getTotalElements());
        map.put("data",users.getContent());
        return map;
    }

    @Override
    public int delUserById(int id) {
        userDao.deleteById(id);
        return 1;
    }

    @Override
    public User selUserByEmailPwd(String email, String password) {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(root.get("email"),email),criteriaBuilder.equal(root.get("password"),password));
                return predicate;
            }
        };
        List<User> users = userDao.findAll(spec);
        if (users.size() == 0){
            return null;
        }else{
            return users.get(0);
        }
    }

    @Override
    public User selUserByEmail(String email) {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("email"),email);
                return predicate;
            }
        };
        List<User> users = userDao.findAll(spec);
        if (users.size() == 0){
            return null;
        }else{
            return users.get(0);
        }
    }

    @Override
    public int insUser(User user) {
        User u = userDao.save(user);
        if (u != null){
            return 1;
        }
        return 0;
    }
}
