package com.dasturchi.apilessontwo.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    Address address;

    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
