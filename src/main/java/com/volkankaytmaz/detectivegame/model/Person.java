package com.volkankaytmaz.detectivegame.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person_list")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserList role;

    private boolean isGuilty;
    private boolean isInterrogated;

    @Column(columnDefinition = "TEXT")
    private String alibi;

    @Column(columnDefinition = "TEXT")
    private String background;

    public Person() {
    }

    public Person(String name, UserList role, boolean isGuilty, boolean isInterrogated, String alibi, String background) {
        this.name = name;
        this.role = role;
        this.isGuilty = isGuilty;
        this.isInterrogated = isInterrogated;
        this.alibi = alibi;
        this.background = background;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserList getRole() {
        return role;
    }

    public void setRole(UserList role) {
        this.role = role;
    }

    public boolean isGuilty() {
        return isGuilty;
    }

    public void setGuilty(boolean guilty) {
        this.isGuilty = guilty;
    }

    public boolean isInterrogated() {
        return isInterrogated;
    }

    public void setInterrogated(boolean interrogated) {
        this.isInterrogated = interrogated;
    }

    public String getAlibi() {
        return alibi;
    }

    public void setAlibi(String alibi) {
        this.alibi = alibi;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}