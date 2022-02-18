package www.xiyou.service;

import www.xiyou.entity.Food;
import www.xiyou.query.LimitQuery;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (Food)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:06
 */
public interface FoodService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Food queryById(Long id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    ResponseData queryAllByLimit(LimitQuery limitQuery);

    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    Food insert(Food food);

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    Food update(Food food);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResponseData queryProInfoById(Long id);

    //ResponseData queryBusInfoById(Long id);

    ResponseData queryProInfoByType(LimitQuery limitQuery,String type);

    ResponseData queryProInfoByKeyword(String keyword,String type);

}
