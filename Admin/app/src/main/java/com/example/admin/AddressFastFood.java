package com.example.admin;

public class AddressFastFood {

    private String address1;
    private String name_add1;
    private Long phone1;

    public AddressFastFood() {
    }

    public AddressFastFood(String address1, String name_add1, Long phone1) {
        this.address1 = address1;
        this.name_add1 = name_add1;
        this.phone1 = phone1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getName_add1() {
        return name_add1;
    }

    public void setName_add1(String name_add1) {
        this.name_add1 = name_add1;
    }

    public Long getPhone1() {
        return phone1;
    }

    public void setPhone1(Long phone1) {
        this.phone1 = phone1;
    }
}
