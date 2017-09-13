package com.allin.knowledge.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allin.knowledge.business.service.KnowledgeCustomerAnswerService;
import com.allin.knowledge.mapper.KnowledgeCommDataMaterielMapper;
import com.allin.knowledge.mapper.KnowledgeCustomerAnswerMapper;
import com.allin.knowledge.model.KnowledgeCommDataMateriel;
import com.allin.knowledge.model.KnowledgeCustomerAnswer;
import com.allin.knowledge.util.StringTool;
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
public class KnowledgeCustomerAnswerServiceImpl implements KnowledgeCustomerAnswerService{

    @Autowired
    private KnowledgeCustomerAnswerMapper answerMapper;
    @Autowired
    private KnowledgeCommDataMaterielMapper materielMapper;

    public List<KnowledgeCustomerAnswer> getList(Map paramMap) {
        return answerMapper.getList(paramMap);
    }

    @Override
    public long create(Map paramMap) {
        return answerMapper.inserts(paramMap);
    }

    public Map getResultMapList(Map paramJson){
        BaseResponseObject responseObject = new BaseResponseObject(Boolean.FALSE, "", "");
        try {
            String mapString = StringTool.getMapString(paramJson, "paramJson");
            JSONObject object = JSON.parseObject(mapString);
            Object customerId = object.get("customerId");
            if (customerId == null) {
                responseObject.setResponseMessage("customerId不能为空");
                responseObject.setResponseStatus(true);
                return MapUtil.transBean2Map(responseObject);
            }
            Map answerMap = new HashMap();
            if (!object.containsKey("firstResult")) {
                answerMap.put("firstResult", 0);
            }else{
                answerMap.put("firstResult", Long.parseLong(object.get("firstResult").toString()));
            }
            if (!object.containsKey("maxResult")) {
                answerMap.put("maxResult", Long.MAX_VALUE);
            }else{
                answerMap.put("maxResult", Long.parseLong(object.get("maxResult").toString()));
            }
            answerMap.put("customerId",Long.parseLong(customerId.toString()));
            List<Map> respList0 = new ArrayList<Map>();
            List<Map> respList1 = new ArrayList<Map>();
            List<Map> respList2 = new ArrayList<Map>();
            int humanScore = 0;
            List<KnowledgeCustomerAnswer> answerList = answerMapper.getList(answerMap);
            StringBuilder isStr = new StringBuilder("0");
            if (CollectionUtils.isNotEmpty(answerList)){
                for (KnowledgeCustomerAnswer customerAnswer : answerList) {
                    isStr.append(",").append(customerAnswer.getMaterielId());
                }
            }
            if (isStr.length() > 1){
                System.out.println("===============" + isStr.toString());
                Map materMap = new HashMap();
                materMap.put("firstResult",0);
                materMap.put("maxResult",Long.MAX_VALUE);
                materMap.put("idList",isStr.toString());
                List<KnowledgeCommDataMateriel> materielList = materielMapper.getLists(materMap);
                System.out.println("===============" + answerList.size());
                for (KnowledgeCustomerAnswer customerAnswer : answerList) {
                    Map<String, Object> bean2Map = MapUtil.transBean2Map(customerAnswer);
                    KnowledgeCommDataMateriel commDataMateriel = KnowledgeCommDataMateriel.findKnowledgeCommDataMateriel(materielList, customerAnswer.getMaterielId());
                    if (commDataMateriel != null){
                        bean2Map.put("directionId",commDataMateriel.getDirectionId());
                        if (commDataMateriel.getDirectionId() == 0){
                            respList0.add(bean2Map);
                        }else if (commDataMateriel.getDirectionId() == 1){
                            respList1.add(bean2Map);
                        }else if (commDataMateriel.getDirectionId() == 2){
                            respList2.add(bean2Map);
                        }
                        if (customerAnswer.getIsRightOption() == 1){
                            humanScore += 2;
                        }
                    }
                }
            }
            HashMap responseData = new HashMap();
            if (!CollectionUtils.isEmpty(respList0) || !CollectionUtils.isEmpty(respList1) || !CollectionUtils.isEmpty(respList2)) {
                responseData.put("dataList0", respList0);
                responseData.put("dataList1", respList1);
                responseData.put("dataList2", respList2);
                responseData.put("dataScore", humanScore);
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
