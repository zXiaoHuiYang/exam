package wang.xiaohui.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaohui.exam.pojo.Paper;
import wang.xiaohui.exam.service.PaperService;

import java.util.Map;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperServiceImpl;

    @RequestMapping("selPaper")
    public Map<String,Object> selAllPaper(int page, int limit){
        return paperServiceImpl.selAllPaper(page, limit);
    }

    @RequestMapping("delPaper")
    public int delPaper(int id){
        paperServiceImpl.delPaper(id);
        return 1;
    }

    @RequestMapping("savePaper")
    public int savePaper(Paper paper){
        return paperServiceImpl.savePaper(paper);
    }

}
