package All.service;

import All.pojo.User;
import All.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cai
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-11-08 14:45:42
*/
public interface UserService extends IService<User> {

    /**
     * 登录业务
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据token获取用户数据
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 注册时检查账号是否可用
     * @param name
     * @return
     */
    Result checkUserName(String name);

    /**
     *
     * 实现注册业务
     * @param user
     * @return
     */
    Result regist(User user);
}
