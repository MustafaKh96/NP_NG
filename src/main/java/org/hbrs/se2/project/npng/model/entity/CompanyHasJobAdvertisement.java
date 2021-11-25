package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "company_has_job_advertisement", schema = "Collab")
public class CompanyHasJobAdvertisement {

    private int id;
    private int company_id;
    private int job_advertisment_id;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId(){
        return id;
    }

    @Basic
    @Column(name = "company_id")
    public int getCompany_id() {
        return company_id;
    }

    @Basic
    @Column(name = "job_advertisment_id")
    public int getJob_advertisment_id(){
        return job_advertisment_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public void setJob_advertisment_id(int job_advertisment_id) {
        this.job_advertisment_id = job_advertisment_id;
    }
}
