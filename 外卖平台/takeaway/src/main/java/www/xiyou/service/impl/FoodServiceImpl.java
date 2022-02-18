package www.xiyou.service.impl;

import www.xiyou.entity.Businesss;
import www.xiyou.entity.Food;
import www.xiyou.dao.FoodDao;
import www.xiyou.query.LimitQuery;
import www.xiyou.service.FoodService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Food)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:06
 */
@Service("foodService")
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodDao foodDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Food queryById(Long id) {
        return this.foodDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(LimitQuery limitQuery) {
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();

            Long start = (page-1)*limit;  //从哪开始查询

            List<Food> foods = this.foodDao.queryAllByLimit(start, limit);

            //获取数据库的总条数
            Long count = foodDao.queryCount();

            return new ResponseData(foods, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    @Override
    public Food insert(Food food) {
        this.foodDao.insert(food);
        return food;
    }

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    @Override
    public Food update(Food food) {
        this.foodDao.update(food);
        return this.queryById(food.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.foodDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryProInfoById(Long id) {
        try{
            Food food = foodDao.queryById(id);
            return new ResponseData(food,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public ResponseData queryProInfoByType(LimitQuery limitQuery, String type) {
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();

            Long start = (page-1)*limit;  //从哪开始查询

            List<Food> projects = this.foodDao.queryAllByLimitType(start, limit,type);

            //获取数据库的总条数
            Long count = foodDao.queryCountByType(type);

            return new ResponseData(projects, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    //@Override
    //public ResponseData queryBusInfoById(Long id) {
    //    try{
    //        Food food = foodDao.queryBusInfoById(id);
    //        return new ResponseData(food, ResponseCode.SUCCESS);
    //    }catch (Exception e){
    //        System.out.println(e);
    //        return new ResponseData(ResponseCode.FAIL);
    //    }
    //}

    @Override
    public ResponseData queryProInfoByKeyword(String keyword, String type) {

        try{
            List<Food> foods = foodDao.queryProInfoByKeyword("%"+keyword+"%", type);
            return new ResponseData(foods,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
