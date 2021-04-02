package com.example.admin;

public class AddressRestaurant {

    private String address;
    private String name_add;
    private Long phone;

    public AddressRestaurant() {
    }

    public AddressRestaurant(String address, String name_add, Long phone) {
        this.address = address;
        this.name_add = name_add;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName_add() {
        return name_add;
    }

    public void setName_add(String name_add) {
        this.name_add = name_add;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
