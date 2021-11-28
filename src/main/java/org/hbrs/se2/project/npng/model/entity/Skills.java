package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Skills {
    private int id;
    private String name;
    private BigInteger grade;
    private Student studentByStudentId;
    private JobAdvertisement jobAdvertisementByJobAdvertisementId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (name != null ? !name.equals(skills.name) : skills.name != null) return false;
        if (grade != null ? !grade.equals(skills.grade) : skills.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "job_advertisement_id", referencedColumnName = "id", nullable = false)
    public JobAdvertisement getJobAdvertisementByJobAdvertisementId() {
        return jobAdvertisementByJobAdvertisementId;
    }

    public void setJobAdvertisementByJobAdvertisementId(JobAdvertisement jobAdvertisementByJobAdvertisementId) {
        this.jobAdvertisementByJobAdvertisementId = jobAdvertisementByJobAdvertisementId;
    }
}
