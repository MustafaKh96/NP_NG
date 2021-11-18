package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("Login")
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Login.css")

public class Login extends VerticalLayout {

    public Login(){
        LoginOverlay component = new LoginOverlay();

        // title erstellen:
        H1 title = new H1();
        title.setId("H1_Login");
        title.getStyle().set("color", "var(--lumo-base-color)");
        title.add(new Text("NP_NG"));
        component.setTitle(title);

        // Loginform erstellen:
        LoginI18n i18n = LoginI18n.createDefault();
        component.setI18n(i18n);
        component.setOpened(true);
        //LoginListener:
        //component.addLoginListener(e -> component.close());
        component.addLoginListener(e -> {
            if(e.getUsername().equals("Student")){
                UI.getCurrent().navigate(StudentView.class);
            }
            else if(e.getUsername().equals("Unternehmer")){
                UI.getCurrent().navigate(UnternehmerView.class);
            }
        });
        add(component);
    }
}