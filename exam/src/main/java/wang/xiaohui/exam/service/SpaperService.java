package wang.xiaohui.exam.service;

import wang.xiaohui.exam.pojo.Paper;
import wang.xiaohui.exam.pojo.Spaper;

import java.util.List;
import java.util.Map;

public interface SpaperService {
    /**
     * 查询所有历史试卷
     * @param page
     * @param size
     * @return
     */
    Map<String,Object> selAllSpaper(int page, int size);

    /**
     * 根据id删除历史试卷
     * @param id
     * @return
     */
    void delSpaper(int id);

    /**
     * 新增历史试卷信息
     * @param spaper
     * @return
     */
    int saveSpaper(Spaper spaper);

    /**
     * 通过pid查找历史试卷信息
     * @param pid
     * @return
     */
    Paper selSpaperByPid(int pid);

    /**
     * 根据用户信息查找历史试卷
     * @return
     */
    Map<String,Object> selSpaperByUserid(int page, int size,int userid);

}
