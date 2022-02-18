package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.Food;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.FoodService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Food)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:07
 */
@Api(tags = "食物接口")
@RestController
@RequestMapping("food")
public class FoodController {
    /**
     * 服务对象
     */
    @Resource
    private FoodService foodService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "selectOne",notes="获取食物信息 自动生成的代码")
    @GetMapping("selectOne")
    public Food selectOne(Long id) {
        return this.foodService.queryById(id);
    }

    @ApiOperation(value = "分页获取食物信息",notes = "首页")
    @GetMapping("queryProInfo")
    public ResponseData queryProInfo(LimitQuery limitQuery) {
        System.out.println("分页获取食物信息 limitQuery=" + limitQuery);

        return foodService.queryAllByLimit(limitQuery);
    }

    @ApiOperation(value = "点击产品获取产品信息",notes = "进入产品详情界面")
    @GetMapping("queryProInfoById")
    public ResponseData queryProInfoById(Long id){
        System.out.println("queryProInfoById = "+id);
        return foodService.queryProInfoById(id);
    }

    @ApiOperation(value = "获取食物分类信息",notes = "分类/搜索/模糊查询界面")
    @GetMapping("queryProInfoByType")
    public ResponseData queryProInfoByType(LimitQuery limitQuery, String type){
        System.out.println("获取食物分类数据 limitQuery = "+limitQuery);
        System.out.println("type = "+type);
        return foodService.queryProInfoByType(limitQuery,type);
    }

    @ApiOperation(value = "根据关键字获取食物信息" ,notes = "分类界面")
    @GetMapping("queryProInfoByKeyword")
    public ResponseData queryProInfoByKeyword(String keyword,String type){
        System.out.println(" keyword= "+keyword);
        System.out.println(" type= "+type);
        return foodService.queryProInfoByKeyword(keyword,type );
    }

    //@ApiOperation(value = "根据食物id获取订单页面数据",notes = "预定界面")
    //@GetMapping("queryBusInfoById")
    //public ResponseData queryBusInfoByIsd(Long id){
    //    System.out.println("根据产品id获取订单页面数据 id = "+id);
    //    return foodService.queryBusInfoById(id);
    //}

}
