package com.taotao;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import sun.nio.ch.IOUtil;

import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public final class HttpUtil {

    private static Logger logger = Logger.getLogger(HttpUtil.class);
    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 60000;
    private static String HTTP_HEADER = "Context-type";
    private static String HTTP_APPLICATION = "application/json;charset=utf-8";

    // 配置连接池
    static {
        connMgr = new PoolingHttpClientConnectionManager();
        connMgr.setMaxTotal(1000);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        // 获取配置器
        RequestConfig.Builder builder = RequestConfig.custom();
        // 设置链接超时时间
        builder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时时间
        builder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时时间
        builder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = builder.build();
    }

    /**
     * GET请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, Object> params) {
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0) {
                param.append("?");
            } else {
                param.append("&");
            }
            param.append(key + "=" + params.get(key));
        }

        String result = null;
        url = url + param;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("response状态码:" + statusCode);
            HttpEntity entity = response.getEntity();
            result = IOUtils.toString(entity.getContent(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }


    public static String doPost(String usl, Map<String, Object> params) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(usl);
        httpPost.setConfig(requestConfig);
        List<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
            list.add(nameValuePair);
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
