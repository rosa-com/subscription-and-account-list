package com.company.subscriptionandaccountlist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//POJO
@Entity(name = "contact_forms") // Have a better naming system
public class ContactUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String email;
    private String concern;

    public ContactUser(String firstname, String email, String concern) {
        this.firstname = firstname;
        this.email = email;
        this.concern = concern;
    }

    public ContactUser() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    @Override
    public String toString() {
        return "ContactUser{" +
                "firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", concern='" + concern + '\'' +
                '}';
    }


}
