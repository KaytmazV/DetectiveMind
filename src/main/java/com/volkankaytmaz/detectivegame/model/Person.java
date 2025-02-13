package com.volkankaytmaz.detectivegame.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;

@Entity
@Data
@Table(name = "person_list")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Role role;
    private boolean isGuilty;
    private boolean is_interrogated;
    @Basic
    @Column(columnDefinition = "TEXT")
    private String alibi;


}
