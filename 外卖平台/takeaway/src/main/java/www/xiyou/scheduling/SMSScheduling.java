package www.xiyou.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import www.xiyou.entity.Order;
import www.xiyou.service.OrderService;
import www.xiyou.utils.SMSUtil;
import www.xiyou.utils.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 短信发送
 */
@Component
public class SMSScheduling {

    @Resource
    OrderService orderService;

//    @Scheduled(cron = "*/10 * * * * ?")
//    public void proces(){
//       System.out.println("开始执行短信发送任务...");
//        //1.获取订单状态为0   集合
//        List<Order> orders = orderService.queryOrderByOrderstate("0");
//
//        //2.循环获取到订单的手机号   发送短信
//        for(int i = 0;i<orders.size();i++){
//            Order order = orders.get(i);
//            System.out.println(order.getUsertell());
//            String tell = order.getUsertell();
//            if(!StringUtils.isNull(tell)){
//                System.out.println("短信发送,tell = "+tell);
//                String code = SMSUtil.sendSMS(tell);
//                if("2".equals(code)){
//                    //3.如果成功   修改订单状态改订单状态为为1
//                    System.out.println("修1");
//                    order.setOrderstate("1");
//                    orderService.update(order);
//                }
//
//            }
//        }
//    }
}
