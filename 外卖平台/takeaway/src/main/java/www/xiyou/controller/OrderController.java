package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.Order;
import www.xiyou.service.FoodService;
import www.xiyou.service.OrderService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.service.UserService;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;
import www.xiyou.utils.StringUtils;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:11
 */
@Api(tags = "点餐接口")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private FoodService foodService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }

    @ApiOperation(value = "新增订单", notes = "订单界面 添加订单   添加到openid对应的微信用户的订单中")
    @PostMapping("addOrder")
    //public ResponseData addOrder(Order order,String token,String foodname, Long foodid){
    public ResponseData addOrder(Order order,String token){
        System.out.println("order = "+order);
        System.out.println("token = "+token);
        //1.根据token获取到openid
        String openid = userService.queryOpenidByToken(token);
        String fname = order.getFoodname();
        Long fid = order.getFoodid();
        //String fname = foodService.queryNameByToken(foodname);
        //Long fid = foodService.queryIdByToken(foodid);

        if(StringUtils.isNull(openid)){
            return new ResponseData(ResponseCode.FAIL);
        }

        System.out.println("获取到的openid = "+openid);
        order.setOpenid(openid);
        order.setFoodname(fname);
        order.setFoodid(fid);
        //2.调用保存
        return orderService.insert(order);
    }

    @ApiOperation(value = "根据id和状态获取订单", notes = "我的界面  id为微信用户的唯一标识openid")
    @GetMapping("queryOrderByType")
    public ResponseData queryOrderByType(String token,String orderstate){
        System.out.println("根据状态获取订单 token = "+token);
        System.out.println("根据状态获取订单 orderstate = "+orderstate);
        //1.根据token获取到openid
        String openid = userService.queryOpenidByToken(token);

        return orderService.queryOpenidByOpenidAndOrderstate(openid,orderstate );
    }

}
