package com.example.wh.retrofitdemo;

public class bean {

    /**
     * token : xxxx.yyyy.zzz
     * expiredIn : 10080
     */

    private String token;
    private int expiredIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(int expiredIn) {
        this.expiredIn = expiredIn;
    }
}
