package org.hbrs.se2.project.npng.model.entity;

import org.testng.annotations.Test;

import javax.persistence.*;

@Entity
@Table(name = "skills", schema = "Collab")
public class Skills {

    private int id;
    private int student_id;
    private int job_advertisment_id;
    private String name;
    private int grade;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    @Basic
    @Column(name = "job_advertisment_id")
    public int getJob_advertisment_id() {
        return job_advertisment_id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "grade")
    public int getGrade() {
        return grade;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
