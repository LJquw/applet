package www.xiyou.service.impl;

import www.xiyou.entity.Advertisement;
import www.xiyou.dao.AdvertisementDao;
import www.xiyou.entity.Businesss;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.AdvertisementService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Advertisement)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 10:55:00
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
    @Resource
    private AdvertisementDao advertisementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Advertisement queryById(Long id) {
        return this.advertisementDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Advertisement> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement insert(Advertisement advertisement) {
        this.advertisementDao.insert(advertisement);
        return advertisement;
    }

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement update(Advertisement advertisement) {
        this.advertisementDao.update(advertisement);
        return this.queryById(advertisement.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.advertisementDao.deleteById(id) > 0;
    }

    @Override
    //分页获取广告信息
    public ResponseData queryAdInfo(LimitQuery limitQuery) {
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();

            Long start = (page-1)*limit;

            List<Advertisement> advertisements = advertisementDao.queryAllByLimit(start, limit);
            //获取总条数
            Long count = advertisementDao.queryCount();
            return new ResponseData(advertisements, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    //点击指定行获取广告信息
    public ResponseData queryInfoById(Long id) {

        try{
            Advertisement advertisement = advertisementDao.queryById(id);
            return new ResponseData(advertisement,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    //根据广告id获取订单页面数据
    public ResponseData queryBusInfoById(Long id) {
        try{
            Advertisement advertisement = advertisementDao.queryBusInfoById(id);
            return new ResponseData(advertisement, ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

}
