package www.xiyou.service;

import www.xiyou.entity.Recommend;

import java.util.List;

/**
 * (Recommend)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:12
 */
public interface RecommendService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recommend queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Recommend> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    Recommend insert(Recommend recommend);

    /**
     * 修改数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    Recommend update(Recommend recommend);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
