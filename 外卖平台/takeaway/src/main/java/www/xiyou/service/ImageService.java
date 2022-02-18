package www.xiyou.service;

import www.xiyou.entity.Image;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (Image)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:10
 */
public interface ImageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Image queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Image> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image insert(Image image);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据图片类型获取图片信息
     * @param imagetype 图片类型 banner:首页轮播图类型  nav:首页导航菜单图片类型
     * @return
     */
    ResponseData queryImageByImagetype(String imagetype);


}
