package com.allin.knowledge.util;


import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MapUtil {

    public static Map parserToMap(String s) {
        HashMap map = new HashMap();
        JSONObject json = JSONObject.fromObject(s);
        Iterator keys = json.keys();
        while (true) {
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = json.get(key).toString();
                if (value.startsWith("{") && value.endsWith("}")) {
                    map.put(key, parserToMap(value));
                } else {
                    map.put(key, value);
                }
            }

            return map;
        }
    }

    /**
     * 封装返回的map信息数据
     */
    public static Map returnResponseMap(Map map, boolean status) {
        return returnResponseMap(map, status, 0);
    }

    /**
     * 封装返回的map信息数据
     */
    public static Map returnResponseMap(Map map, boolean status, long responsePk) {
        BaseResponseObject responseObject = new BaseResponseObject();
        /**
         * 处理请求结果
         * */
        responseObject.setResponsePk(responsePk);
        responseObject.setResponseData(map);
        responseObject.setResponseStatus(status);
        String message = status ? "SUCCESS" : "FAIL";
        responseObject.setResponseMessage(message);

        return com.comm.util.MapUtil.transBean2Map(responseObject);

    }


    /**
     * 封装返回的map信息数据
     */
    public static Map tokenErrorResponse() {
        Map map = new HashMap();
        map.put("return_code", "FAIL");
        map.put("return_msg", "token校验失败");
        return map;

    }


    public static void main(String[] args) {

    }


}
