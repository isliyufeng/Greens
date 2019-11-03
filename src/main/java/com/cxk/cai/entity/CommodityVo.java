package com.cxk.cai.entity;

public class CommodityVo {
    private Integer id;
    private Commodity commodity;
    private Integer cid;
    private Integer inventory;
    private Integer sellnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSellnumber() {
        return sellnumber;
    }

    public void setSellnumber(Integer sellnumber) {
        this.sellnumber = sellnumber;
    }

    @Override
    public String toString() {
        return "CommodityVo{" +
                "id=" + id +
                ", commodity=" + commodity +
                ", cid=" + cid +
                ", inventory=" + inventory +
                ", sellnumber=" + sellnumber +
                '}';
    }
}
