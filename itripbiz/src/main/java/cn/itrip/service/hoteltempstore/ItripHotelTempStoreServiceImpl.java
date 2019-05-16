package cn.itrip.service.hoteltempstore;

import cn.itrip.beans.vo.store.StoreVO;
import cn.itrip.common.EmptyUtils;
import cn.itrip.dao.hoteltempstore.ItripHotelTempStoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelTempStoreServiceImpl implements ItripHotelTempStoreService {

    @Resource
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    @Override
    public List<StoreVO> queryRoomStore(Map<String, Object> param) throws Exception {
        itripHotelTempStoreMapper.flushStore(param);
        return itripHotelTempStoreMapper.queryRoomStore(param);
    }

    @Override
    public boolean validateRoomStore(Map<String, Object> param) throws Exception {
        Integer count = (Integer) param.get("count");
        itripHotelTempStoreMapper.flushStore(param);
        List<StoreVO> storeVOList = itripHotelTempStoreMapper.queryRoomStore(param);
        if(EmptyUtils.isEmpty(storeVOList)){
            return false;
        }
        for (StoreVO vo : storeVOList) {
            if (vo.getStore() < count) {
                return false;
            }
        }
        return true;
    }

    /***
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param roomId    房间ID
     * @param count     数目
     * @return
     * @throws Exception
     */
    public boolean updateRoomStore(Map<String, Object> param) throws Exception {
        Integer flag = itripHotelTempStoreMapper.updateRoomStore(param);
        return flag == 0 ? false : true;
    }

}
