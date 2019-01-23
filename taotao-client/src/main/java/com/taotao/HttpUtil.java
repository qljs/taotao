package com.taotao;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public final class HttpUtil {

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 60000;

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
        builder.setsa
    }


}
