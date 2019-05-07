package com.linm.pdd.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * 拼多多上传图片
 */
public class PddGetSignature {

    public static void main(String[] args) {
        String url = "https://mms.pinduoduo.com/galerie/business/get_signature";
        String cookie = "PASS_ID=1-I6YxYW3VYQhxK6OqtQdSI9rUK7VVDZnvhCDU8p+WW3o/ljA/7pSIl+XXccRuQPdSJiuTJehYFIYdiRqPx+lEwQ_434260096_29798991;Max-Age=864000;path=/;HttpOnly";
        //String cookie2 = "api_uid=rBQHUFxtRlpQxmYvQHlwAg==; _nano_fp=XpdyX0EjnpXxn0EyX9_dr0m~VZbhzU9zpHHRX~ns; _ga=GA1.2.836630185.1553175696; _gid=GA1.2.2096043211.1553175696; pt_s_691035c2=vt=1553175695791&cad=; pt_691035c2=uid=vaWuPmYnz-v6N66aJz-vAQ&nid=1&vid=8r18vS1oVm/5uQC8okRanQ&vn=1&pvn=1&sact=1553175700757&to_flag=0&pl=HJPHbMMwQ-lnEQahY4iRFA*pt*1553175695791; PASS_ID=1-U+lYCqxCx+S6/r7iom8hgETqeMAx5BimTHQXaH2ABuFnlQkrf5myY3U5xq+NMURUBsRR0N2qHBPN4Jk53zDD5Q_434260096_29798991";
        String entity = "{\"bucket_tag\":\"pdd_oms\"}";
        Map<String, String> params = new HashMap<>();
        params.put("bucket_tag","pdd_oms");
        String response  = HttpClientUtils.post(url,cookie,entity,null);
        System.out.println("===========response:"+response);
    }
}
