package www.xiyou.service;

import www.xiyou.entity.Advertisement;
import www.xiyou.query.LimitQuery;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (Advertisement)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 10:55:00
 */
public interface AdvertisementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Advertisement queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Advertisement> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement insert(Advertisement advertisement);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResponseData queryAdInfo(LimitQuery limitQuery);

    ResponseData queryInfoById(Long id);

    ResponseData queryBusInfoById(Long id);

}
