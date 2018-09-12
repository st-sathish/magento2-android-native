package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderRequest {

    @Expose
    @SerializedName("billing_address")
    private BillingAddress billingAddress;

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Expose
    @SerializedName("paymentMethod")
    private PaymentMethod paymentMethod;

    public static class  PaymentMethod {

        @Expose
        @SerializedName("method")
        private String method;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    public static class BillingAddress {

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("region")
        private String region;

        @Expose
        @SerializedName("region_id")
        private Integer region_id;

        @Expose
        @SerializedName("region_code")
        private String region_code;


        @Expose
        @SerializedName("country_id")
        private String country;

        @Expose
        @SerializedName("street")
        private List<String> street;

        @Expose
        @SerializedName("postcode")
        private Integer postcode;

        @Expose
        @SerializedName("city")
        private String city;

        @Expose
        @SerializedName("telephone")
        private String phone_number;


        @Expose
        @SerializedName("firstname")
        private String firstName;

        @Expose
        @SerializedName("lastname")
        private String lastName;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public Integer getRegion_id() {
            return region_id;
        }

        public void setRegion_id(Integer region_id) {
            this.region_id = region_id;
        }

        public String getRegion_code() {
            return region_code;
        }

        public void setRegion_code(String region_code) {
            this.region_code = region_code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<String> getStreet() {
            return street;
        }

        public void setStreet(List<String> street) {
            this.street = street;
        }

        public Integer getPostcode() {
            return postcode;
        }

        public void setPostcode(Integer postcode) {
            this.postcode = postcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
