package org.hbrs.se2.project.npng.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String highestDiploma;
    private String education;
    private String studyCourse;
    private Date birthday;
    private Collection<ApplicationLetter> applicationLettersById;
    private Collection<Skills> skillsById;
    private User userByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "highest_diploma")
    public String getHighestDiploma() {
        return highestDiploma;
    }

    public void setHighestDiploma(String highestDiploma) {
        this.highestDiploma = highestDiploma;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "study_course")
    public String getStudyCourse() {
        return studyCourse;
    }

    public void setStudyCourse(String studyCourse) {
        this.studyCourse = studyCourse;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (highestDiploma != null ? !highestDiploma.equals(student.highestDiploma) : student.highestDiploma != null)
            return false;
        if (education != null ? !education.equals(student.education) : student.education != null) return false;
        if (studyCourse != null ? !studyCourse.equals(student.studyCourse) : student.studyCourse != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (highestDiploma != null ? highestDiploma.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (studyCourse != null ? studyCourse.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<ApplicationLetter> getApplicationLettersById() {
        return applicationLettersById;
    }

    public void setApplicationLettersById(Collection<ApplicationLetter> applicationLettersById) {
        this.applicationLettersById = applicationLettersById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<Skills> getSkillsById() {
        return skillsById;
    }

    public void setSkillsById(Collection<Skills> skillsById) {
        this.skillsById = skillsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
