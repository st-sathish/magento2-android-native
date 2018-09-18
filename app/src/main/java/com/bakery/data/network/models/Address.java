package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Address {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("customer_id")
    private String customer_id;

    @Expose
    @SerializedName("country_id")
    private String country;

    @Expose
    @SerializedName("telephone")
    private String telephone;

    @Expose
    @SerializedName("postcode")
    private String postcode;

    @Expose
    @SerializedName("city")
    private String city;

    @Expose
    @SerializedName("firstname")
    private String firstName;

    @Expose
    @SerializedName("lastname")
    private String lastName;

    @Expose
    @SerializedName("street")
    private List<String> street;

    public String getId() {
        return id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCountry() {
        return country;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getStreet() {
        return street;
    }
}
