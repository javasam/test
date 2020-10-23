package com.example.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPass;

}
