package org.hbrs.se2.project.npng.dtos;

import java.time.LocalDate;

public interface StudentDTO {
    String getFirstName();
    String getLastName();
    String getHighestDiploma();
    String getEducation();
    LocalDate getBirthday();
}