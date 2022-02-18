package www.xiyou.service.impl;

import www.xiyou.entity.Image;
import www.xiyou.dao.ImageDao;
import www.xiyou.service.ImageService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:10
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Image queryById(Long id) {
        return this.imageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Image> queryAllByLimit(int offset, int limit) {
        return this.imageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image insert(Image image) {
        this.imageDao.insert(image);
        return image;
    }

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image update(Image image) {
        this.imageDao.update(image);
        return this.queryById(image.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.imageDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryImageByImagetype(String imagetype) {
        try {
            //直接调用dao层 imagetype和imagestate
            Image image = new Image();
            //设置图片类型
            image.setImagetype(imagetype);
            //设置图片状态 1：可用  0：禁用
            image.setImagestate("1");
            //调用dao层拿到数据
            List<Image> images = imageDao.queryAll(image);
            //返回数据
            return new ResponseData(images, ResponseCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
