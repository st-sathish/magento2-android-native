package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
            return "banktransfer";
        }
    }

    public static class BillingAddress {

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("state")
        private String state;

        @Expose
        @SerializedName("country")
        private String country;

        @Expose
        @SerializedName("street")
        private String street;

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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
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
