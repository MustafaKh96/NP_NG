package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table( name = "company", schema = "Collab")
public class Company {

    private int id;
    private int user_id;
    private String name;
    private String sector;
    private String headOffice;
    private String numberOfEmployee;
    private String foundingYear;
    private int numberOfLocations;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "sector")
    public String getSector() {
        return sector;
    }

    @Basic
    @Column(name = "head_office")
    public String getHeadOffice() {
        return headOffice;
    }

    @Basic
    @Column(name = "number_of_employee")
    public String getNumberOfEmployee() {
        return numberOfEmployee;
    }

    @Basic
    @Column(name = "founding_year")
    public String getFoundingYear() {
        return foundingYear;
    }

    @Basic
    @Column(name = "number_of_locations")
    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public void setNumberOfEmployee(String numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setFoundingYear(String foundingYear) {
        this.foundingYear = foundingYear;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }
}
