package www.xiyou.controller;

import io.swagger.annotations.Api;
import www.xiyou.entity.Recommend;
import www.xiyou.service.RecommendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Recommend)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:12
 */
@Api(tags = "导航栏")
@RestController
@RequestMapping("recommend")
public class RecommendController {
    /**
     * 服务对象
     */
    @Resource
    private RecommendService recommendService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Recommend selectOne(Long id) {
        return this.recommendService.queryById(id);
    }

}
