package org.hbrs.se2.project.npng.control;

import org.hbrs.se2.project.npng.entities.Company;
import org.hbrs.se2.project.npng.entities.Student;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationControl {

    @Autowired
    private StudentRepository studentRepository;
    private CompanyRepository companyRepository;

    public void studentRegistration(Student student){
        studentRepository.save(student);
    }
    public void companyRegistration(Company company){
        companyRepository.save(company);
    }
}