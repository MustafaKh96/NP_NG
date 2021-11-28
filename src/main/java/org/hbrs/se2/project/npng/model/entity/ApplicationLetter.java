package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "application_letter", schema = "Collab", catalog = "zmkass2s")
public class ApplicationLetter {
    private int id;
    private String text;
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
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
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
