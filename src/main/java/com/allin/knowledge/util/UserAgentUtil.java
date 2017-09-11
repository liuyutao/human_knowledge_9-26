package com.allin.knowledge.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentUtil {

    /**
     * 获取设备信息
     *
     * @param request
     * @return PC:浏览器、pc、操作系统
     */
    public static String getOpDev(HttpServletRequest request) {
        Map paramMap = new HashMap();
        /* 获取客户端信息 */
        UserAgent userAgent = UserAgent.parseUserAgentString(request
                .getHeader("user-agent"));
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();
        // 得到用户的浏览器名
        String userbrowser = browser.getName();
        // 得到用户的操作系统名
        String useros = os.getName();
        String opAdvice = userbrowser + ",pc," + useros;
        return opAdvice;
    }


    /**
     * 获取ip地址信息
     *
     * @param request
     * @return request IP
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        System.out.println("baseAction ip1=" + ip);

        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            String[] str = ip.split(",");

            ip = str[0];// ip.substring(ip.lastIndexOf(",") + 1,
            // ip.length()).trim();

            System.out.println("baseAction ip2=" + ip);
        }
        return ip;
    }
}
