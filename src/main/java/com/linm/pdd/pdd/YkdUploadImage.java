package com.linm.pdd.pdd;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;

/**
 * 拼多多上传图片
 */
public class YkdUploadImage {

    public static void main(String[] args) throws IOException {
        String url = "https://file.yangkeduo.com/v3/store_image";
        String cookie = "api_uid=rBUGYFxtRluofWUuYuImAg==; _ga=GA1.2.1984918055.1553175643; _gid=GA1.2.685496082.1553175643";

//        StringBody upload_sign = new StringBody("ead26800f7804db5ef66bc39124028c391db5c79",ContentType.TEXT_PLAIN);
//        StringBody filename = new StringBody("89f815d0-4ca6-11e9-bbb2-e5f3bb9dcb09",ContentType.TEXT_PLAIN);
//        HttpEntity reqEntity = MultipartEntityBuilder.create()
//                .addPart("upload_sign", upload_sign)
//                .addPart("filename", filename)
//                .build();

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        File file = new File("E:\\pdd\\pic\\122.jpg");
        multipartEntityBuilder.addBinaryBody("image",file,ContentType.create("image/jpeg"),"89f815d0-4ca6-11e9-bbb2-e5f3bb9dcb09.jpg");
        multipartEntityBuilder.addTextBody("upload_sign", "c386336a815c5d07a056f5db95d493cd01677641");
        multipartEntityBuilder.addTextBody("filename", "89f815d0-4ca6-11e9-bbb2-e5f3bb9dcb09");
        HttpEntity httpEntity = multipartEntityBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        //httpPost.addHeader(new BasicHeader("Cookie",cookie));
        httpPost.setEntity(httpEntity);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity resultEntity = response.getEntity();
        String responseMessage = "";
        try{
            System.out.println("开始解析结果");
            if(resultEntity!=null){
                InputStream is = resultEntity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";
                while((line = br.readLine()) != null){
                    sb.append(line);
                }
                responseMessage = sb.toString();
                System.out.println("解析完成，解析内容为"+ responseMessage);
            }
            EntityUtils.consume(resultEntity);
        }finally {
            if (null != response) {
                response.close();
            }
        }
        System.out.println("===========response:"+response);
    }
}
