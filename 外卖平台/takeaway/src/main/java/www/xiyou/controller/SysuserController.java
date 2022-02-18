package www.xiyou.controller;

import io.swagger.annotations.Api;
import www.xiyou.entity.Sysuser;
import www.xiyou.service.SysuserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sysuser)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:13
 */
@Api(tags = "微信用户")
@RestController
@RequestMapping("sysuser")
public class SysuserController {
    /**
     * 服务对象
     */
    @Resource
    private SysuserService sysuserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sysuser selectOne(Long id) {
        return this.sysuserService.queryById(id);
    }

}
