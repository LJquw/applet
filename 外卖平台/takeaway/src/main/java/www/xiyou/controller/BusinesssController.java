package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.Businesss;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.BusinesssService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Businesss)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:25:20
 */
@Api(tags = "商家接口")
@RestController
@RequestMapping("businesss")
public class BusinesssController {
    /**
     * 服务对象
     */
    @Resource
    private BusinesssService businesssService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "selectOne",notes="获取商家信息")
    @GetMapping("selectOne")
    public Businesss selectOne(Long id) {
        return this.businesssService.queryById(id);
    }

    @ApiOperation(value = "根据产品id获取订单页面数据" ,notes = "点餐界面")
    @GetMapping("queryBusInfoById")
    public ResponseData queryBusInfoById(Long id){
        System.out.println("根据产品id获取订单页面数据 id = "+id);
        return businesssService.queryBusInfoById(id);
    }

    @ApiOperation(value = "分页获取商家", notes = "商家界面")
    @GetMapping("queryBusInfo")
    public ResponseData queryBusInfo(LimitQuery limitQuery){
        System.out.println("分页获取商家 limitQuery = "+limitQuery);
        return businesssService.queryBusInfo(limitQuery);
    }

    @ApiOperation(value = "点击指定行获取商家界面信息" , notes = "商家界面")
    @GetMapping("queryInfoById")
    public ResponseData queryInfoById(Long id){
        System.out.println("id = "+id);
        return businesssService.queryInfoById(id);
    }

}
