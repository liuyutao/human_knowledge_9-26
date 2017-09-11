package com.allin.knowledge.util;

import java.util.Map;
import java.util.Random;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 字符串辅助类，处理常用的字符串操作
 *
 * @author lvx@cic.tsinghua.edu.cn 创建日期: 2009.07.14
 */

public class StringUtil {

    /**
     * 随机生成字符串
     *
     * @param length result字符串长度
     * @return
     */
    public static String nonceStr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 签名算法
     *
     * @param Map 所有Map值
     * @return
     */
    public static String signatureMD5(Map<String, Object> map, String solt) {
        StringBuilder randomKey = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            randomKey.append(entry.getKey().toString() + "=" + entry.getValue().toString() + "&");
        }
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        md5.setEncodeHashAsBase64(false);
        return md5.encodePassword(randomKey.toString(), solt).toUpperCase();//转码后全部大写

    }

}
