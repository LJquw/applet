package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.Image;
import www.xiyou.service.ImageService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:10
 */
@Api(tags = "图片接口")
@RestController
@RequestMapping("image")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "selectOne", notes = "获取图片 自动生成的代码")
    @GetMapping("selectOne")
    public Image selectOne(Long id) {
        return this.imageService.queryById(id);
    }

    @ApiOperation(value="根据图片种类获取图片信息",
            notes="根据图片类型获取图片信息 banner-首页轮播图 nav:导航菜单")
    @GetMapping("queryImageByImagetype")
    public ResponseData queryImageByImagetype(String imagetype){
        return imageService.queryImageByImagetype(imagetype);
    }

}
