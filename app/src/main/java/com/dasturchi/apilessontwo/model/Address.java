package com.dasturchi.apilessontwo.model;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("street")
    String street;
    @SerializedName("suite")
    String suite;

    public Address(String street, String suite) {
        this.street = street;
        this.suite = suite;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }
}
