package com.linm.pdd.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * 拼多多上传图片
 */
public class PddEdit {

    public static void main(String[] args) {
        String url = "https://mms.pinduoduo.com/glide/mms/goodsCommit/action/edit";
        String cookie = "PASS_ID=1-I6YxYW3VYQhxK6OqtQdSI9rUK7VVDZnvhCDU8p+WW3o/ljA/7pSIl+XXccRuQPdSJiuTJehYFIYdiRqPx+lEwQ_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        //String cookie2 = "api_uid=rBQHUFxtRlpQxmYvQHlwAg==; _nano_fp=XpdyX0EjnpXxn0EyX9_dr0m~VZbhzU9zpHHRX~ns; _ga=GA1.2.836630185.1553175696; _gid=GA1.2.2096043211.1553175696; pt_s_691035c2=vt=1553175695791&cad=; pt_691035c2=uid=vaWuPmYnz-v6N66aJz-vAQ&nid=1&vid=8r18vS1oVm/5uQC8okRanQ&vn=1&pvn=1&sact=1553175700757&to_flag=0&pl=HJPHbMMwQ-lnEQahY4iRFA*pt*1553175695791; PASS_ID=1-U+lYCqxCx+S6/r7iom8hgETqeMAx5BimTHQXaH2ABuFnlQkrf5myY3U5xq+NMURUBsRR0N2qHBPN4Jk53zDD5Q_434260096_29798991";
        String entity = "{\"goods_id\":6737656518,\"goods_commit_id\":\"13803209625\",\"goods_commit_check\":[],\"reject_reason\":[],\"reject_status\":\"\",\"check_status\":9,\n" +
                "\"tiny_name\":\"\",\"goods_name\":\"钻石吊坠18K金项链\",\"video_url\":\"\",\"detail_video\":[],\"goods_desc\":\"钻石吊坠18K金项链\",\n" +
                "\"warm_tips\":\"\",\"cat_id\":17453,\"cats\":[\"饰品/流行首饰/时尚饰品\",\"项坠/吊坠\",\"项坠/吊坠\",null],\"image_url\":\"\",\"fabric\":\"\",\n" +
                "\"fabric_content\":\"\",\"paper_length\":\"\",\"paper_net_weight\":\"\",\"paper_plies_num\":\"\",\"paper_width\":\"\",\"shelf_life\":\"\",\n" +
                "\"start_production_date\":null,\"end_production_date\":null,\"production_license\":\"\",\"production_standard_number\":\"\",\"oversea_goods\":{},\n" +
                "\"propertys_isbn\":{},\"propertys_standard\":[],\"is_draft\":false,\"isHighDanger\":false,\"detail_html\":\"\",\"third_type\":0,\"cat_ids\":[17412,17426,17453,null],\n" +
                "\"propertys_tid\":11161,\"is_shop\":0,\"goods_type\":1,\"invoice_status\":0,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\n" +
                "\"pre_sale_time\":0,\"country\":\"\",\"country_id\":\"0\",\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\n" +
                "\"cost_template_id\":22009050301568,\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\n" +
                "\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"bad_fruit_claim\":0,\n" +
                "\"lack_of_weight_claim\":1,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"skus\":[{\"id\":0,\"limit_quantity\":0,\"out_sku_sn\":\"\",\"is_onsale\":1,\n" +
                "\"thumb_url\":\"\",\"quantity_delta\":100,\"multi_price_in_yuan\":\"1314\",\"price_in_yuan\":\"1688\",\"multi_price\":131400,\"price\":168800,\"weight\":0,\"spec\":\"\",\n" +
                "\"oversea_sku\":{}}],\"market_price_in_yuan\":\"1998\",\"market_price\":199800,\"out_goods_sn\":\"\",\n" +
                "\"gallery\":[{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/3c0029d2-b292-45c5-9546-88b115daa6ee.jpg\",\"type\":1},\n" +
                "{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/dfb18662-6068-4900-ad88-060f47f8ff0a.jpg\",\"type\":1},\n" +
                "{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/10d380cb-4fc8-4f3c-88e1-1f6e1a1d7687.jpg\",\"type\":1},\n" +
                "{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/3c0029d2-b292-45c5-9546-88b115daa6ee.jpg\",\"type\":2},\n" +
                "{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/dfb18662-6068-4900-ad88-060f47f8ff0a.jpg\",\"type\":2},\n" +
                "{\"url\":\"https://t00img.yangkeduo.com/goods/images/2019-03-15/10d380cb-4fc8-4f3c-88e1-1f6e1a1d7687.jpg\",\"type\":2}],\n" +
                "\"goods_properties\":[{\"template_pid\":51367,\"template_module_id\":12766,\"pid\":23,\"value\":\"\",\"value_unit\":\"\"},\n" +
                "{\"template_pid\":51370,\"template_module_id\":12766,\"pid\":16,\"value\":\"\",\"value_unit\":\"\"},\n" +
                "{\"template_pid\":51372,\"template_module_id\":12766,\"pid\":205,\"value\":\"\",\"value_unit\":\"\"},\n" +
                "{\"template_pid\":51374,\"template_module_id\":12766,\"pid\":12,\"value\":\"\",\"value_unit\":\"\"},\n" +
                "{\"template_pid\":51376,\"template_module_id\":12766,\"pid\":32,\"value\":\"\",\"value_unit\":\"\"}],\n" +
                "\"is_auto_save\":false,\"validate_message\":\"315b5dc8efc8b57b5469d0ce2178b44dbeac7fbaba475e15627b32ccfe917680\"}";
        Map<String, String> params = new HashMap<>();
        params.put("bucket_tag","pdd_oms");
        String response  = HttpClientUtils.post(url,cookie,entity,null);
        System.out.println("===========response:"+response);
    }
}
