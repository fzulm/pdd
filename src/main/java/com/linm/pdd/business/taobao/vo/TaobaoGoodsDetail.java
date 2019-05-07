package com.linm.pdd.business.taobao.vo;

import java.util.List;

public class TaobaoGoodsDetail {

    private String itemId;

    private String title;

    private String subTitle;

    private List<String> images;

    private String categoryId;

    private String props;

    private List<Skus> skusList;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }


    public static class Skus{

        Long multiPrice;
        Long pirce;
        Long quantity;
        Long weight;


    }


}
