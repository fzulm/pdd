package com.linm.pdd.business.taobao.web;

import com.linm.pdd.business.taobao.service.TaobaoService;
import com.linm.pdd.business.taobao.vo.TaobaoGoodsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 淘宝服务
 */
@RestController
@RequestMapping(value = "/admin/taobao/goods")
public class TaobaoController {

    @Autowired
    private TaobaoService taobaoService;

    @RequestMapping({"/detail"})
    public TaobaoGoodsDetail getDetail(Map params) {
        return taobaoService.getGoodsDetail(null);
    }

    /**
     * 搜索产品
     * @param params
     */
    @RequestMapping({"/search"})
    public void searchGoods(Map params) {
        taobaoService.getGoodsDetail(null);
    }

}
