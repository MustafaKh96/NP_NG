package org.hbrs.se2.project.npng.dtos.impl;

import org.hbrs.se2.project.npng.dtos.ApplicationLetterDTO;

public class ApplicationLetterDTOImpl implements ApplicationLetterDTO {

    private String text;

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String getText() {
        return text;
    }
}