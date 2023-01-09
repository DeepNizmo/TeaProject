package com.spring.henallux.teaProject.dataAccess.entity;

import com.spring.henallux.teaProject.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "date")
    private Date date;

    @Column(name = "paid")
    private Boolean paid;

    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    public OrderEntity() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
