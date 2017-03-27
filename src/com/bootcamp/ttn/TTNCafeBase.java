package com.bootcamp.ttn;

public class TTNCafeBase {
    String id;

    public TTNCafeBase(){
        this.id = "";
    }

    public TTNCafeBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
