package com.spring.henallux.teaProject.model;

import javax.validation.constraints.*;

public class User {
    @NotNull
    @Size(min=4, max=20)
    private String username;
    @NotNull
    @Size(min=6, max=30)
    private String password;
    @NotNull
    @Size(min=6, max=30)
    private String confirmPassword;
    @Size(min=4, max=20)
    private String firstName;
    @NotNull
    @Size(min=4, max=20)
    private String lastName;
    @NotNull
    @Size(min=1, max=500)
    private String deliveryAddress;
    /*   @NotNull
       @Min(value = 1000)
       @Max(value = 99999)
       private Integer postcode;
       @NotNull
       @Size(min=3, max=100)
       private String street;
       @NotNull
       @Size(min = 3, max = 50)
       private String city;
       @NotNull
       private String country;*/
    @NotNull
    @Email
    private String email;
    @Size(max = 11)
    @Min(value = 0, message = "The value must be positive")
    private String phoneNumber = null;
    private String sex;

    public User(String username, String password,String confirmPassword,String lastName,String firstName,String deliveryAddress,String email,String phoneNumber,String sex) {
        this.username=username;
        this.password=password;
        this.lastName=lastName;
        this.firstName=firstName;
        this.deliveryAddress=deliveryAddress;
        this.email=email;
        setPhoneNumber(phoneNumber);
        this.sex=sex;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber != null && phoneNumber.isEmpty()) this.phoneNumber = null;
        else this.phoneNumber = phoneNumber;
    }

}