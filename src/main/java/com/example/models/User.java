package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Basic
    @Column(name = "login")
    private String login;

    @Basic
    @Column(name = "password")
    private String password;


    public User(String id) {
        this.id = id; // Todo for create hash of password
    }

    public void generateId() {
        if (login != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(new Date().getTime())
                    .append(login.hashCode());
            this.id = builder.toString();
        }
    }
}
