package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "job_advertisement", schema = "Collab", catalog = "zmkass2s")
public class JobAdvertisement {
    private int id;
    private String title;
    private String sector;
    private String typeOfJobHiring;
    private Date startDate;
    private String description;
    private Collection<ApplicationLetter> applicationLettersById;
    private Collection<CompanyHasJobAdvertisement> companyHasJobAdvertisementsById;
    private Collection<Skills> skillsById;

    @Id
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

    @OneToMany(mappedBy = "jobAdvertisementByJobAdvertisementId")
    public Collection<ApplicationLetter> getApplicationLettersById() {
        return applicationLettersById;
    }

    public void setApplicationLettersById(Collection<ApplicationLetter> applicationLettersById) {
        this.applicationLettersById = applicationLettersById;
    }

    @OneToMany(mappedBy = "jobAdvertisementByJobAdvertisementId")
    public Collection<CompanyHasJobAdvertisement> getCompanyHasJobAdvertisementsById() {
        return companyHasJobAdvertisementsById;
    }

    public void setCompanyHasJobAdvertisementsById(Collection<CompanyHasJobAdvertisement> companyHasJobAdvertisementsById) {
        this.companyHasJobAdvertisementsById = companyHasJobAdvertisementsById;
    }

    @OneToMany(mappedBy = "jobAdvertisementByJobAdvertisementId")
    public Collection<Skills> getSkillsById() {
        return skillsById;
    }

    public void setSkillsById(Collection<Skills> skillsById) {
        this.skillsById = skillsById;
    }
}
