package com.linm.pdd.pdd;

/**
 * 拼多多新建商品
 */
public class PddCreateNew {

    public static void main(String[] args) {

        String url = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/create_new";
        String cookie = "PASS_ID=1-D7gM/iYeWKOxFV/j/DdMqr2E7eeePaz4M6mBNTyDE8t4lW3tkOs+a+EVIG77GqsTiVqhdRRnJd/62u9FyZT05w_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        String entity = "{}";
        String response  = HttpClientUtils.post(url,cookie,entity);
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
//        // 创建本地的HTTP内容
//        try {
//            try {
//
//                String url = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/create_new";
//                HttpPost httpPost = new HttpPost(url);
//                httpPost.addHeader(new BasicHeader("Cookie"," PASS_ID=1-fT0Kv41AQDiU2WnVXcsm5QW7Lx8++VW2IzhFoZVmgD99SiiRsXf2T9dh/dCzmbRJ04cmdAFg+A7A1m9Ya2U9vg_434260096_29798991;Max-Age=864000;path=/;HttpOnly"));
//                StringEntity entity = new StringEntity("{}","utf-8");
//                entity.setContentEncoding("UTF-8");
//                //entity.setContentType("application/json");
//                httpPost.setEntity(entity);
//                httpPost.setHeader("Content-Type", "application/json;charset=utf8");
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
//
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
