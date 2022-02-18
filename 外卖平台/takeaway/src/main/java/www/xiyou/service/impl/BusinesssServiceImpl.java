package www.xiyou.service.impl;

import www.xiyou.entity.Businesss;
import www.xiyou.dao.BusinesssDao;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.BusinesssService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Businesss)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:25:09
 */
@Service("businesssService")
public class BusinesssServiceImpl implements BusinesssService {
    @Resource
    private BusinesssDao businesssDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Businesss queryById(Long id) {
        return this.businesssDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Businesss> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param businesss 实例对象
     * @return 实例对象
     */
    @Override
    public Businesss insert(Businesss businesss) {
        this.businesssDao.insert(businesss);
        return businesss;
    }

    /**
     * 修改数据
     *
     * @param businesss 实例对象
     * @return 实例对象
     */
    @Override
    public Businesss update(Businesss businesss) {
        this.businesssDao.update(businesss);
        return this.queryById(businesss.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.businesssDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryBusInfoById(Long id) {
        try{
            Businesss businesss = businesssDao.queryBusInfoById(id);
            return new ResponseData(businesss, ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryBusInfo(LimitQuery limitQuery) {
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();

            Long start = (page-1)*limit;

            List<Businesss> businessses = businesssDao.queryAllByLimit(start, limit);
            //获取总条数
            Long count = businesssDao.queryCount();
            return new ResponseData(businessses, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryInfoById(Long id) {

        try{
            Businesss businesss = businesssDao.queryById(id);
            return new ResponseData(businesss,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

}
