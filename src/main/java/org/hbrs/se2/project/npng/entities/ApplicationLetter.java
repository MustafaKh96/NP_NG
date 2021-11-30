package org.hbrs.se2.project.npng.entities;

import javax.persistence.*;

@Entity
@Table(name = "application_letter", schema = "Collab", catalog = "zmkass2s")
public class ApplicationLetter {
    private int id;
    private int studentId;
    private int jobAdvertisementId;
    private String text;

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
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationLetter that = (ApplicationLetter) o;

        if (id != that.id) return false;
        if (studentId != that.studentId) return false;
        if (jobAdvertisementId != that.jobAdvertisementId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + jobAdvertisementId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
