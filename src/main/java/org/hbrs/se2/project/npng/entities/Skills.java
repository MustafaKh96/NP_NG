package org.hbrs.se2.project.npng.entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table( name ="skills" , schema = "Collab", catalog = "zmkass2s" )
public class Skills {
    private int id;
    private int studentId;
    private int jobAdvertisementId;
    private String name;
    private BigInteger grade;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "job_advertisement_id")
    public int getJobAdvertisementId() {
        return jobAdvertisementId;
    }

    public void setJobAdvertisementId(int jobAdvertisementId) {
        this.jobAdvertisementId = jobAdvertisementId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "grade")
    public BigInteger getGrade() {
        return grade;
    }

    public void setGrade(BigInteger grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        if (id != skills.id) return false;
        if (studentId != skills.studentId) return false;
        if (jobAdvertisementId != skills.jobAdvertisementId) return false;
        if (name != null ? !name.equals(skills.name) : skills.name != null) return false;
        if (grade != null ? !grade.equals(skills.grade) : skills.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + jobAdvertisementId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
