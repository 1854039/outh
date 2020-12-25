package com.example.expressservice.entity;

public class expressEntity {

    private int expressid;
    private int userid;

    public int getExpressid() {
        return expressid;
    }

    public void setExpressid(int expressid) {
        this.expressid = expressid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "expressInfo [userid=" + userid + ", expressid=" + expressid + "]";
    }
}

