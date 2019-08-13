package wang.xiaohui.exam.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.xiaohui.exam.pojo.Squestion;
import wang.xiaohui.exam.pojo.User;
import wang.xiaohui.exam.service.SquestionService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
public class SquestionController {
    @Autowired
    private SquestionService squestionServiceImpl;

    @RequestMapping("selSquestion")
    public List<Squestion> selSquestion(int spid){
        return squestionServiceImpl.selSquestionBySpid(spid);
    }

    @RequestMapping(value="insSquestion")
    public int insSquestion(String questions){
        Gson gson = new Gson();
        List<Squestion> qs = gson.fromJson(questions, new TypeToken<List<Squestion>>() {}.getType());
        return squestionServiceImpl.insSquestions(qs);
    }

    @RequestMapping("selSquestionPage")
    public Map<String, Object> selSquestionPage(int page, int limit, int pid){
        return squestionServiceImpl.selSquestionPage(page,limit,pid);
    }

}
