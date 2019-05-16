package cn.itrip.service.hoteltempstore;

import cn.itrip.beans.vo.store.StoreVO;

import java.util.List;
import java.util.Map;

public interface ItripHotelTempStoreService {
    public List<StoreVO> queryRoomStore(Map<String, Object> param)throws Exception;

    public boolean validateRoomStore(Map<String, Object> param)throws Exception;
    /***
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param roomId 房间ID
     * @param count 预订数目
     * @return
     * @throws Exception
     */
    public boolean updateRoomStore(Map<String, Object> param) throws Exception;
}
