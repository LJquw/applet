package www.xiyou.dao;

import www.xiyou.entity.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Recommend)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-19 09:46:11
 */
public interface RecommendDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recommend queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Recommend> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param recommend 实例对象
     * @return 对象列表
     */
    List<Recommend> queryAll(Recommend recommend);

    /**
     * 新增数据
     *
     * @param recommend 实例对象
     * @return 影响行数
     */
    int insert(Recommend recommend);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recommend> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Recommend> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recommend> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Recommend> entities);

    /**
     * 修改数据
     *
     * @param recommend 实例对象
     * @return 影响行数
     */
    int update(Recommend recommend);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

