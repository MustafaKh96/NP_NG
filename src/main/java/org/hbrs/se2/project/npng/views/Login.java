package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.control.LoginControl;
import org.hbrs.se2.project.npng.control.exception.DatabaseUserException;
import org.hbrs.se2.project.npng.dtos.UserDTO;
import org.hbrs.se2.project.npng.util.Globals;


@Route("Login")
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Login.css")

public class Login extends VerticalLayout {

    LoginControl loginControl = new LoginControl();

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
        component.addLoginListener(e -> {
            boolean isAuthenticated = false;
            try {
                isAuthenticated = loginControl.authentificate( e.getUsername() , e.getPassword() );

            } catch (DatabaseUserException databaseException) {
                Dialog dialog = new Dialog();
                dialog.add( new Text( databaseException.getReason()) );
                dialog.setWidth("400px");
                dialog.setHeight("150px");
                dialog.open();
            }
            if (isAuthenticated) {
                grabAndSetUserIntoSession();
                navigateToMainPage();
            } else {
                component.setError(true);
            }
        });
        add(component);
    }

    private void grabAndSetUserIntoSession() {
        UserDTO userDTO = loginControl.getCurrentUser();
        UI.getCurrent().getSession().setAttribute(Globals.CURRENT_USER, userDTO );
    }
    private void navigateToMainPage() {
        UI.getCurrent().navigate(Globals.Pages.SHOW_CARS);
    }
}