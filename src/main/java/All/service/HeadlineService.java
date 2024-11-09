package All.service;

import All.pojo.Headline;
import All.pojo.vo.PortalVo;
import All.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cai
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-11-08 14:45:42
*/
public interface HeadlineService extends IService<Headline> {


    /**
     * 首页数据查询
     * @param portalVo
     * @return
     */
    Result findNewsPage(PortalVo portalVo);

    /**
     *
     * 根据id查询头条查询
     * @param hid
     * @return
     */
    Result showHeadlineDetail(Integer hid);

    /**
     * 发布对应头条的方法
     * @param headline
     * @return
     */
    Result publish(Headline headline,String token);

    /**
     * 修改头条方法
     * @param headline
     * @return
     */
    Result updateData(Headline headline);
}
