package www.xiyou.dao;

import www.xiyou.entity.Sysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Sysuser)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-19 09:46:12
 */
public interface SysuserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysuser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sysuser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysuser 实例对象
     * @return 对象列表
     */
    List<Sysuser> queryAll(Sysuser sysuser);

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 影响行数
     */
    int insert(Sysuser sysuser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sysuser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sysuser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sysuser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Sysuser> entities);

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 影响行数
     */
    int update(Sysuser sysuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

