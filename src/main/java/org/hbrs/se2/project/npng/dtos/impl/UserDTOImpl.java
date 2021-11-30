package org.hbrs.se2.project.npng.dtos.impl;

import org.hbrs.se2.project.npng.dtos.UserDTO;

public class UserDTOImpl implements UserDTO {

    private int id;
    private String contactMail;
    private String role;

    public void setId(int id){
        this.id = id;
    }
    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getContactMail() {
        return contactMail;
    }
    @Override
    public String getRole() {
        return role;
    }
}