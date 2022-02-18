package www.xiyou.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.crypto.hash.Md5Hash;
import www.xiyou.entity.User;
import www.xiyou.dao.UserDao;
import www.xiyou.service.UserService;
import org.springframework.stereotype.Service;
import www.xiyou.utils.HttpClientUtil;
import www.xiyou.utils.ResponseCode;
import www.xiyou.utils.ResponseData;
import www.xiyou.utils.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-08-19 09:46:13
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public ResponseData insert(User user) {
        String phone = user.getPhone();
        String password = user.getPassword();
        try{
            //1.对手机号和密码进行校验   --  非空
            if(StringUtils.isNull(phone)||StringUtils.isNull(password)){
                //返回错误信息
                return new ResponseData(ResponseCode.ERROR_1);
            }

            //2.校验手机号是否已经注册  如何校验？   根据获取到的手机号，取查询user表，如果有数据，说明已经该手机号已经注册过了
            User queryUser = userDao.queryUserByPhone(phone);
            if(queryUser!=null){  //说明已经存在该用户
                return new ResponseData(ResponseCode.ERROR_2);
            }


            //3.对密码进行加密   参数一：加密的数据源   参数二：盐值  参数三：加密次数
            Md5Hash md5Hash = new Md5Hash(password,"xiyou",10);
            System.out.println("加密之后的密码 = "+md5Hash);

            //4.进行保存操作
            user.setPassword(md5Hash.toString());  //设置为加密之后的密码
            this.userDao.insert(user);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData userLogin(String code, String password, String phone) {
        //1.非空校验
        if(StringUtils.isNull(code)){
            return new ResponseData(ResponseCode.ERROR_3);
        }
        if(StringUtils.isNull(password)||StringUtils.isNull(phone)){
            return new ResponseData(ResponseCode.ERROR_1);
        }

        try{
            //2.做密码加密   加密规则  盐值 ：xiyou  加密次数 ： 10次
            Md5Hash md5Hash = new Md5Hash(password,"xiyou",10);
            password = md5Hash.toString(); //获取加密之后的密码

            //3.根据手机号和加密之后的密码。查询user表，如果有数据，说明匹配
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("phone", phone);
            map.put("password", password);
            User user = userDao.queryUserByMap(map);
            if(user==null){//说明没有查询到数据
                return new ResponseData(ResponseCode.ERROR_4);
            }

            //4.调用微信的登录接口   模拟http请求
            String httpUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+StringUtils.APPID+"&secret="+StringUtils.SECRET+"&js_code="+code+"&grant_type=authorization_code";
            String result = HttpClientUtil.doGet(httpUrl);
            System.out.println("result = "+result);

            //5.把字符串转成json对象
            JSONObject jsonResult = (JSONObject) JSON.parse(result);
            String session_key = (String)jsonResult.get("session_key");
            String openid = (String)jsonResult.get("openid");
            System.out.println("openid = "+openid+",session_key = "+session_key);

            //6.自定义登录状态  需要关联openid和session_key
            Md5Hash md5 = new Md5Hash(openid,session_key,100);
            String token = md5.toString();

            //7.做跟新操作   根据手机号跟新user表   openid session_key  token
            user.setToken(token);
            user.setSessionkey(session_key);
            user.setOpenid(openid);
            userDao.update(user);
            return new ResponseData(token,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public String queryOpenidByToken(String token) {

        return userDao.queryOpenidByToken(token);
    }
}
