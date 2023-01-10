package com.spring.henallux.teaProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name="delivery_address")
    private String deliveryAddress;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="sex")
    private String sex;
    @Column(name="authorities")
    private String authorities;
    @Column(name="account_non_expired")
    private Boolean accountNonExpired;
    @Column(name="account_non_locked")
    private Boolean accountNonLocked;
    @Column(name="credentials_non_expired")
    private Boolean credentialsNonExpired;
    @Column(name="enabled")
    private Boolean enabled;

    /*
    MAPPING UNE FOIS QUE ORDERENTITY SERA CREE
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private Collection<OrderEntity> orderEntities;*/

    public UserEntity() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        this.phoneNumber = phoneNumber;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

/*
    public Collection<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(Collection<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}*/