package org.hbrs.se2.project.npng.entities;

import javax.persistence.*;

@Entity
@Table(name = "company_has_job_advertisement", schema = "Collab", catalog = "zmkass2s")
public class CompanyHasJobAdvertisement {
    private int id;
    private int companyId;
    private int jobAdvertisementId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "job_advertisement_id")
    public int getJobAdvertisementId() {
        return jobAdvertisementId;
    }

    public void setJobAdvertisementId(int jobAdvertisementId) {
        this.jobAdvertisementId = jobAdvertisementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyHasJobAdvertisement that = (CompanyHasJobAdvertisement) o;

        if (id != that.id) return false;
        if (companyId != that.companyId) return false;
        if (jobAdvertisementId != that.jobAdvertisementId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + companyId;
        result = 31 * result + jobAdvertisementId;
        return result;
    }
}
