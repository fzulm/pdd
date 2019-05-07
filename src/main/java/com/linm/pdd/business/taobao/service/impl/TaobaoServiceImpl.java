package com.linm.pdd.business.taobao.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linm.pdd.business.taobao.service.TaobaoService;
import com.linm.pdd.business.taobao.vo.TaobaoGoodsDetail;
import com.linm.pdd.pdd.HttpClientUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("taobaoService")
public class TaobaoServiceImpl implements TaobaoService {


    @Override
    public TaobaoGoodsDetail getGoodsDetail(String itemNumId) {
        TaobaoGoodsDetail taobaoGoodsDetail = new TaobaoGoodsDetail();
        String url = "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/";
        String cookie = "thw=cn; cna=pN1kE9e4QwoCAdzID9BYt47f; hng=CN%7Czh-CN%7CCNY%7C156; miid=7847998291896223750; ali_ab=220.200.15.251.1531061863434.2; t=d8cdbe2632b46fab36aca78c96284ef1; cookie2=1a0154330f6afc385f4d781f366c1606; _tb_token_=e79413e63435f; v=0; skt=82c153762d0366c0; csg=34af61c7; uc3=vt3=F8dByErV7WNkmOmc5Jg%3D&id2=VAmjhLeZA1kA&nk2=F8Zg5JJo&lg2=VFC%2FuZ9ayeYq2g%3D%3D; existShop=MTU1Mjk5OTc2Ng%3D%3D; tracknick=t09013; lgc=t09013; _cc_=UtASsssmfA%3D%3D; dnk=t09013; tg=0; enc=Ok%2F5IsuLtd%2Fd1zAVg4I%2BSxIl2akkWxkfPRnnd37LHPcEe5irakCWNW1euGCe6Ts7ofg2V7GcwOozG3azCXzRdg%3D%3D; swfstore=277525; x=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0%26__ll%3D-1%26_ato%3D0; whl=-1%260%260%261553001208412; mt=ci=-1_0; JSESSIONID=544042E81BE53AF68463EA1ED1D613D2; alitrackid=www.taobao.com; lastalitrackid=www.taobao.com; uc1=cookie16=UIHiLt3xCS3yM2h4eKHS9lpEOw%3D%3D&cookie21=W5iHLLyFe3xm&cookie15=U%2BGCWk%2F75gdr5Q%3D%3D&existShop=false&pas=0&cookie14=UoTZ504Kr9OakA%3D%3D&tag=8&lng=zh_CN; isg=BOrqQ-t_QjkjJsitK_19e_BgO1BM827dEaW6QnSj0D3hp4thXOgdxXeVM5MeV-ZN; l=bBPLYkIevShZd8XzBOCiCuI8as7ttIRfguPRwN0Xi_5CJ6YYr9_Ol9nH2Fv6Vj5lO78B4XUzS2pTpFSbJs5..";
        Map<String, String> params = new HashMap<>();
        params.put("data","{\"itemNumId\":\"587600080810\"}");
        String response  = HttpClientUtils.get(url,cookie,params);
        System.out.println("===========response:"+response);
        JSONObject resJson =  JSONObject.parseObject(response);
        JSONObject data = resJson.getJSONObject("data");
        JSONObject item = data.getJSONObject("item");
        taobaoGoodsDetail.setTitle(item.getString("title"));
        taobaoGoodsDetail.setSubTitle(item.getString("subtitle"));
        taobaoGoodsDetail.setItemId(item.getString("itemId"));
        taobaoGoodsDetail.setImages(JSONObject.parseArray(item.getString("images"),String.class));
        System.out.println(data.get("item"));
        return taobaoGoodsDetail;
    }


}
