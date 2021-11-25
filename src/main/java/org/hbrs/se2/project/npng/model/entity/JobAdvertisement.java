package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_advertisement", schema = "Collab")
public class JobAdvertisement {


    private int id;
    private String title;
    private String sector;
    private String type_of_job_hiring;
    private LocalDate date;
    private String description;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId(){
        return id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle(){
        return title;
    }

    @Basic
    @Column(name = "sector")
    public String getSector(){
        return sector;
    }

    @Basic
    @Column(name = "type_of_job_hiring")
    public String getType_of_job_hiring(){
        return type_of_job_hiring;
    }

    @Basic
    @Column(name = "date")
    public LocalDate getDate(){
        return date;
    }

    @Basic
    @Column(name = "description")
    public String getDescription(){
        return description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setType_of_job_hiring(String type_of_job_hiring) {
        this.type_of_job_hiring = type_of_job_hiring;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
