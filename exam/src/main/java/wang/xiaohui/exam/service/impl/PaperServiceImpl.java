package wang.xiaohui.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wang.xiaohui.exam.dao.PaperDao;
import wang.xiaohui.exam.pojo.Paper;
import wang.xiaohui.exam.service.PaperService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Override
    public Map<String,Object> selAllPaper(int page, int size) {
        //排序等定义
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page-1,size,sort);
        Page<Paper> papers = this.paperDao.findAll(pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",papers.getTotalElements());
        map.put("data",papers.getContent());
        return map;
    }

    @Override
    public void delPaper(int id) {
        paperDao.deleteById(id);
    }

    @Override
    public int savePaper(Paper paper) {
        Paper p = paperDao.save(paper);
        if (p == null){
            return 0;  //更新失败
        }else {
            return 1;   //更新成功
        }
    }
}
