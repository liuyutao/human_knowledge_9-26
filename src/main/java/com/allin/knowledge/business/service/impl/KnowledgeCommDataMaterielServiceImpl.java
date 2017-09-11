package com.allin.knowledge.business.service.impl;

import com.allin.knowledge.business.service.KnowledgeCommDataMaterielService;
import com.allin.knowledge.mapper.KnowledgeCommDataMaterielMapper;
import com.allin.knowledge.model.KnowledgeCommDataMateriel;
import com.comm.constants.ResponseCode;
import com.comm.util.BaseResponseObject;
import com.comm.util.MapUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aubergine
 * @date 2017-9-5 21:04:14
 */
@Service
public class KnowledgeCommDataMaterielServiceImpl implements KnowledgeCommDataMaterielService{

    @Autowired
    private KnowledgeCommDataMaterielMapper materielMapper;

    public List<KnowledgeCommDataMateriel> getLists(Map paramMap) {
        return materielMapper.getLists(paramMap);
    }
    public Map getMapList(Map paramJson){
        BaseResponseObject responseObject = new BaseResponseObject(Boolean.FALSE, "", "");
        try {
            if (!paramJson.containsKey("firstResult")) {
                paramJson.put("firstResult", 0);
            }else{
                paramJson.put("firstResult", Long.parseLong(paramJson.get("firstResult").toString()));
            }
            if (!paramJson.containsKey("maxResult")) {
                paramJson.put("maxResult", Long.MAX_VALUE);
            }else{
                paramJson.put("maxResult", Long.parseLong(paramJson.get("maxResult").toString()));
            }
            List<Map> respList = new ArrayList<Map>();
            List<KnowledgeCommDataMateriel> materielList = materielMapper.getLists(paramJson);
            if (CollectionUtils.isNotEmpty(materielList)){
                for (KnowledgeCommDataMateriel knowledgeCommDataMateriel : materielList) {
                    respList.add(MapUtil.transBean2Map(knowledgeCommDataMateriel));
                }
            }
            HashMap responseData = new HashMap();
            if (!CollectionUtils.isEmpty(respList)) {
                responseData.put("dataList", respList);
            } else {
                responseObject.setResponseMessage("NO DATA");
                responseObject.setResponseCode(ResponseCode.GLOBAL_FAILTURE);
            }
            responseObject.setResponseData(responseData);
            responseObject.setResponseStatus(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setResponseStatus(Boolean.FALSE);
            responseObject.setResponseCode(ResponseCode.GLOBAL_EXCEPTION);
        }
        return MapUtil.transBean2Map(responseObject);
    }
}
