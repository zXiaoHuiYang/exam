package wang.xiaohui.exam.service;
import wang.xiaohui.exam.pojo.Squestion;

import java.util.List;
import java.util.Map;

public interface SquestionService {

    /**
     * 根据试卷ID查询试题
     * @return
     */
    List<Squestion> selSquestionBySpid(Integer spid);

    /**
     * 批量新增历史试题
     * @param squestions
     * @return
     */
    int insSquestions(List<Squestion> squestions);

    /**
     * 根据查询试题（分页）
     * @return
     */
    Map<String,Object> selSquestionPage(int page , int size,int pid);
}
