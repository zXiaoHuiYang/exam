package wang.xiaohui.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import wang.xiaohui.exam.dao.SquestionDao;
import wang.xiaohui.exam.pojo.Squestion;
import wang.xiaohui.exam.service.SquestionService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SquestionServiceImpl implements SquestionService {
    @Autowired
    private SquestionDao squestionDao;
    @Override
    public List<Squestion> selSquestionBySpid(Integer spid) {
        Specification<Squestion> spec = new Specification<Squestion>() {
            @Override
            public Predicate toPredicate(Root<Squestion> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate pre = criteriaBuilder.equal(root.get("spid"), spid);
                return pre;
            }
        };
        return squestionDao.findAll(spec);
    }

    @Override
    public int insSquestions(List<Squestion> squestions) {
        squestionDao.saveAll(squestions);
        return 1;
    }

    @Override
    public Map<String,Object> selSquestionPage(int page, int size,int pid) {
        Pageable pageable = PageRequest.of(page-1,size);
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Predicate pre = cb.equal(root.get("spid"),pid);
                return pre;
            }
        };
        Page p = squestionDao.findAll(spec, pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",p.getTotalElements());
        map.put("data",p.getContent());
        return map;
    }
}
