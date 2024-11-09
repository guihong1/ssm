package All.service;

import All.pojo.Type;
import All.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cai
* @description 针对表【news_type】的数据库操作Service
* @createDate 2024-11-08 14:45:42
*/
public interface TypeService extends IService<Type> {

    /**
     * 查询所有类别数据
     * @return
     */
    Result findAllTypes();
}
