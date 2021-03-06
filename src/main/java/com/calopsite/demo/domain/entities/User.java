package com.calopsite.demo.domain.entities;

import com.calopsite.demo.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Product> product;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Vivarium> vivarium;
    private Profile profile;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Mutation> mutations;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Bird> birds;

    public User() {
        this.profile = Profile.CLIENT;
    }

    public User(Long id) {
        this.id = id;
        this.profile = Profile.CLIENT;
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = Profile.CLIENT;
    }

    public User(Long id, String name, String email, String password, Profile profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
