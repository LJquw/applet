package www.xiyou.service;

import www.xiyou.entity.User;
import www.xiyou.utils.ResponseData;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-08-19 09:46:13
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    ResponseData insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     *
     * @param code
     * @param password
     * @param phone
     * @return
     */
    ResponseData userLogin(String code,String password,String phone);

    /**
     *
     * @param token
     * @return
     */
    String queryOpenidByToken(String token);

}
