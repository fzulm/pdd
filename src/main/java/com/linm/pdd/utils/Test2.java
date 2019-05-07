package com.linm.pdd.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Test2 {

    public static void main(String[] args) {
        String url2="https://mms.pinduoduo.com/janus/api/userinfo";
        Proxy proxy2 = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1", 8888));
        try {
            URL serverUrl = new URL(url2);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection(proxy2);

            conn.setRequestMethod("POST");

            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
            conn.addRequestProperty("Referer", "http://mms.pinduoduo.com/");
            conn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                buffer.append(line).append("\r\n");
                line = reader.readLine();
            }
            reader.close();
            conn.disconnect();
            System.out.println(buffer);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
