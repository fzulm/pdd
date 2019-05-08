package com.linm.pdd.business.pdd.service.impl;

import com.linm.pdd.business.pdd.service.PddService;
import com.linm.pdd.business.taobao.vo.TaobaoGoodsDetail;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddGoodsSubmitGoodsCommitRequest;
import com.pdd.pop.sdk.http.api.response.PddGoodsSubmitGoodsCommitResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pddService")
public class PddServiceImpl implements PddService {

    @Value("pdd.clientId")
    public String clientId;

    @Value("pdd.clientSecret")
    public String clientSecret;

    @Override
    public void commitGoods(TaobaoGoodsDetail taobaoGoodsDetail) {
//        String clientId = "your clientId";
//        String clientSecret = "your clientSecret";
        String accessToken = "0d3a6c46b09249e8ae66fa8550c4eafbcf52d32f";
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddGoodsSubmitGoodsCommitRequest request = new PddGoodsSubmitGoodsCommitRequest();
        request.setBuyLimit(0L);
        List<String> carouselGallery = new ArrayList();
        carouselGallery.add("str");
        request.setCarouselGallery(carouselGallery);
        request.setCatId(0L);
        request.setCostTemplateId(0L);
        request.setCountryId(0);
        request.setCustomerNum(0L);
        request.setCustoms("str");
        List<String> detailGallery = new ArrayList();
        detailGallery.add("str");
        request.setDetailGallery(detailGallery);
        request.setGoodsCommitId(0L);
        request.setGoodsDesc("str");
        request.setGoodsId(0L);
        request.setGoodsName("str");
        List<PddGoodsSubmitGoodsCommitRequest.GoodsPropertiesItem> goodsProperties = new ArrayList();
        PddGoodsSubmitGoodsCommitRequest.GoodsPropertiesItem item = new PddGoodsSubmitGoodsCommitRequest.GoodsPropertiesItem();
        item.setGroupId(0);
        item.setImgUrl("str");
        item.setNote("str");
        item.setParentSpecId(0L);
        item.setSpecId(0L);
        item.setTemplatePid(0L);
        item.setValue("str");
        item.setValueUnit("str");
        item.setVid(0L);
        goodsProperties.add(item);
        request.setGoodsProperties(goodsProperties);
        request.setGoodsType(0);
        request.setImageUrl("str");
        request.setInvoiceStatus(0);
        request.setIsCustoms(false);
        request.setIsFolt(false);
        request.setIsPreSale(false);
        request.setIsRefundable(false);
        request.setMaiJiaZiTi("str");
        request.setMarketPrice(0L);
        request.setOrderLimit(0L);
        request.setOutGoodsId("str");
        PddGoodsSubmitGoodsCommitRequest.OverseaGoods overseaGoods = new PddGoodsSubmitGoodsCommitRequest.OverseaGoods();
        overseaGoods.setBondedWarehouseKey("str");
        overseaGoods.setConsumptionTaxRate(0);
        overseaGoods.setCustomsBroker("str");
        overseaGoods.setHsCode("str");
        overseaGoods.setValueAddedTaxRate(0);
        request.setOverseaGoods(overseaGoods);
        request.setOverseaType(0);
        request.setPreSaleTime(0L);
        request.setQuanGuoLianBao(0);
        request.setSecondHand(false);
        request.setShangMenAnZhuang("str");
        request.setShipmentLimitSecond(0L);
        List<PddGoodsSubmitGoodsCommitRequest.SkuListItem> skuList = new ArrayList();
        PddGoodsSubmitGoodsCommitRequest.SkuListItem item1 = new PddGoodsSubmitGoodsCommitRequest.SkuListItem();
        item1.setIsOnsale(0);
        item1.setLength(0L);
        item1.setLimitQuantity(0L);
        item1.setMultiPrice(0L);
        item1.setOutSkuSn("str");
        PddGoodsSubmitGoodsCommitRequest.SkuListItemOverseaSku overseaSku = new PddGoodsSubmitGoodsCommitRequest.SkuListItemOverseaSku();
        overseaSku.setMeasurementCode("str");
        overseaSku.setSpecifications("str");
        overseaSku.setTaxation(0);
        item1.setOverseaSku(overseaSku);
        item1.setPrice(0L);
        item1.setQuantity(0L);
        item1.setSpecIdList("str");
        item1.setThumbUrl("str");
        item1.setWeight(0L);
        skuList.add(item1);
        request.setSkuList(skuList);
        request.setSongHuoAnZhuang("str");
        request.setSongHuoRuHu("str");
        request.setTinyName("str");
        request.setWarehouse("str");
        request.setWarmTips("str");
        request.setZhiHuanBuXiu(0);
        PddGoodsSubmitGoodsCommitResponse response = null;
        try {
            response = (PddGoodsSubmitGoodsCommitResponse)client.syncInvoke(request, accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JsonUtil.transferToJson(response));
    }
}
