package com.example.admin;

public class Users {

    public String id;
    public String name;
    public Long phone;

    public Users ()
    {

    }

    public Users (String id, String name, Long phone)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
