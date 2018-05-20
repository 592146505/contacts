package com.roamer.contacts.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户类
 * @author roamer
 */
@Data
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
