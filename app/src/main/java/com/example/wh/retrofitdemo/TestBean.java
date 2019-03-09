package com.example.wh.retrofitdemo;

public class TestBean {


    /**
     * errno : 10000
     * errmsg : 5c836670e796d
     */

    private int errno;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "errno = " + errno + ", errmsg = " + errmsg;
    }
}
