package org.hbrs.se2.project.npng.dtos.impl;

import org.hbrs.se2.project.npng.dtos.StudentDTO;

import java.time.LocalDate;

public class StudentDTOImpl implements StudentDTO {

    private String firstName;
    private String lastName;
    private String highestDiploma;
    private String education;
    private LocalDate birthday;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setHighestDiploma(String highestDiploma) {
        this.highestDiploma = highestDiploma;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getHighestDiploma() {
        return highestDiploma;
    }
    @Override
    public String getEducation() {
        return education;
    }
    @Override
    public LocalDate getBirthday() {
        return birthday;
    }
}