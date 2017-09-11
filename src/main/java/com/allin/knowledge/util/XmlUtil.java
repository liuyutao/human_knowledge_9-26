package com.allin.knowledge.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

public class XmlUtil {

    public static String jsonStrToXmlStr(Object json) {
        JSONObject jobj = JSONObject.fromObject(json);
        String xml = new XMLSerializer().write(jobj);
        return xml;
    }


    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("asdasd", "错误");
        map.put("asdasds", "错误");
        map.put("asd", "as阿萨德d");
        map.put("2", "错误");
        map.put("", "错误");
        map.put("asdasdsss", "啊飒飒大说");
        JsonConfig con = new JsonConfig();
        System.out.println(MessageUtil.textMessageToXml(map));
    }


}
