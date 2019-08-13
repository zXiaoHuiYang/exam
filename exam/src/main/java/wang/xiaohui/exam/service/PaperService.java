package wang.xiaohui.exam.service;

import wang.xiaohui.exam.pojo.Paper;

import java.util.Map;

public interface PaperService {
    /**
     * 查询所有试卷
     * @param page
     * @param size
     * @return
     */
    Map<String,Object> selAllPaper(int page, int size);

    /**
     * 根据id删除试卷
     * @param id
     * @return
     */
    void delPaper(int id);

    /**
     * 新增更改试卷信息
     * @param paper
     * @return
     */
    int savePaper(Paper paper);

}
