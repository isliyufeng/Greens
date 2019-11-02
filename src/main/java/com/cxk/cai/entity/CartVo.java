package com.cxk.cai.entity;

/**
 * 用于返回订单和订单信息以及对应的商品详情
 *
 * @author 喜闻乐见i
 */
public class CartVo {
    private Integer cartId;
    private Integer cid;
    private Integer uid;
    private Commodity commodity;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
