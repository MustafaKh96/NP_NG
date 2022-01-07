package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;


@Route(value = "Einstellung",layout = StudentLayoutview.class)
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")
@PageTitle("No-Pain_No-Gain")
public class Einstellung extends VerticalLayout {

    private Dialog dialog = new Dialog();
    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private UserRepository userRepository;

    public Einstellung(UserRepository userRepository){
        this.userRepository = userRepository;
        Button loschen = new Button("Konto löschen");
        loschen.setId("cancel_save");
        Paragraph text4 = new Paragraph("möchten Sie Ihr Konto wirklich löschen?");
        Button closeButton5_1 = new Button("nein");
        closeButton5_1.addClickListener(e -> dialog.close());
        Button loginButton5_2 = new Button("ja");
        HorizontalLayout layout_h_dialog5 = new HorizontalLayout();
        layout_h_dialog5.add(closeButton5_1, loginButton5_2);
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text4, layout_h_dialog5);
        dialog.add(layout_dialog5);
        loginButton5_2.addClickListener( e -> {
            userRepository.delete(user);
            dialog.close();
            UI.getCurrent().navigate(StartseiteView.class);
        });
        loschen.addClickListener( e -> dialog.open());
        add(loschen);
    }
}