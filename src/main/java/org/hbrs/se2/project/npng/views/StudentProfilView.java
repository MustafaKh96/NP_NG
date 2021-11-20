package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.layoutview.StudentLayoutview;

@Route(value = "StudentProfil", layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")


public class StudentProfilView extends Div {
    public StudentProfilView(){
        Button profil_bearbeiten = new Button("Profil bearbeiten");
        profil_bearbeiten.addClickListener(e -> navigateToStudentProfilBearbeitenView());
        add(profil_bearbeiten);

    }
    private void navigateToStudentProfilBearbeitenView(){
        UI.getCurrent().navigate(StudentProfilBearbeitenView.class);
    }
}