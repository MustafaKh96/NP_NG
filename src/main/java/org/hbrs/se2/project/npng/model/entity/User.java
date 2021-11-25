package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table( name = "user", schema = "Collab")
public class User {


    private int id;
    private String eMail;
    private String password;
    private String street;
    private String houseNumber;
    private String plz;
    private String city;
    private String phone;
    private String contactMail;
    private String role;

    public User(){

        this.id = 0;
        this.eMail = "";
        this.password = "";
        this.street = "";
        this.houseNumber ="";
        this.plz = "";
        this.city ="";
        this.phone ="";
        this.contactMail ="";
        this.role="";

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId(){

        return this.id;
    }

    @Basic
    @Column(name = "e_mail")
    public String getEmail() {
        return this.eMail;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return this.street;
    }

    @Basic
    @Column(name = "house_number")
    public String getHouseNumber() {
        return this.houseNumber;
    }

    @Basic
    @Column(name = "plz")
    public String getPlz() {
        return this.plz;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return this.city;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return this.phone;
    }

    @Basic
    @Column(name = "contact_mail")
    public String getContactMail() {
        return this.contactMail;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return this.role;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {return this.password; }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
