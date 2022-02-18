package www.xiyou.service.impl;

import www.xiyou.entity.Sysuser;
import www.xiyou.dao.SysuserDao;
import www.xiyou.service.SysuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sysuser)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:13
 */
@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {
    @Resource
    private SysuserDao sysuserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysuser queryById(Long id) {
        return this.sysuserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Sysuser> queryAllByLimit(int offset, int limit) {
        return this.sysuserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    @Override
    public Sysuser insert(Sysuser sysuser) {
        this.sysuserDao.insert(sysuser);
        return sysuser;
    }

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    @Override
    public Sysuser update(Sysuser sysuser) {
        this.sysuserDao.update(sysuser);
        return this.queryById(sysuser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysuserDao.deleteById(id) > 0;
    }
}
