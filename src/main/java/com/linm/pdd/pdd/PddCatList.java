package com.linm.pdd.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * 拼多多获取分类列表
 */
public class PddCatList {

    public static void main(String[] args) {

        String url = "https://mms.pinduoduo.com/vodka/v2/mms/cat1List";
        String cookie = "PASS_ID=1-f28ZmzT4JAkW9KceVdqbTMKsDOAhu/G9M/o5gDubFIhZ8pU7KODL3reGysfbbZFKMXXBk8HSwEoVmjXQ9kUEXQ_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        Map<String, String> params = new HashMap<>();
        params.put("parentId","17412");
        String response  = HttpClientUtils.get(url,cookie,params);
        System.out.println("===========response:"+response);
    }

}
