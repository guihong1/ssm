package All.service.impl;

import All.pojo.vo.PortalVo;
import All.utils.JwtHelper;
import All.utils.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import All.pojo.Headline;
import All.service.HeadlineService;
import All.mapper.HeadlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author cai
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-11-08 14:45:42
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;


    @Override
    public Result findNewsPage(PortalVo portalVo) {


        IPage<Map> page=new Page<>(portalVo.getPageNum(),portalVo.getPageSize());

        headlineMapper.selectMyPage(page,portalVo);
        List<Map> list=page.getRecords();
        Map data=new HashMap();
        data.put("pageData",list);
        data.put("pageNum",page.getCurrent());
        data.put("pageSize",page.getSize());
        data.put("totalPage",page.getPages());
        data.put("totalSize",page.getTotal());
        Map pageInfo=new HashMap();
        pageInfo.put("pageInfo",data);
        return Result.ok(pageInfo);
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {

       Map data= headlineMapper.queryDetailMap(hid);
       Map headlineMap=new HashMap();


        headlineMap.put("headline",data);
       Headline headline1=new Headline();
       headline1.setHid((Integer) data.get("hid"));
       headline1.setVersion((Integer) data.get("version"));
       headline1.setPageViews((Integer) data.get("pageViews")+1);
       headlineMapper.updateById(headline1);
       return Result.ok(headlineMap);
    }

    @Override
    public Result publish(Headline headline,String token) {

        int id = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(id);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result updateData(Headline headline) {

        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);
        return Result.ok(null);
    }


}




