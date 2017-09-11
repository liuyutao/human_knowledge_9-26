package com.allin.knowledge.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.allin.knowledge.util.security.Base64;
import com.allin.knowledge.util.security.MD5;
import com.comm.util.string.StringTool;

public class MD5Util {
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    public static String createSign(String characterEncoding, Map<Object, Object> parameters, String mchKey) {
        Map sortMap = null;
        String sign = null;
        if (!CollectionUtils.isEmpty(parameters)) {
            sortMap = new TreeMap();
            sortMap.putAll(parameters);
            StringBuffer sb = new StringBuffer();
            Set es = sortMap.entrySet();//所有参与传参的参数按照accsii排序（升序）
            Iterator it = es.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String k = (String) entry.getKey();
                Object v = entry.getValue();
                if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                    sb.append(k + "=" + v + "&");
                }
            }
            sb.append("key=" + mchKey);
            System.out.println("sign==========================" + sb.toString());
            sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        }
        return sign;
    }

    /**
     * 生成token
     * paramMap  用户ID，IP，sessionId,
     * key是内部查询出来二次存入此map
     */
    public static String buildToken(Map paramMap) {
        String key = StringTool.getMapString(paramMap, "secretKey");
        Map buildMap = orgParamMap(paramMap);
        System.out.println("==buildMap===" + buildMap);
        String prestr = createLinkString(buildMap);
        System.out.println("==prestr===" + prestr);
        String base64 = Base64.encode(prestr.getBytes());
        String token = MD5.getMD5Code(base64 + key);
        return token;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = String.valueOf(params.get(key));

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 组织生成token的参数
     * 第一次调用需要的参数roleId,opIp,deviceToken,usePlatform,siteId
     * 第二次核对token时，相比上一次，增加第一次生成的token参数
     */
    public static Map orgParamMap(Map paramMap) {
        Map orgMap = new HashMap();
        String roleId = StringTool.getMapString(paramMap, "roleId");
        String opIp = StringTool.getMapString(paramMap, "opIp");
        String deviceToken = StringTool.getMapString(paramMap, "deviceToken");
        String usePlatform = StringTool.getMapString(paramMap, "usePlatform");
        String siteId = StringTool.getMapString(paramMap, "siteId");
        String nonceStr = StringTool.getMapString(paramMap, "nonceStr");
        String token = StringTool.getMapString(paramMap, "token");
        if (StringUtils.isNotEmpty(roleId)) {
            orgMap.put("roleId", roleId);
        }
        if (StringUtils.isNotEmpty(opIp)) {
            orgMap.put("opIp", opIp);
        }
        if (StringUtils.isNotEmpty(deviceToken)) {
            orgMap.put("deviceToken", deviceToken);
        }
        if (StringUtils.isNotEmpty(usePlatform)) {
            orgMap.put("usePlatform", usePlatform);
        }
        if (StringUtils.isNotEmpty(siteId)) {
            orgMap.put("siteId", siteId);
        }
        if (StringUtils.isNotEmpty(nonceStr)) {
            orgMap.put("nonceStr", nonceStr);
        }
        if (StringUtils.isNotEmpty(token)) {
            orgMap.put("token", token);
        }


        return orgMap;
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("mch_id", "1305010601");
        map.put("sign", "3EE1A8D42066563F8F5E8806E677BB5D");
        map.put("body", "aasdasdsd");
        map.put("total_fee", "1");
        map.put("spbill_create_ip", "219.237.242.167");
        map.put("notify_url", "http://pay.allinmd.cn:8091/external/notifyResultOrder");
        map.put("appid", "wxfe045a63fa8e4401");
        map.put("out_trade_no", "2015061828181252");
        map.put("trade_type", "NATIVE");
        System.out.println(MD5Util.createSign("UTF-8", map, "asdghashiwoegfhgasdhfkldshffslkd"));


    }

}
