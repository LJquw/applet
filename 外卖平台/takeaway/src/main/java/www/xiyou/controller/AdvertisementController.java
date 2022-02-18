package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.Advertisement;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Advertisement)表控制层
 *
 * @author makejava
 * @since 2021-08-19 10:55:00
 */
@Api(tags = "广告接口")
@RestController
@RequestMapping("advertisement")
public class AdvertisementController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementService advertisementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Advertisement selectOne(Long id) {
        return this.advertisementService.queryById(id);
    }

    @ApiOperation(value = "分页获取广告消息", notes = "消息/广告界面")
    @GetMapping("queryAdInfo")
    public ResponseData queryAdInfo(LimitQuery limitQuery){
        System.out.println("分页获取广告消息 limitQuery = "+limitQuery);
        return advertisementService.queryAdInfo(limitQuery);
    }

    @ApiOperation(value = "点击指定行获取广告信息" , notes = "消息/广告界面->广告详情界面")
    @GetMapping("queryInfoById")
    public ResponseData queryInfoById(Long id){
        System.out.println("id = "+id);
        return advertisementService.queryInfoById(id);
    }

    @ApiOperation(value = "根据广告id获取订单页面数据" ,notes = "广告界面->点餐界面")
    @GetMapping("queryBusInfoById")
    public ResponseData queryBusInfoById(Long id){
        System.out.println("根据广告id获取订单页面数据 id = "+id);
        return advertisementService.queryBusInfoById(id);
    }

}
