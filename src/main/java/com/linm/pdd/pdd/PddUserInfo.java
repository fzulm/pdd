package com.linm.pdd.pdd;

/**
 * 拼多多获取用户信息
 */
public class PddUserInfo {

    public static void main(String[] args) {

        String url = "https://mms.pinduoduo.com/janus/api/userinfo";
        String cookie = "PASS_ID=1-f28ZmzT4JAkW9KceVdqbTMKsDOAhu/G9M/o5gDubFIhZ8pU7KODL3reGysfbbZFKMXXBk8HSwEoVmjXQ9kUEXQ_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        String response  = HttpClientUtils.post(url,cookie);
        System.out.println("===========response:"+response);

//        // 全局请求设置
//        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
//        // 创建cookie store的本地实例
//        CookieStore cookieStore = new BasicCookieStore();
//        // 创建HttpClient上下文
//        HttpClientContext context = HttpClientContext.create();
//        context.setCookieStore(cookieStore);
//
//        // 创建一个HttpClient
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
//                .setDefaultCookieStore(cookieStore).build();
//
//        CloseableHttpResponse res = null;
//
//        try {
//            try {
//
//                String url = "https://mms.pinduoduo.com/janus/api/userinfo";
//                //String url ="https://mms.pinduoduo.com/cambridge/api/rule/hasNewRulesNotRead";
//                HttpPost httpPost = new HttpPost(url);
////                httpPost.setHeader("host","mms.pinduoduo.com");
////                httpPost.setHeader("Connection","keep-alive");
////                httpPost.setHeader("Accept","application/json");
////                httpPost.setHeader("Origin","https://mms.pinduoduo.com");
////                httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36");
////                httpPost.setHeader("Content-Type", "application/json;charset=utf8");
////                httpPost.setHeader("Referer","https://mms.pinduoduo.com/goods/goods_list");
////                httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
////                httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.9");
//
//                httpPost.addHeader(new BasicHeader("Cookie"," PASS_ID=1-fT0Kv41AQDiU2WnVXcsm5QW7Lx8++VW2IzhFoZVmgD99SiiRsXf2T9dh/dCzmbRJ04cmdAFg+A7A1m9Ya2U9vg_434260096_29798991;Max-Age=864000;path=/;HttpOnly"));
//                res = httpClient.execute(httpPost, context);
//                // 获取常用Cookie,包括_xsrf信息
//                System.out.println("访问首页后获取的常规Cookie:===============");
//                for (Cookie c : cookieStore.getCookies()) {
//                    System.out.println(c.getName() + ": " + c.getValue());
//                }
//
//                HttpEntity responseEntity = res.getEntity();
//                if (responseEntity != null) {
//                    System.out.println("响应内容长度为:" + responseEntity.getContentLength());
//                    System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
//                }
//                res.close();
//
//            } finally {
//                httpClient.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
