package All.service.impl;

import All.utils.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import All.pojo.Type;
import All.service.TypeService;
import All.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cai
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-11-08 14:45:42
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public Result findAllTypes() {

        List<Type> list = typeMapper.selectList(null);
        return Result.ok(list);
    }
}




