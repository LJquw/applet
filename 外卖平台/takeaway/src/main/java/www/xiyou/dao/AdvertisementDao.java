package www.xiyou.dao;

import www.xiyou.entity.Advertisement;
import org.apache.ibatis.annotations.Param;
import www.xiyou.entity.Businesss;

import java.util.List;

/**
 * (Advertisement)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-19 10:55:00
 */
public interface AdvertisementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Advertisement queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Advertisement> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param advertisement 实例对象
     * @return 对象列表
     */
    List<Advertisement> queryAll(Advertisement advertisement);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int insert(Advertisement advertisement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Long queryCount();

    //Advertisement queryAdInfoById(Long id);

    Advertisement queryBusInfoById(Long id);

}

