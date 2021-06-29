package com.company.subscriptionandaccountlist.models;

import javax.persistence.*;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Use @Column to name values differently
    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Boolean verified;

    public User(Long id, String firstname, String lastname, String email, String password, Boolean verified) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.verified = verified;
        this.password = password;
    }

    public User(String firstname, String email, String password) {
        this.firstname = firstname;
        this.password = password;
        this.email = email;
    }

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verified='" + verified + '\'' +
                '}';
    }
}
