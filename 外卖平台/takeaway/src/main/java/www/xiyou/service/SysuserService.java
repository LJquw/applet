package www.xiyou.service;

import www.xiyou.entity.Sysuser;

import java.util.List;

/**
 * (Sysuser)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:12
 */
public interface SysuserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysuser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sysuser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    Sysuser insert(Sysuser sysuser);

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    Sysuser update(Sysuser sysuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
