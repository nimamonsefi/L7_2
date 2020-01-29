package com.company.Model.entity;

public class DairyEnt {

    private long num;
    private String name;
    private String product;
    private String expire;

    public long getNum() {
        return num;
    }

    public DairyEnt setNum(long num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public DairyEnt setName(String name) {
        this.name = name;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public DairyEnt setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getExpire() {
        return expire;
    }

    public DairyEnt setExpire(String expire) {
        this.expire = expire;
        return this;
    }
}
