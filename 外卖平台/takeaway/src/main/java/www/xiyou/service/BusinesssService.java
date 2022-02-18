package www.xiyou.service;

import www.xiyou.entity.Businesss;
import www.xiyou.query.LimitQuery;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (Businesss)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:25:09
 */
public interface BusinesssService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Businesss queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Businesss> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param businesss 实例对象
     * @return 实例对象
     */
    Businesss insert(Businesss businesss);

    /**
     * 修改数据
     *
     * @param businesss 实例对象
     * @return 实例对象
     */
    Businesss update(Businesss businesss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResponseData queryBusInfoById(Long id);

    ResponseData queryBusInfo(LimitQuery limitQuery);

    ResponseData queryInfoById(Long id);
}
