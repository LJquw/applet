package www.xiyou.dao;

import www.xiyou.entity.Businesss;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Businesss)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-19 09:25:09
 */
public interface BusinesssDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Businesss queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Businesss> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param businesss 实例对象
     * @return 对象列表
     */
    List<Businesss> queryAll(Businesss businesss);

    /**
     * 新增数据
     *
     * @param businesss 实例对象
     * @return 影响行数
     */
    int insert(Businesss businesss);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Businesss> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Businesss> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Businesss> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Businesss> entities);

    /**
     * 修改数据
     *
     * @param businesss 实例对象
     * @return 影响行数
     */
    int update(Businesss businesss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Long queryCount();

    Businesss queryBusInfoById(Long id);

}

