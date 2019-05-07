package com.linm.pdd.pdd;

/**
 * 拼多多编辑详情
 */
public class PddCommitDetail {

    public static void main(String[] args) {

        String url = "https://mms.pinduoduo.com/glide/v2/mms/query/commit/detail/13988217931";
        String cookie = "PASS_ID=1-f28ZmzT4JAkW9KceVdqbTMKsDOAhu/G9M/o5gDubFIhZ8pU7KODL3reGysfbbZFKMXXBk8HSwEoVmjXQ9kUEXQ_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        String response  = HttpClientUtils.get(url,cookie);
        System.out.println("===========response:"+response);
    }
}
