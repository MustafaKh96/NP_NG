package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "company_has_job_advertisement", schema = "Collab", catalog = "zmkass2s")
public class CompanyHasJobAdvertisement {
    private int id;
    private Company companyByCompanyId;
    private JobAdvertisement jobAdvertisementByJobAdvertisementId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyHasJobAdvertisement that = (CompanyHasJobAdvertisement) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
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
