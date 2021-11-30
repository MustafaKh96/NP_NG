package org.hbrs.se2.project.npng.dtos;

import java.time.LocalDate;

public interface JobAdvertismentDTO {
    String getTitle();
    String getSector();
    String getTypOfJobHiring();
    LocalDate getDate();
    String getDescritpion();
}
