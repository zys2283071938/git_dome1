package cn.itrip.service.areadic;

import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.dao.areadic.ItripAreaDicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripAreaDicServiceImpl implements ItripAreaDicService {

    @Resource
    private ItripAreaDicMapper itripAreaDicMapper;

    public List<ItripAreaDic> getItripAreaDicListByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicListByMap(param);
    }

    @Override
    public Integer itriptxModifyItripAreaDic(ItripAreaDic itripAreaDic) throws Exception {
        itripAreaDic.setModifyDate(new Date());
        return itripAreaDicMapper.updateItripAreaDic(itripAreaDic);
    }

}
