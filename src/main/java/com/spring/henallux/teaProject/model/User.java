package com.spring.henallux.teaProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    @NotNull
    @Size(min=4, max=20)
    private String username;
    @NotNull
    @Size(min=6, max=30)
    private String password;
    @NotNull
    @Size(min=6, max=30)
    private String confirmPassword;
    @Size(max=20)
    private String firstName;
    @NotNull
    @Size(min=3,max=20)
    private String lastName;
    @NotNull
    @Size(min=1, max=500)
    private String deliveryAddress;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(max = 11)
    @Min(value = 0, message = "phoneError")
    private String phoneNumber = null;
    private String sex;
    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    public User(String username, String password,String confirmPassword,String lastName,String firstName,String deliveryAddress,String email,String phoneNumber,String sex,String authorities, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        this.username=username;
        this.password=password;
        this.confirmPassword=confirmPassword;
        this.lastName=lastName;
        setFirstname(firstName);
        this.deliveryAddress=deliveryAddress;
        this.email=email;
        this.phoneNumber=phoneNumber;
        setSex(sex);
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
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

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        if(firstname!= null && firstname.isEmpty()) this.firstName = null;
        else this.firstName = firstname;
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
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        if(sex != null && sex.isEmpty()) this.sex = null;
        else this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
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
