package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "application_letter", schema = "Collab")

public class ApplicationLetter {

    private int id;
    private int student_id;
    private int job_advertisment_id;
    private String text;


    @Id
    @GeneratedValue
    @Column(name= "id")
    public int getId(){
        return id;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    @Basic
    @Column(name = "job_advertisment_id")
    public int getJob_advertisment_id(){
        return job_advertisment_id;
    }

    @Basic
    @Column(name = "text")
    public String getText(){
        return text;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setJob_advertisment_id(int job_advertisment_id) {
        this.job_advertisment_id = job_advertisment_id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
