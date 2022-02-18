package www.xiyou.dao;

import www.xiyou.entity.Businesss;
import www.xiyou.entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Food)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-19 09:46:06
 */
public interface FoodDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Food queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Food> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param food 实例对象
     * @return 对象列表
     */
    List<Food> queryAll(Food food);

    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 影响行数
     */
    int insert(Food food);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Food> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Food> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Food> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Food> entities);

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 影响行数
     */
    int update(Food food);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Long queryCount();

    Long queryCountByType(String queryCountByType);
    //Food queryBusInfoById(Long id);

    List<Food> queryAllByLimitType(@Param("offset") Long offset, @Param("limit") Long limit,@Param("type") String type);

    List<Food> queryProInfoByKeyword(String keyword, String type);

}

