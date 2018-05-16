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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;
}
