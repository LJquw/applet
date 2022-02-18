package www.xiyou.service.impl;

import www.xiyou.entity.Order;
import www.xiyou.dao.OrderDao;
import www.xiyou.service.OrderService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:11
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseData insert(Order order) {
        try{
            //1.设置状态为0
            order.setOrderstate("0");
            //2.设置当前时间   placedate
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            order.setPlacedate(sdf.format(new Date()));

            this.orderDao.insert(order);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }


    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryOpenidByOpenidAndOrderstate(String openid, String orderstate) {

        try{
            Order order = new Order();
            order.setOpenid(openid);
            order.setOrderstate(orderstate);

            List<Order> orders = orderDao.queryAll(order);

            return new ResponseData(orders,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public List<Order> queryOrderByOrderstate(String orderstate) {
        return orderDao.queryOrderByOrderstate(orderstate);
    }
}
