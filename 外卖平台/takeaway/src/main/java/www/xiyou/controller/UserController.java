package www.xiyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import www.xiyou.entity.User;
import www.xiyou.service.UserService;
import org.springframework.web.bind.annotation.*;
import www.xiyou.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-08-19 09:46:13
 */
@Api(tags = "小程序用户")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("regUser")
    public ResponseData regUser(User user){
        System.out.println("注册 user = "+user);

        return userService.insert(user);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("userLogin")
    public ResponseData userLogin(String code,String password,String phone){
        System.out.println("登录 code = "+code);
        System.out.println("登录 password = "+password);
        System.out.println("登录 phone = "+phone);

        return userService.userLogin(code,password ,phone );
    }

}
