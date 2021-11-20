package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.component.EmailTextField;
import org.hbrs.se2.project.npng.views.component.PasswordTextField;
import org.hbrs.se2.project.npng.views.component.RegistrationTextField;
import org.hbrs.se2.project.npng.views.layoutview.RegisterLayoutView;

@Route(value = "RegisterStudent", layout = RegisterLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Register.css")

public class RegisterStudentView extends VerticalLayout {

    public RegisterStudentView(){
        setMargin(true);
        setDefaultHorizontalComponentAlignment(Alignment.START);

        // Layout:
        HorizontalLayout h_layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();


        // Überschriften:
        H4 h4_1 = new H4("Herzlich Willkommen bei\n No-Pain_No-Gain :)");
        H4 h4_2 = new H4("Registrieren Sie sich jetzt:");
        h4_1.setId("h4_1");
        h4_2.setId("h4_2");

        // TextFelder:
        RegistrationTextField vorname = new RegistrationTextField("Vorname");
        RegistrationTextField nachname = new RegistrationTextField("Nachname");
        EmailTextField email = new EmailTextField("E-Mail");
        PasswordTextField password = new PasswordTextField("Password");
        PasswordTextField password_Wiederholen = new PasswordTextField("Password (Wiederholen)");

        // Image erstellen:
        Image image = new Image();
        image.setSrc("images/Student.png");
        image.setAlt("Logo");
        image.setId("image_student");

        // Butten erstellen:
        Button registrieren = new Button("registrieren");
        registrieren.setId("student_registrieren");
        Button zurueck = new Button("Zurück");
        registrieren.setId("Student_Buttons");
        zurueck.setId("Student_Buttons");
        zurueck.addClickListener(e -> navigateToRegisterStartseiteView());
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(zurueck, registrieren);


        // Layout:
        v_layout.add(vorname, nachname, email, password, password_Wiederholen);
        h_layout.add(v_layout, image);

        // Add:
        add(h4_1, h4_2);
        add(h_layout);
        add(horizontalLayout);

    }
    private void navigateToRegisterStartseiteView(){
        UI.getCurrent().navigate(StartseiteView.class);
    }
}