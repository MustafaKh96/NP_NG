package org.hbrs.se2.project.npng.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "job_advertisement", schema = "coll", catalog = "zmkass2s")
public class JobAdvertisement {
    private int id;
    private String title;
    private String sector;
    private String typeOfJobHiring;
    private Date startDate;
    private String description;
    private List<ApplicationLetter> applicationLetters;
    private List<Skills> skills;
    private Company company;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "sector")
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Basic
    @Column(name = "type_of_job_hiring")
    public String getTypeOfJobHiring() {
        return typeOfJobHiring;
    }

    public void setTypeOfJobHiring(String typeOfJobHiring) {
        this.typeOfJobHiring = typeOfJobHiring;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "jobAdvertisement")
    public List<ApplicationLetter> getApplicationLetters() {
        return applicationLetters;
    }

    public void setApplicationLetters(List<ApplicationLetter> applicationLetters) {
        this.applicationLetters = applicationLetters;
    }

    @OneToMany(mappedBy = "jobAdvertisement")
    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills (List<Skills> skills) {
        this.skills = skills;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public Company getCompany(){ return this.company; };

    public void setCompany(Company company){ this.company = company; };

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobAdvertisement that = (JobAdvertisement) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (sector != null ? !sector.equals(that.sector) : that.sector != null) return false;
        if (typeOfJobHiring != null ? !typeOfJobHiring.equals(that.typeOfJobHiring) : that.typeOfJobHiring != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (typeOfJobHiring != null ? typeOfJobHiring.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }



     */
}
