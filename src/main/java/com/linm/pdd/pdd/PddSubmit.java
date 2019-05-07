package com.linm.pdd.pdd;

/**
 * 拼多多上架商品
 */
public class PddSubmit {

    public static void main(String[] args) {
        String url = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/submit";
        String cookie = "PASS_ID=1-D7gM/iYeWKOxFV/j/DdMqr2E7eeePaz4M6mBNTyDE8t4lW3tkOs+a+EVIG77GqsTiVqhdRRnJd/62u9FyZT05w_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
//        String entity = "{\"goods_commit_id\":\"13803496691\",\"is_onsale\":true,\"third_type\":0}";
        String entity = "{\"goods_commit_id\":\"13803209625\",\"is_onsale\":true,\"third_type\":0,\n" +
                "\"crawlerInfo\":\"0alAfxn5NytoY9Tw1uDzapWTwEwkdBp8zx_LZKswPSsRY2IBRw4UcqBa4De-tpENXGMYDmYS9rCWXxb-0Xo7om9lORTwpt9eL_XbMsusNzfkzeeewwfGFA35w61q6qvzFkRrrz7Y-x7kMjzx0sFCMlG5C_5V8vp1GB__7YEFpSDV83O7M7e9lxZnlJ4icK40j9Wfz1Q4UPHtZq7OEwOg8bX6EWe56sl1mjC5iP9uT9ldfDZx4zjGYMPcTSHfiT1mMYVcBCwl_lGTTiNVbj-amehHE8zLycoYLAVwG7tDRT-_vQWu9x42JhjDRywJuHeKHTCK8VaO80OPpJhZFTOv64vytD0wCeqrA21lIcbQHfKHFpJdSvGQmT7muOG-kbIgPXawaVYwQ406RFFrMmBw3ZK2FJVBJNX8hG4ziuUYM5ZweEUiboR2W6-dzxt3WpAirxIyFLvRLeR90A_AUP\"}\n";
        String response  = HttpClientUtils.post(url,cookie,entity,null);
        System.out.println("===========response:"+response);
    }
}
