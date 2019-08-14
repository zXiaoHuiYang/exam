package wang.xiaohui.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import wang.xiaohui.exam.dao.PaperDao;
import wang.xiaohui.exam.dao.SpaperDao;
import wang.xiaohui.exam.pojo.Paper;
import wang.xiaohui.exam.pojo.Spaper;
import wang.xiaohui.exam.service.SpaperService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SpaperServiceImpl implements SpaperService {
    @Autowired
    private SpaperDao spaperDao;
    @Autowired
    private PaperDao paperDao;
    @Override
    public Map<String,Object> selAllSpaper(int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Spaper> papers = this.spaperDao.findAll(pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",papers.getTotalElements());
        map.put("data",papers.getContent());
        return map;
    }

    @Override
    public void delSpaper(int id) {
        spaperDao.deleteById(id);
    }

    @Override
    public int saveSpaper(Spaper spaper) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        spaper.setTime(sdf.format(new Date()));
        Spaper sp = spaperDao.save(spaper);
        if (sp == null){
            return 0;  //更新失败
        }else {
            return sp.getId();   //更新成功
        }
    }

    @Override
    public Paper selSpaperByPid(int pid) {
        System.out.println(pid);
        Optional<Paper> paper = paperDao.findById(pid);
        return paper.get();
    }

    @Override
    public Map<String, Object> selSpaperByUserid(int page, int size, int userid) {
        //排序等定义
        Sort sort = new Sort(Sort.Direction.DESC,"time");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Predicate pre = cb.equal(root.get("userid"),userid);
                return pre;
            }
        };
        Page p = spaperDao.findAll(spec, pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",p.getTotalElements());
        map.put("data",p.getContent());
        return map;
    }
}
