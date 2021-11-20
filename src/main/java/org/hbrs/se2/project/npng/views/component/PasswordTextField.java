package org.hbrs.se2.project.npng.views.component;

import com.vaadin.flow.component.textfield.PasswordField;

public class PasswordTextField extends PasswordField {

    public PasswordTextField(String untertitel){
        this.setHeight("56px");
        this.setWidth("30vw");
        this.setPlaceholder(untertitel);
    }
}
