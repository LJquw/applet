package www.xiyou.service;

import www.xiyou.entity.Order;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:10
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    ResponseData insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResponseData queryOpenidByOpenidAndOrderstate(String openid,String orderstate);


    List<Order> queryOrderByOrderstate(String orderstate);

}
