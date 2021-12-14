package org.hbrs.se2.project.npng.view;



import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.view.component.EmailTextField;
import org.hbrs.se2.project.npng.view.component.PasswordTextField;
import org.hbrs.se2.project.npng.view.component.RegistrationTextField;
import org.hbrs.se2.project.npng.view.layoutview.RegisterLayoutView;


@Route(value = "RegisterUnternehmer", layout = RegisterLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Register.css")

public class RegisterUnternehmerView extends VerticalLayout {
    public RegisterUnternehmerView(){
        setMargin(true);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        HorizontalLayout layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();

        // Überschriften:
        H4 h4_1 = new H4("Herzlich Willkommen bei\n No-Pain_No-Gain :)");
        H4 h4_2 = new H4("Registrieren Sie sich jetzt:");
        h4_1.setId("h4_1");
        h4_2.setId("h4_2");

        // TextFelder:
        RegistrationTextField firmaname = new RegistrationTextField("Firmaname");
        EmailTextField email = new EmailTextField("E-Mail");
        PasswordTextField password = new PasswordTextField("Password");
        PasswordTextField password_Wiederholen = new PasswordTextField("Password (Wiederholen)");

        //image erstellen:
        Image image = new Image();
        image.setSrc("images/Unternehmer.png");
        image.setAlt("Logo");
        image.setId("image_Unternehmer");
        add(h4_1,h4_2);
        v_layout.add(firmaname,email, password, password_Wiederholen);
        layout.add(v_layout,image);
        add(layout);

        // Butten erstellen:
        Button registrieren = new Button("registrieren");
        Button zurueck = new Button("Zurück");
        registrieren.setId("Unternehmer_Buttons");
        zurueck.setId("Unternehmer_Buttons");
        zurueck.addClickListener(e -> navigateToRegisterStartseiteView());
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(zurueck, registrieren);
        add(horizontalLayout);
    }
    private void navigateToRegisterStartseiteView(){
        UI.getCurrent().navigate(StartseiteView.class);
    }
}