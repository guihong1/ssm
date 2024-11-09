package All.mapper;

import All.pojo.Headline;
import All.pojo.vo.PortalVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author cai
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-11-08 14:45:42
* @Entity All.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {



    IPage<Map> selectMyPage(IPage page, @Param("portalVo") PortalVo portalVo);

    Map queryDetailMap(Integer hid);
}




