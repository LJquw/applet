package www.xiyou.service.impl;

import www.xiyou.entity.Recommend;
import www.xiyou.dao.RecommendDao;
import www.xiyou.service.RecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Recommend)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:12
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    @Resource
    private RecommendDao recommendDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Recommend queryById(Long id) {
        return this.recommendDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Recommend> queryAllByLimit(int offset, int limit) {
        return this.recommendDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    @Override
    public Recommend insert(Recommend recommend) {
        this.recommendDao.insert(recommend);
        return recommend;
    }

    /**
     * 修改数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    @Override
    public Recommend update(Recommend recommend) {
        this.recommendDao.update(recommend);
        return this.queryById(recommend.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.recommendDao.deleteById(id) > 0;
    }
}
