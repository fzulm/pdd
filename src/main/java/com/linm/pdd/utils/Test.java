package com.linm.pdd.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        HttpClientContext context = HttpClientContext.create();
        CookieStore cookieStore = new BasicCookieStore();
        context.setCookieStore(cookieStore);
        //String url = "http://baidu.com";
        String url = "https://mms.pinduoduo.com/janus/api/userinfo";
        //String url = "https://mms.pinduoduo.com/cambridge/api/duoduoCollege/hasNewCoursesNotRead";

        HttpPost httpPost = new HttpPost(url);
        BasicClientCookie cookie = new BasicClientCookie("PASS_ID", "1-WoA5nExqNYLZoFlmwwu33d2KQL6twBxMcIX5X2ouZXS4WXPwit9TEsQzPiGzJ/Tn2vnPuvbedZP/jUgxN/kj0A_434260096_29798991");
        BasicClientCookie cookie1 = new BasicClientCookie("api_uid", "rBQHUFxtRlpQxmYvQHlwAg==");
        BasicClientCookie cookie2 = new BasicClientCookie("_nano_fp", "XpdyX0EjnpXxn0EyX9_dr0m~VZbhzU9zpHHRX~ns");
        cookie.setVersion(0);
        cookie.setDomain("pinduoduo.com");
        cookie.setPath("/");
        cookie.setExpiryDate(getDate(1));
        cookie1.setVersion(0);
        cookie1.setDomain("pinduoduo.com");
        cookie1.setPath("/");
        cookie1.setExpiryDate(getDate(1));
        cookie2.setVersion(0);
        cookie2.setDomain("pinduoduo.com");
        cookie2.setPath("/");
        cookieStore.addCookie(cookie);
        cookieStore.addCookie(cookie1);
        cookieStore.addCookie(cookie2);
        cookie2.setExpiryDate(getDate(1));

        HttpHost proxy = new HttpHost("127.0.0.1",8888);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        //CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpClient httpClient= HttpClientBuilder.create().setDefaultCookieStore(cookieStore).setDefaultRequestConfig(requestConfig).build();
        //httpPost.setConfig(requestConfig);


        httpPost.setHeader("host","mms.pinduoduo.com");
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Origin","https://mms.pinduoduo.com");
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36");
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("Referer","https://mms.pinduoduo.com/goods/goods_list");
        httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
        httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");


//        httpPost.setHeader("_nano_fp","XpdyX0EjnpXxn0EyX9_dr0m~VZbhzU9zpHHRX~ns");
//        httpPost.setHeader("api_uid","rBQHUFxtRlpQxmYvQHlwAg==");
//        httpPost.setHeader("PASS_ID","1-WoA5nExqNYLZoFlmwwu33d2KQL6twBxMcIX5X2ouZXS4WXPwit9TEsQzPiGzJ/Tn2vnPuvbedZP/jUgxN/kj0A_434260096_29798991");
//        httpPost.setHeader("Cookies","api_uid=rBQHUFxtRlpQxmYvQHlwAg==; _nano_fp=XpdyX0EjnpXxn0EyX9_dr0m~VZbhzU9zpHHRX~ns; PASS_ID=1-WoA5nExqNYLZoFlmwwu33d2KQL6twBxMcIX5X2ouZXS4WXPwit9TEsQzPiGzJ/Tn2vnPuvbedZP/jUgxN/kj0A_434260096_29798991");
        //Cookie[] cookies =

        CloseableHttpResponse response = null;
        try {
            Header[] headers2 = httpPost.getAllHeaders();
            System.out.println("请求头开始==============================" );
            for (Header header:headers2){
                System.out.println(header.getName()+":" + header.getValue());
            }

            System.out.println("请求头结束==============================" );
            response = httpClient.execute(httpPost);
            System.out.println("响应状态为:" + response.getStatusLine());
            Header[] headers = response.getAllHeaders();
            System.out.println("响应头开始==============================" );
            for (Header header:headers){
                System.out.println(header.getName()+":" + header.getValue());
            }
            System.out.println("响应头结束==============================" );

            List<Cookie> cookies = cookieStore.getCookies();
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("Local cookie: " + cookies.get(i));
            }
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static Date getDate(int day){
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,day);
        date=calendar.getTime();
        return date;
    }
}
