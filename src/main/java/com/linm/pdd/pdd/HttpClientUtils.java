package com.linm.pdd.pdd;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient包装类
 */
public class HttpClientUtils {

    public static String post(String url,String cookie){
        return post(url,cookie,null);
    }

    public static String post(String url,String cookie,String myEntity){
        return post(url,cookie,myEntity,null);
    }

    public static String post(String url,String cookie ,String myEntity,Map<String, String> params) {

        String response = null;

        // 全局请求设置
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        // 创建cookie store的本地实例
        CookieStore cookieStore = new BasicCookieStore();
        // 创建HttpClient上下文
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(cookieStore);

        // 创建一个HttpClient
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
                .setDefaultCookieStore(cookieStore).build();

       // CloseableHttpResponse res = null;

        try {
            try {

                HttpPost httpPost = new HttpPost(url);
//                httpPost.setHeader("host","mms.pinduoduo.com");
//                httpPost.setHeader("Connection","keep-alive");
//                httpPost.setHeader("Accept","application/json");
//                httpPost.setHeader("Origin","https://mms.pinduoduo.com");
//                httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36");
//                httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
//                httpPost.setHeader("Referer","https://mms.pinduoduo.com/goods/goods_add/index?id=13803209625&type=edit&from=category");
//                httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
//                httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");

                httpPost.addHeader(new BasicHeader("Cookie",cookie));
                if (null != myEntity) {
                    StringEntity entity = new StringEntity(myEntity, "utf-8");
                    entity.setContentEncoding("UTF-8");
                    entity.setContentType("pplication/json;charset=utf8");
                    httpPost.setEntity(entity);
                }

                if (null != params){
                    // 构造post数据
                    List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                    }
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
                    entity.setContentType("application/x-www-form-urlencoded");
                    //httpPost.setEntity(entity);
                }

                httpPost.setHeader("Content-Type", "application/json;charset=utf8");

                CloseableHttpResponse res = httpClient.execute(httpPost, context);

                System.out.println("==================Cookie:===============");
                for (Cookie c : cookieStore.getCookies()) {
                    System.out.println(c.getName() + ": " + c.getValue());
                }

                HttpEntity responseEntity = res.getEntity();
                if (responseEntity != null) {
                    System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                    response = EntityUtils.toString(responseEntity);
                    //System.out.println("响应内容为:" + response);

                }

                res.close();

            } finally {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static String get(String url){
        return get(url,null);
    }

    public static String get(String url,String cookie){
        return get(url,cookie,null);
    }

    public static String get(String url,String cookie,Map<String, String> params){
        String response = null;
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (null != params) {
                List<NameValuePair> list = new LinkedList<>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                uriBuilder.setParameters(list);
            }
            System.out.println("=======finalPath:"+uriBuilder.build().toString());
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader(new BasicHeader("Cookie",cookie));
            CloseableHttpResponse res = httpClient.execute(httpGet);
            HttpEntity responseEntity = res.getEntity();
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                response = EntityUtils.toString(responseEntity);
                System.out.println("响应内容长度为:" + response.length());
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
