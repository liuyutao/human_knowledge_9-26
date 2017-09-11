package com.allin.knowledge.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;


public class WeixinUtil {


    /**
     * 通讯信息
     */
    public static boolean isNormalReturnCode(Map map) {
        String message = StringTool.getMapString(map, "return_code");
        if (message.equals("SUCCESS")) {
            return true;
        }
        return false;
    }

    /**
     * 交易信息
     */
    public static boolean isNomalResultCode(Map map) {
        String message = StringTool.getMapString(map, "result_code");
        if (message.equals("SUCCESS")) {
            return true;
        }
        return false;
    }


    /**
     * 最终结果是否成功
     */
    public static boolean isNomalAllResult(Map map) {

        return isNormalReturnCode(map) && isNomalResultCode(map);
    }

    /**
     * 加密连接
     *
     * @throws KeyStoreException
     * @throws IOException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     */
    @SuppressWarnings("deprecation")
    public static String sendEncryptPostRequest(String mchId, String requestUrl, String param, String client12Url) {

        try {
            char[] mchArea = mchId == null ? new char[]{} : mchId.toCharArray();
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File(client12Url));
            try {

                keyStore.load(instream, mchArea);

            } finally {
                instream.close();
            }

            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchArea).build();
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .build();
            try {
                HttpPost httpPost = new HttpPost(requestUrl);
                StringEntity se = new StringEntity(param.toString());
                httpPost.setEntity(se);

                System.out.println("executing request" + httpPost.getRequestLine());

                CloseableHttpResponse response = httpclient.execute(httpPost);
                try {
                    HttpEntity entity = response.getEntity();
                    StringBuilder textBuild = new StringBuilder();
                    System.out.println("----------------------------------------");
                    System.out.println(response.getStatusLine());
                    if (entity != null) {
                        System.out.println("Response content length: " + entity.getContentLength());
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                        String text;
                        while ((text = bufferedReader.readLine()) != null) {
                            textBuild.append(text);
                            System.out.println(text);
                        }
                    }
                    EntityUtils.consume(entity);
                    return textBuild.toString();
                } finally {
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 封装返回的map信息数据
     */
    public static Map returnWeixinException(String return_code, String return_msg, String exceptionMessage) {
        Map returnMap = new HashMap();
        returnMap.put("return_code", return_code);
        returnMap.put("return_msg", return_msg);
        if (null != exceptionMessage)
            returnMap.put("exception_message", exceptionMessage);
        return returnMap;
    }



}
