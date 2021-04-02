package com.example.admin;

public class Address {

    private String deliver;
    private String pick;

    public Address() {
    }

    public Address(String deliver, String pick) {
        this.deliver = deliver;
        this.pick = pick;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }
}
